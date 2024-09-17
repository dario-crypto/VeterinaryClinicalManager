package com.mycompany.veterinaryclinicmanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "days_of_work")

public class DayOfWork {

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private SlotOfWork slot;
    @OneToOne
    @JoinColumn(name = "day_of_week_id")
    private DayOfWeek dayOfWeek;
    @OneToOne
    @JoinColumn(name="clinic_id")
    private Clinic clinic;

    public DayOfWork(SlotOfWork slot, DayOfWeek dayOfweek, Clinic clinic) {
        this.slot = slot;
        this.dayOfWeek = dayOfweek;
        this.clinic = clinic;
    }

    public boolean checkOverlap(List<DayOfWork> days) {

        for (int i = 0; i < days.size() - 1; i++) {

            if (isOverlap(days.get(i))) {

                return true;
            }

        }

        return false;

    }

    public boolean isOverlap(DayOfWork day) {

        if (dayOfWeek.equals(day.getDayOfWeek())) {

            SlotOfWork slot = day.getSlot();

            return this.slot.isOverlap(slot);
        }
        return false;

    }

}
