package com.nila.covidportal.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// import org.springframework.boot.autoconfigure.domain.EntityScan;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"district_id",
"district_name"
})
@Entity
@Table(name="DISTRICT")
public class District {
    @JsonProperty("district_id")
    private Integer districtId;
    @JsonProperty("district_name")
    private String districtName;



    public District() {
    }

    public District(Integer stateId, String stateName) {
        this.districtId = stateId;
        this.districtName = stateName.toLowerCase();
    }


    @Override
    public String toString() {
        return "{" +
            " districtId='" + getDistrictId() + "'" +
            ", districtName='" + getDistrictName() + "'" +
            "}";
    }




    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof District)) {
            return false;
        }
        District district = (District) o;
        return Objects.equals(districtId, district.districtId) && Objects.equals(districtName, district.districtName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(districtId, districtName);
    }


    public Integer getDistrictId() {
        return this.districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    

}
