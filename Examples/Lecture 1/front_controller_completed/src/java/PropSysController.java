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
        if(PageValidator.isPageValid(page)){
       
            // The main point of the controller is to check for valid sessions!           
            // Check if the user is logged in
            String sessionCookie = request.getHeader("example_cookie");       
            if(sessionCookie==null || !SessionManager.isSessionValid(sessionCookie)){
                request.getRequestDispatcher("registration.jsp").forward(request, response);
                return;
            }

            
            if("submission".equals(page)){
                 // Submit the content and show the submitted page            
                if(PostSubmitter.submitPost(request.getParameter("markdown"))){
                    request.getRequestDispatcher("submitted.jsp").forward(request, response);                   
                } else {
                    request.getRequestDispatcher("error_submitting.jsp").forward(request, response);                   
                }
            }
            
            else if("edit".equals(page)){
                // TODO handle the edit page
            }
           
        }
        
        else {
            request.getRequestDispatcher("unsupported.jsp").forward(request, response);
        }
    }

}
