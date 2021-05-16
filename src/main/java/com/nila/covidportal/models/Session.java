package com.nila.covidportal.models;

import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"session_id",
"date",
"available_capacity",
"min_age_limit",
"vaccine",
"slots"
})
@Generated("jsonschema2pojo")
public class Session {

@JsonProperty("session_id")
public String sessionId;
@JsonProperty("date")
public String date;
@JsonProperty("available_capacity")
public Integer availableCapacity;
@JsonProperty("min_age_limit")
public Integer minAgeLimit;
@JsonProperty("vaccine")
public String vaccine;
@JsonProperty("slots")
public List<String> slots = null;
@JsonProperty("available_capacity_dose1")
public Integer availableCapacityDose1;
@JsonProperty("available_capacity_dose2")
public Integer availableCapacityDose2;



    public Session() {
    }
    public Session(String sessionId, String date, Integer availableCapacity, Integer minAgeLimit, String vaccine, List<String> slots, Integer availableCapacityDose1, Integer availableCapacityDose2) {
        this.sessionId = sessionId;
        this.date = date;
        this.availableCapacity = availableCapacity;
        this.minAgeLimit = minAgeLimit;
        this.vaccine = vaccine;
        this.slots = slots;
        this.availableCapacityDose1 = availableCapacityDose1;
        this.availableCapacityDose2 = availableCapacityDose2;
    }
    @Override
    public String toString() {
        return "{" +
            " sessionId='" + getSessionId() + "'" +
            ", date='" + getDate() + "'" +
            ", availableCapacity='" + getAvailableCapacity() + "'" +
            ", minAgeLimit='" + getMinAgeLimit() + "'" +
            ", vaccine='" + getVaccine() + "'" +
            ", slots='" + getSlots() + "'" +
            ", availableCapacityDose1='" + getAvailableCapacityDose1() + "'" +
            ", availableCapacityDose2='" + getAvailableCapacityDose2() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Session)) {
            return false;
        }
        Session session = (Session) o;
        return Objects.equals(sessionId, session.sessionId) && Objects.equals(date, session.date) && Objects.equals(availableCapacity, session.availableCapacity) && Objects.equals(minAgeLimit, session.minAgeLimit) && Objects.equals(vaccine, session.vaccine) && Objects.equals(slots, session.slots) && Objects.equals(availableCapacityDose1, session.availableCapacityDose1) && Objects.equals(availableCapacityDose2, session.availableCapacityDose2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, date, availableCapacity, minAgeLimit, vaccine, slots, availableCapacityDose1, availableCapacityDose2);
    }
    

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAvailableCapacity() {
        return this.availableCapacity;
    }

    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public Integer getMinAgeLimit() {
        return this.minAgeLimit;
    }

    public void setMinAgeLimit(Integer minAgeLimit) {
        this.minAgeLimit = minAgeLimit;
    }

    public String getVaccine() {
        return this.vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public Integer getAvailableCapacityDose1() {
        return this.availableCapacityDose1;
    }

    public void setAvailableCapacityDose1(Integer availableCapacityDose1) {
        this.availableCapacityDose1 = availableCapacityDose1;
    }

    public Integer getAvailableCapacityDose2() {
        return this.availableCapacityDose2;
    }

    public void setAvailableCapacityDose2(Integer availableCapacityDose2) {
        this.availableCapacityDose2 = availableCapacityDose2;
    }

    public List<String> getSlots() {
        return this.slots;
    }

    public void setSlots(List<String> slots) {
        this.slots = slots;
    }







}

