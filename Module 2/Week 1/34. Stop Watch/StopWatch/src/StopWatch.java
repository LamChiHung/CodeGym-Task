import java.time.Duration;
import java.time.LocalTime;


public class StopWatch {
    private LocalTime startTime = LocalTime.now();
    private LocalTime stopTime;
    public StopWatch(){
    }
    public LocalTime start(){
        this.startTime = LocalTime.now();
        return startTime;
    }
    public LocalTime stop(){
        this.stopTime = LocalTime.now();
        return stopTime;
    }
    public int getElapsedTime(){
        Duration duration =  Duration.between(this.startTime, this.stopTime);
        return duration.getNano();
    }

}
