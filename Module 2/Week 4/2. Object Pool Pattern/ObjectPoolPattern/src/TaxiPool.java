import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class TaxiPool {
    private static final long EXPIRED_TIME_IN_MILISECOND = 1200;
    private static final int NUMBER_OF_TAXI = 4;
    private final List <Taxi> avaible = Collections.synchronizedList(new ArrayList <>());
    private final List <Taxi> inUse = Collections.synchronizedList(new ArrayList <>());
    private final AtomicInteger count = new AtomicInteger(0);
    private final AtomicBoolean waiting = new AtomicBoolean(false);

    public synchronized void release(Taxi taxi) {
        inUse.remove(taxi);
        avaible.add(taxi);
        System.out.println(taxi.getName() + " is free");
    }

    public synchronized Taxi getTaxi() throws TaxiNotFoundException {
        if (! avaible.isEmpty()) {
            Taxi taxi = avaible.get(0);
            inUse.add(taxi);
            return taxi;
        }
        if (count.get() == NUMBER_OF_TAXI) {
            this.waitingUntilTaxiAvaible();
            return this.getTaxi();
        }
        Taxi taxi = this.createTaxi();
        inUse.add(taxi);
        return taxi;
    }

    private Taxi createTaxi() {
        waiting(200);
        Taxi taxi = new Taxi("Taxi " + count.incrementAndGet());
        System.out.println(taxi.getName() + " is created");
        return taxi;
    }

    private void waitingUntilTaxiAvaible() throws TaxiNotFoundException {
        if (waiting.get()) {
            waiting.set(false);
            throw new TaxiNotFoundException("No taxi avaible");
        }
        waiting.set(true);
        waiting(EXPIRED_TIME_IN_MILISECOND);
    }

    private void waiting(long time) {
        try {
            TimeUnit.MICROSECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
