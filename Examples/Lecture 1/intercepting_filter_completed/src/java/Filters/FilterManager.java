package Filters;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class FilterManager {

    Target target;
    
    public FilterManager(){
        target = new Target();
    }
    
    public void processRequest(FilterHttpServletRequestWrapper req, HttpServletResponse res)
        throws ServletException, IOException { 
        
        // Setup the filter chain
        Filter3 filter_three = new Filter3(target);
        Filter2 filter_two = new Filter2(filter_three);
        Filter1 filter_one = new Filter1(filter_two);
        
        filter_one.process(req,res); 
    }
    
}
