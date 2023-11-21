package ss04_class_object_in_java.excercise.stop_watch;

public class StopWatch {
    StopWatch(){

    }

    private long startTime, endTime;


    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }


}
