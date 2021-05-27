package com.nila.covidportal.controllers;



import java.util.ArrayList;
import java.util.List;

import com.nila.covidportal.models.Center;
import com.nila.covidportal.services.DataServices;
import com.nila.covidportal.services.URLServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    
    @Autowired
    URLServices fetchURL;
    @Autowired
    DataServices ds;

    @GetMapping("/api/v1/dashboard")
    public String v1Dashboard(@RequestParam(required = false,defaultValue = "") String ageFilter,@RequestParam(required = false,defaultValue = "") String vaccineFilter, @RequestParam(required = false,defaultValue = "") String doseFilter)
    {
        
        String apiRawData = fetchURL.getEKMData();
        List<Center> results=ds.parseJsonToCenterList(apiRawData);
        if(!vaccineFilter.equals(""))
        {
            results=ds.filterBasedOnVaccine(results,vaccineFilter);
        }
        if(!ageFilter.equals(""))
        {
            results=ds.filterBasedOnAge(results,Integer.parseInt(ageFilter));
        }
        if(doseFilter.equals("1"))
        {
            results=ds.filterBasedOnDose1Availability(results, Integer.parseInt(ageFilter));
        }
        else if(doseFilter.equals("2"))
        {
            results=ds.filterBasedOnDose2Availability(results, Integer.parseInt(ageFilter));
        }
        return results.toString();
    }
    @GetMapping("/api/v2/dashboard")
    public String v2Dashboard()
    {
        String retValue="false";
        String apiRawData = fetchURL.getEKMData();
        List<Center> parsedOjects=ds.parseJsonToCenterList(apiRawData);
        List<Center> results= new ArrayList<Center>();
        results=ds.filterBasedOnVaccine(parsedOjects,"covaxin");
        results=ds.filterBasedOnAge(results,18);
        results=ds.filterBasedOnMaxAvailability(results,18);
        if (results.size()>0)
            retValue="true";
        // System.out.println(results);
        
        return retValue;
        // return results.size()+"";
    }

    @GetMapping("/api/v3/dashboard")
    public String v3Dashboard()
    {
        String retValue="false";
        String apiRawData = fetchURL.getEKMData();
        List<Center> parsedOjects=ds.parseJsonToCenterList(apiRawData);
        List<Center> results= new ArrayList<Center>();
        results.addAll(parsedOjects);
        // results=ds.newfilterBasedOnVaccine(results,"covaxin");
        results=ds.newfilterBasedOnAge(results,18);
        // results=ds.newfilterBasedOnAvailability(results);
        if (results.size()>0)
            retValue="true";
        // System.out.println(results);
        
        return retValue;
        // return results.toString();
    }


}
