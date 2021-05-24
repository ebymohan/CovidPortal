package com.nila.covidportal.controllers;

import java.util.ArrayList;
import java.util.List;

import com.nila.covidportal.models.District;
import com.nila.covidportal.models.State;
import com.nila.covidportal.services.DataServices;
import com.nila.covidportal.services.URLServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @Autowired
    URLServices fetchURL;
    @Autowired
    DataServices ds;

    @GetMapping("/api/v2/refreshstates")
    public String refreshStates()
    {
        // URLServices fetchURL=new URLServices();
        // DataServices ds = new DataServices();
        // String result = "Failure";
        String rawURL="https://cdn-api.co-vin.in/api/v2/admin/location/states";
        
        String apiRawData=fetchURL.getData(rawURL);

        //Separate the array and other TTL schemas
        //TODO a better way of doing this
        apiRawData=apiRawData.substring(10,apiRawData.length()-10);


        List<State> states=ds.parseJsonToStateList(apiRawData);

        List<String> result = new ArrayList<String>();

        for (State state : states)
        {
            result.add(state.getStateName());
        }

        return result.toString();



        // return states.toString();
        // return result;
    }
    @GetMapping("/api/v2/refreshdistricts")
    public String refreshDistricts(@RequestParam Integer stateid)
    {
        // URLServices fetchURL=new URLServices();
        // DataServices ds = new DataServices();
        // String result = "Failure";
        String rawURL="https://cdn-api.co-vin.in/api/v2/admin/location/districts/"+stateid;
        
        String apiRawData=fetchURL.getData(rawURL);
        //Separate the array and other TTL schemas
        //TODO a better way of doing this
        apiRawData=apiRawData.substring(13,apiRawData.length()-10);

        List<District> districts=ds.parseJsonToDistrictList(apiRawData);

        List<String> result = new ArrayList<String>();

        for (District district : districts)
        {
            result.add(district.getDistrictName());
        }

        return result.toString();
        // return result;
    }
}
