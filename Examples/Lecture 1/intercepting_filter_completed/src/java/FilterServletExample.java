import Filters.FilterHttpServletRequestWrapper;
import Filters.FilterManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Example"})
public class FilterServletExample extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FilterManager manager = new FilterManager();
        manager.processRequest(new FilterHttpServletRequestWrapper(request), response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}