
public class PageValidator {
    
    public static final String[] validPages = {
        "submission",
        "edit",
    };
    
    
    public static boolean isPageValid(String page){
      for(int i=0;i<validPages.length;i++) {
        if(validPages[i].equalsIgnoreCase(page)){
            return true;
        }
      }
      
      return false;
    }
    
    
}
