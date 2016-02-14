import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/PropSysController"})
public class PropSysController extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Listen out for our submission page
        String page = request.getParameter("page");
        if("submission".equals(page)){
       
            // Check if the user is logged in
            String sessionCookie = request.getHeader("example_cookie");       
            if(sessionCookie==null || !SessionManager.isSessionValid(sessionCookie)){
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            }

            // Submit the content and show the submitted page
            else {        
                request.getRequestDispatcher("submitted.jsp").forward(request, response);
            }
            
        }
        
        else {
            request.getRequestDispatcher("unsupported.jsp").forward(request, response);
        }
    }

}
