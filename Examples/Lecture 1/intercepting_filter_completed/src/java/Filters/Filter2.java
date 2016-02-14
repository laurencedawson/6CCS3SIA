package Filters;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class Filter2 implements Processor {
    
    private Processor target;
    
    public Filter2(Processor t) { 
        target = t; 
    }
    
    public void process(FilterHttpServletRequestWrapper req, HttpServletResponse res) throws IOException, ServletException {
        String markdown = req.getParameter("markdown");
        
        // 2. Only allow Chromium based browsers
        String userAgent = req.getHeader("User-Agent");
        if(!userAgent.contains("Chromium")){        
            // Let the user know the browser is not supported
            req.addParameter("markdown", "**Browser not supported**");  
            
            // Alternatively redirect the user to an error page
            // req.getRequestDispatcher("error.jsp").forward(req, res);
        }   
       
        target.process(req,res);
    }
    
}
