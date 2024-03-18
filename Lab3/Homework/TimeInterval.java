
package lab3.lab3;

import java.time.LocalTime;

public class TimeInterval extends Pair<LocalTime, LocalTime> {

    private final LocalTime opening;
    private final LocalTime closing;
    
    public TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
        opening=first;
        closing=second;
    }

    public LocalTime getOpening() {
        return opening;
    }

    public LocalTime getClosing() {
        return closing;
    }
    public void setClosing(LocalTime time){
        setSecond(time);
    }
    public void setOpening(LocalTime time){
        setFirst(time);
    }
    
}
