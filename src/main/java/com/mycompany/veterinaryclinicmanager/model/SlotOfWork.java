package com.mycompany.veterinaryclinicmanager.model;

import java.time.LocalTime;
import javax.persistence.Embeddable;
import lombok.Getter;


@Getter
@Embeddable
public class SlotOfWork {

    private LocalTime startTime;
    private LocalTime endTime;
   
    public SlotOfWork(LocalTime startTime, LocalTime endTime) {
        setStartTimeAndEndTime(startTime, endTime);
    }

    public void setStartTimeAndEndTime(LocalTime startTime, LocalTime endTime) {

        System.out.println("Start Time: " + startTime.getHour() + "End Time: " + endTime.getMinute());

        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Il tempo iniziale supera quello finale");
        } else {
            this.startTime = startTime;
            this.endTime = endTime;

        }
    }

    private static int getSeconds(LocalTime time) {
        return time.getHour() * 60 * 60 + time.getMinute() * 60;
    }

    @Override
    public String toString() {
        return "SlotOfWork [starTime=" + startTime + ", endTime=" + endTime + "]";
    }

    public boolean isOverlap(SlotOfWork slot) {

        return (getSeconds(endTime) > getSeconds(slot.getStartTime()) || getSeconds(slot.getEndTime()) < getSeconds(startTime));

    }

    public static void main(String[] args) {

        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(11, 0);

        LocalTime startTime2 = LocalTime.of(11, 0);
        LocalTime endTime2 = LocalTime.of(12, 0);
        SlotOfWork slot = new SlotOfWork(startTime, endTime);
        SlotOfWork slot2 = new SlotOfWork(startTime, endTime);
        
        System.out.println("is overlap: "+slot.isOverlap(slot2));

    }

}
