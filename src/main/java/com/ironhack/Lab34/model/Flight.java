package com.ironhack.Lab34.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.repository.cdi.Eager;

import java.util.Objects;

@Entity
public class Flight {
    @Id
    private String number;
    private  Long mileage;
    private String aircraft;

    public Flight() {
    }

    public Flight(String number, Long mileage, String aircraft) {
        this.number = number;
        this.mileage = mileage;
        this.aircraft = aircraft;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(number, flight.number) && Objects.equals(mileage, flight.mileage) && Objects.equals(aircraft, flight.aircraft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, mileage, aircraft);
    }
}
