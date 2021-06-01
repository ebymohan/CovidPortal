package com.nila.covidportal.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nila.covidportal.models.District;
import com.nila.covidportal.models.Center;
import com.nila.covidportal.models.State;
import com.nila.covidportal.repository.DistrictRepository;
import com.nila.covidportal.repository.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServices { 




    public final StateRepository stateRepository;
    public final DistrictRepository districtRepository;
    
    @Autowired
    public DataServices(StateRepository stateRepository,DistrictRepository districtRepository) {
        this.stateRepository = stateRepository;
        this.districtRepository = districtRepository;
    }
    
    // @Autowired
    // public DataServices(DistrictRepository districtRepository) {
    //     this.districtRepository = districtRepository;
    // }

    public List<Center> parseJsonToCenterList(String json)
    {
        List<Center> centers=new ArrayList<Center>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            centers=Arrays.asList(objectMapper.readValue(json, Center[].class));
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return centers;
    }

    public List<State> parseJsonToStateList(String json)
    {
        List<State> states=new ArrayList<State>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            states=Arrays.asList(objectMapper.readValue(json, State[].class));
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        stateRepository.saveAll(states);
        return states;
        // return stateRepository.findAll();
    }
    
    public List<District> parseJsonToDistrictList(String json) 
    {
        List<District> districts=new ArrayList<District>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            districts=Arrays.asList(objectMapper.readValue(json, District[].class));
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        districtRepository.saveAll(districts);
        return districts;
    }

    public List<Center> filterBasedOnVaccine(List<Center> centers, String vaccineFilter) {
        List<Center> results=new ArrayList<Center>();
        for (Center curObj : centers)
        {
            if (curObj.getVaccinesFromSessions().contains(vaccineFilter.toLowerCase()))
            {
                results.add(curObj);
            }
        }
        
        return results;
    }

    public List<Center> filterBasedOnAge(List<Center> centers, int ageFilter) {
        List<Center> results=new ArrayList<Center>();
        for (Center curObj : centers)
        {
            if (curObj.getMinAgeLimitsFromSessions().contains(ageFilter))
            {
                results.add(curObj);
            }
        }
        
        return results;
    }
    public List<Center> filterBasedOnDose1Availability(List<Center> centers, int ageFilter) {
        List<Center> results=new ArrayList<Center>();
        for (Center curObj : centers)
        {
            if (curObj.getMaxDose1AvailabilityFromSessions(ageFilter)>0)
            {
                results.add(curObj);
            }
        }
        
        return results;
    }

    public List<Center> filterBasedOnDose2Availability(List<Center> centers, int ageFilter) {
        List<Center> results=new ArrayList<Center>();
        for (Center curObj : centers)
        {
            if (curObj.getMaxDose2AvailabilityFromSessions(ageFilter)>0)
            {
                results.add(curObj);
            }
        }
        
        return results;
    }
    public List<Center> filterBasedOnMaxAvailability(List<Center> centers, int ageFilter) {
        List<Center> results=new ArrayList<Center>();
        for (Center curObj : centers)
        {
            if (curObj.getMaxAvailabilityFromSessions(ageFilter) > 0)
            {
                results.add(curObj);
            }
        }
        return results;
    }

    public List<Center> newfilterBasedOnVaccine(List<Center> centers, String vaccineFilter) {
        
        List<Center> results=new ArrayList<Center>();
        for (Center curObj : centers)
        {
            if (curObj.getVaccinesFromSessions().contains(vaccineFilter.toLowerCase()))
            {
                curObj.filterSessionBasedOnVaccine(vaccineFilter);
                results.add(curObj);
            }
        }
        return results;
    }
    public List<Center> newfilterBasedOnAge(List<Center> centers, int ageFilter) {
        List<Center> results=new ArrayList<Center>();
        for (Center curObj : centers)
        {
            if (curObj.getMinAgeLimitsFromSessions().contains(ageFilter))
            {
                curObj.filterSessionBasedOnAge(ageFilter);
                results.add(curObj);
            }
        }
        
        return results;
    }

    public List<Center> newfilterBasedOnAvailability(List<Center> centers) {
        List<Center> results=new ArrayList<Center>();
        for (Center curObj : centers)
        {
            if (curObj.getMaxAvailabilityFromSessions()>0 || curObj.getMaxDose1AvailabilityFromSessions()>0 || curObj.getMaxDose2AvailabilityFromSessions()>0)
            {
                results.add(curObj);
            }
        }
        
        return results;
    }
    

}
