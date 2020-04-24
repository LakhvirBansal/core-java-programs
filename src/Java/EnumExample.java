package Java;

import java.util.HashMap;
import java.util.Map;

public enum EnumExample {

	PROD("https://prod.domain.com:1088/"), 
    QA("https://qa.domain.com:2019/"), 
    STAG("https://stag.domain.com:8080/"), 
    DEV("https://dev.domain.com:21323/");
 
    private String url;
 
    EnumExample(String envUrl) {
        this.url = envUrl;
    }
 
    public String getUrl() {
        return url;
    }
    
    //****** Reverse Lookup Implementation************//
    
    //Lookup table
    private static final Map<String, EnumExample> lookup = new HashMap<>();
  
    //Populate the lookup table on loading time
    static
    {
        for(EnumExample env : EnumExample.values())
        {
            lookup.put(env.getUrl(), env);
        }
    }
  
    //This method can be used for reverse lookup purpose
    public static EnumExample get(String url) 
    {
        return lookup.get(url);
    }
}
