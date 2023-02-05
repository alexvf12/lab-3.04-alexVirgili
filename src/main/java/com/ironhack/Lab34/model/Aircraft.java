package com.ironhack.Lab34.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Aircraft {
    @Id
    private String model;
    private Integer seats;

    public Aircraft() {
    }

    public Aircraft(String model, Integer seats) {
        this.model = model;
        this.seats = seats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return model.equals(aircraft.model) && seats.equals(aircraft.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, seats);
    }
}
