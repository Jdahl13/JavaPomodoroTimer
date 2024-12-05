import java.util.Timer;
import java.util.TimerTask;
/* This code was written by google AI as an example program for a standard pomodoro timer. I am using this code as a template to implement my own ideas
and improvements
 */

public class PomodoroTimer {

    //private static final int WORK_TIME = 25 * 60 * 1000; // 25 minutes in milliseconds
    //private static final int BREAK_TIME = 5 * 60 * 1000; // 5 minutes in milliseconds
    private static final int WORK_TIME = 10 * 1000; // 10 seconds for testing purposes
    private static final int BREAK_TIME = 5  * 1000; // 5 seconds for testing purposes

    private Timer timer;
    private boolean isWorkTime = true;

    public void start() {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (isWorkTime) {
                    System.out.println("Work time is over! Take a break.");
                } else {
                    System.out.println("Break time is over! Get back to work.");
                }
                isWorkTime = !isWorkTime;
                scheduleNextTimer();
            }
        };
        scheduleNextTimer();
    }

    private void scheduleNextTimer() {
        long delay = isWorkTime ? WORK_TIME : BREAK_TIME;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isWorkTime) {
                    System.out.println("Work time is over! Take a break.");
                } else {
                    System.out.println("Break time is over! Get back to work.");
                }
                isWorkTime = !isWorkTime;
                scheduleNextTimer();
            }
        }, delay);
    }

    public static void main(String[] args) {
        PomodoroTimer pomodoroTimer = new PomodoroTimer();
        pomodoroTimer.start();
    }
}