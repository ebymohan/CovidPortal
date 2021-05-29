package com.nila.covidportal.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"center_id",
"name",
"address",
"state_name",
"district_name",
"block_name",
"pincode",
"lat",
"long",
"from",
"to",
"fee_type",
"sessions",
"vaccine_fees"
})
public class Center {
    @JsonProperty("center_id")
    public Integer centerId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("address")
    public String address;
    @JsonProperty("state_name")
    public String stateName;
    @JsonProperty("district_name")
    public String districtName;
    @JsonProperty("block_name")
    public String blockName;
    @JsonProperty("pincode")
    public Integer pincode;
    @JsonProperty("lat")
    public Integer lat;
    @JsonProperty("long")
    public Integer _long;
    @JsonProperty("from")
    public String from;
    @JsonProperty("to")
    public String to;
    @JsonProperty("fee_type")
    public String feeType;
    @JsonProperty("sessions")
    public List<Session> sessions = null;
    @JsonProperty("vaccine_fees")
    public List<VaccineFee> vaccineFees = null;




    public Center() {
    }
    public Center(Integer centerId, String name, String address, String stateName, String districtName, String blockName, Integer pincode, Integer lat, Integer _long, String from, String to, String feeType, List<Session> sessions, List<VaccineFee> vaccineFees) {
        this.centerId = centerId;
        this.name = name;
        this.address = address;
        this.stateName = stateName;
        this.districtName = districtName;
        this.blockName = blockName;
        this.pincode = pincode;
        this.lat = lat;
        this._long = _long;
        this.from = from;
        this.to = to;
        this.feeType = feeType;
        this.sessions = sessions;
        this.vaccineFees = vaccineFees;
    }

    public void filterSessionBasedOnAge(int ageFilter)
    {
        List<Session> newSessions = new ArrayList<Session>();
        for (Session curObj : this.sessions)
        {
            if (curObj.getMinAgeLimit()==ageFilter)
            {
                newSessions.add(curObj);
            }
        }
        this.sessions=newSessions;
        // return this;
    }

    public void filterSessionBasedOnVaccine(String vaccineFilter)
    {
        List<Session> newSessions = new ArrayList<Session>();
        for (Session curObj : this.sessions)
        {
            if (curObj.getVaccine().equalsIgnoreCase(vaccineFilter))
            {
                newSessions.add(curObj);
            }
        }
        this.sessions=newSessions;
        // return this;
    }


    public List<String> getVaccinesFromSessions()
    {
        List<String> result = new ArrayList<String>();
        for (Session curObj : this.sessions)
        {
            if (!(result.contains(curObj.getVaccine().toLowerCase())))
            {
                result.add(curObj.getVaccine().toLowerCase());
            }
        }
        // return result.toArray(String[]::new);
        return result;
    }
    public List<Integer> getMinAgeLimitsFromSessions()
    {
        List<Integer> result = new ArrayList<Integer>();
        for (Session curObj : this.sessions)
        {
            if (!(result.contains(curObj.getMinAgeLimit())))
            {
                result.add(curObj.getMinAgeLimit());
            }
        }
        return result;
    }
    public Integer getMaxAvailabilityFromSessions()
    {
        return this.getMaxAvailabilityFromSessions(18);
    }
    public Integer getMaxAvailabilityFromSessions(int ageFilter) //18 is default parameter
    {
        int result=0;
        for (Session curObj : this.sessions)
        {
            if (curObj.getAvailableCapacity()>0)
            {
                System.out.println(this.getName()+" : "+curObj.getMinAgeLimit()+"+ : "+curObj.getVaccine()+" : "+curObj.getAvailableCapacity());
            }
            if (curObj.getMinAgeLimit()==ageFilter && curObj.getAvailableCapacity()>result)
            {
                result=curObj.getAvailableCapacity();
            }
        }
        return result;
    }
    public Integer getMaxDose1AvailabilityFromSessions()
    {
        return this.getMaxDose1AvailabilityFromSessions(18);
    }
    public Integer getMaxDose1AvailabilityFromSessions(int ageFilter) //18 is default parameter
    {
        int result=0;
        for (Session curObj : this.sessions)
        {
            if (curObj.getMinAgeLimit()==ageFilter && curObj.getAvailableCapacityDose1()>result)
            {
                result=curObj.getAvailableCapacityDose1();
            }
        }
        return result;
    }
    public Integer getMaxDose2AvailabilityFromSessions()
    {
        return this.getMaxDose2AvailabilityFromSessions(18);
    }
    public Integer getMaxDose2AvailabilityFromSessions(int ageFilter) //18 is default parameter
    {
        int result=0;
        for (Session curObj : this.sessions)
        {
            if (curObj.getMinAgeLimit()==ageFilter && curObj.getAvailableCapacityDose2()>result)
            {
                result=curObj.getAvailableCapacityDose2();
            }
        }
        return result;
    }







    public Map<Integer,Integer> getAgeMaxCapacityMap()
    {
        Map<Integer,Integer> result = new HashMap<Integer,Integer>();
        for (Session curObj : this.sessions)
        {
            int age=curObj.getMinAgeLimit();
            int capacity=curObj.getAvailableCapacity();
            if (!(result.containsKey(age)))
            {
                result.put(age,capacity);
            }
            else
            {
                if(result.get(age)<capacity)
                {
                    result.put(age, capacity);
                }
            }
        }
        return result;
    }





    @Override
    public String toString() {
        return "{" +
            "\"centerId\":\"" + getCenterId() + "\"" +
            ", \"name\":\"" + getName() + "\"" +
            ", \"address\":\"" + getAddress() + "\"" +
            // ", \"stateName\":\"" + getStateName() + "\"" +
            // ", \"districtName\":\"" + getDistrictName() + "\"" +
            // ", \"blockName\":\"" + getBlockName() + "\"" +
            // ", \"pincode\":\"" + getPincode() + "\"" +
            // ", \"lat\":\"" + getLat() + "\"" +
            // ", \"long\":\"" + get_long() + "\"" +
            // ", \"from\":\"" + getFrom() + "\"" +
            // ", \"to\":\"" + getTo() + "\"" +
            ", \"feeType\":\"" + getFeeType() + "\"" +
            ", \"sessions\":" + getSessions() + "" +
            ", \"vaccineFees\":" + getVaccineFees() + "" +
            "}";
    }
    public Integer getCenterId() {
        return this.centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Integer getPincode() {
        return this.pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Integer getLat() {
        return this.lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer get_long() {
        return this._long;
    }

    public void set_long(Integer _long) {
        this._long = _long;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFeeType() {
        return this.feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public List<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<VaccineFee> getVaccineFees() {
        return this.vaccineFees;
    }

    public void setVaccineFees(List<VaccineFee> vaccineFees) {
        this.vaccineFees = vaccineFees;
    }
    
    }













