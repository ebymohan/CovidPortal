package com.nila.covidportal.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nila.covidportal.models.Center;

public class DataServices {
    public List<Center> parseRawURLData(String json)
    {
        List<Center> centers=new ArrayList<Center>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            centers=Arrays.asList(objectMapper.readValue(json, Center[].class));
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return centers;
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
            if (curObj.getMinAgesFromSessions().contains(ageFilter))
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
}
