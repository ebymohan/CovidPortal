package com.nila.covidportal.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"state_id",
"state_name"
})
@Entity
@Table(name = "STATE")
public class State {
    @JsonProperty("state_id")
    private Integer stateId;
    @JsonProperty("state_name")
    private String stateName;



    public State() {
    }

    public State(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName.toLowerCase();
    }

    @Override
    public String toString() {
        return "{" +
            " stateId='" + getStateId() + "'" +
            ", stateName='" + getStateName() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof State)) {
            return false;
        }
        State state = (State) o;
        return Objects.equals(stateId, state.stateId) && Objects.equals(stateName, state.stateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateId, stateName);
    }
    @Id
    @Column(name ="STATE_ID")
    public Integer getStateId() {
        return this.stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
    @Column(name ="STATE_NAME")
    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName.toLowerCase();
    }

}
