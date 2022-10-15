import java.io.IOException;
import java.net.URI;
import java.util.*; 

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
   

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add")) 
        {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                List<String> s = new ArrayList<>();
                s.add(parameters[1]);
                String[] k=new String[s.size()];
                k=s.toArray(k);
                return String.format("The new List is",k[0]);
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

    
    }
}
