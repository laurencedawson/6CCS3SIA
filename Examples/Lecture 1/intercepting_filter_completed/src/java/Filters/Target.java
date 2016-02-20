package Filters;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.pegdown.PegDownProcessor;

public class Target implements Processor {
    
    @Override
    public void process(FilterHttpServletRequestWrapper req, HttpServletResponse res) 
            throws IOException, ServletException {
 
        // Grab the markdown from the request wrapper
        String markdown = req.getParameter("markdown");
        
        // Process the markdown to html
        PegDownProcessor processor = new PegDownProcessor();
        String html = processor.markdownToHtml(markdown);
        
        // Start the output page with bundled processed markdown
        req.setAttribute("data", html);
        req.getRequestDispatcher("output.jsp").forward(req, res);
    }
    
}
