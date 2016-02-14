package Filters;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class Filter1 implements Processor {
    
    private Processor target;
    
    public Filter1(Processor t) { 
        target = t; 
    }
    
    public void process(FilterHttpServletRequestWrapper req, HttpServletResponse res) throws IOException, ServletException {      
        String markdown = req.getParameter("markdown");
        
        // 1. Filter keywords
        markdown = markdown
                .replaceAll("cow", "*REDACTED*")
                .replaceAll("sheep", "*REDACTED*")
                .replaceAll("horse", "*REDACTED*");
        
        req.addParameter("markdown", markdown);
        
        target.process(req,res);
    }
    
}
