import java.io.IOException;
import java.net.URI;
import java.util.*; 

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    List<String> s = new ArrayList<>();

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add")) 
        { 
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                s.add(parameters[1]);
                for(String nw:s){
                    return s.toString();
                }
            }
        
        }
        else if (url.getPath().contains("/search")) 
        { 
            String[] parameters1 = url.getQuery().split("=");
            if (parameters1[0].equals("s")) {
                List<String> s1 = new ArrayList<>();
                
                for(String nw:s){
                    if(nw.contains(parameters1[1])){
                        s1.add(nw);
                    }
                     
                }
                return s1.toString();
            }
        
        }
        return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
    
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());

    
    }
}
