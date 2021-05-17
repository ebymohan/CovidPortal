package com.nila.covidportal.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class URLServices {
    private String getUrlContents(String theUrl)  
    {  
        StringBuilder content = new StringBuilder();  
        // Use try and catch to avoid the exceptions  
        try  
        {  
            // System.out.println(theUrl);
        
            URL url = new URL(theUrl); // creating a url object  
            java.net.URLConnection urlConnection = url.openConnection(); // creating a urlconnection object  
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            // wrapping the urlconnection in a bufferedreader  
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
            String line;  
            // reading from the urlconnection using the bufferedreader  
             while ((line = bufferedReader.readLine()) != null)  
            {  
                content.append(line + "\n");  
            }  
            bufferedReader.close();  
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
        return content.toString();  
    }
    public String ekmdata()
    {
        String result="";
        String district_id="307";
        Date now = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        String date = dateFormat.format(now);
        String url="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id="+district_id+"&date="+date;
        result=this.getUrlContents(url);
        result=result.substring(11);
        // System.out.println(result);
        
        return result;
    }
}
