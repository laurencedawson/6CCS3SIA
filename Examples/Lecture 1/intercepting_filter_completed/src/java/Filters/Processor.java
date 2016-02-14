package Filters;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public interface Processor {
 
    public void process(FilterHttpServletRequestWrapper req, HttpServletResponse res) 
            throws IOException, ServletException;
    
}