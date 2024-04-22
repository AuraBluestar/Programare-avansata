package lab7.lab_7;

public class TimeKeeper implements Runnable {

    private long timeLimit;
    private long runningTime;
    private Thread game;

    public TimeKeeper(Thread game, long timeLimit) {
        this.game = game;
        this.timeLimit = timeLimit;
    }

    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();
        long timeDiff = startingTime;
        runningTime = System.currentTimeMillis();
        while ((runningTime - startingTime) <= timeLimit) {
            runningTime = System.currentTimeMillis();
            if (runningTime - timeDiff >= 60000) {
                timeDiff = runningTime;
                System.out.println(runningTime);
            }
        }
        this.game.interrupt();
    }

    public long getRunningTime() {
        return runningTime;
    }
}
