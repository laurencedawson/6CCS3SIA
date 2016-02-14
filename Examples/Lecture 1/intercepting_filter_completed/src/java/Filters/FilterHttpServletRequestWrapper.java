package Filters;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FilterHttpServletRequestWrapper extends HttpServletRequestWrapper {
    
    private HashMap<String, String> params = new HashMap<>();
    
    public FilterHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    
    @Override
    public String getParameter(String name) {
        if ( params.get( name ) != null ) {
              return params.get( name );
        }
        
        return super.getParameter(name);
   }

   public void addParameter( String name, String value ) {
        params.put( name, value );
   }
    
}
