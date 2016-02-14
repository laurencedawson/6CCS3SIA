package Filters;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class Filter3 implements Processor {
    
    private Processor target;
    
    public Filter3(Processor t) { 
        target = t; 
    }
    
    public void process(FilterHttpServletRequestWrapper req, HttpServletResponse res) throws IOException, ServletException {
        String markdown = req.getParameter("markdown");
        
        // 3. Remove all scripting to mitigate XSS attacks
        //    e.g. hello <a name="n" href="javascript:alert('xss')">*you*</a>       
        
        // Warning never ever use this in production, you've been warned...
        markdown = markdown.replaceAll("\\<.*?\\>", "");
        
        req.addParameter("markdown", markdown);   
       
        target.process(req,res);
    }
    
}
