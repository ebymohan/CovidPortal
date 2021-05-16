package com.nila.covidportal.models;

import java.util.Objects;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"vaccine",
"fee"
})
@Generated("jsonschema2pojo")
public class VaccineFee {

@JsonProperty("vaccine")
public String vaccine;
@JsonProperty("fee")
public String fee;

    public VaccineFee() {
    }

    public VaccineFee(String vaccine, String fee) {
        this.vaccine = vaccine;
        this.fee = fee;
    }
    @Override
    public String toString() {
        return "{" +
            " vaccine='" + getVaccine() + "'" +
            ", fee='" + getFee() + "'" +
            "}";
    }

    public String getVaccine() {
        return this.vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getFee() {
        return this.fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VaccineFee)) {
            return false;
        }
        VaccineFee vaccineFee = (VaccineFee) o;
        return Objects.equals(vaccine, vaccineFee.vaccine) && Objects.equals(fee, vaccineFee.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaccine, fee);
    }



}