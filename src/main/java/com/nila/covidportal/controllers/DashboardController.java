package com.nila.covidportal.controllers;



import java.util.ArrayList;
import java.util.List;

import com.nila.covidportal.models.Center;
import com.nila.covidportal.services.DataServices;
import com.nila.covidportal.services.URLServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @GetMapping("/api/v1/dashboard")
    public String dashboard(@RequestParam(required = false,defaultValue = "") String ageFilter,@RequestParam(required = false,defaultValue = "") String vaccineFilter, @RequestParam(required = false,defaultValue = "") String doseFilter)
    {
        URLServices fetchURL=new URLServices();
        DataServices ds = new DataServices();
        String apiRawData = fetchURL.ekmdata();
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
    public String custom()
    {
        String retValue="false";
        URLServices fetchURL=new URLServices();
        DataServices ds = new DataServices();
        String apiRawData = fetchURL.ekmdata();
        List<Center> parsedOjects=ds.parseJsonToCenterList(apiRawData);
        List<Center> results= new ArrayList<Center>();
        results=ds.filterBasedOnVaccine(parsedOjects,"covaxin");
        results=ds.filterBasedOnAge(results,18);
        results=ds.filterBasedOnMaxAvailability(results);
        if (results.size()>0)
            retValue="true";
        // System.out.println(results);
        
        return retValue;
        // return results.size()+"";
    }
}
