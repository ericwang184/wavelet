import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class SearchEngine implements URLHandler {

    int num = 0;
    String strArray[] = new String[10];
    public String handleRequest(URI url) {
        if (url.getPath().equals("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                for (parameters[1] : strArray){

                }
            return String.format("Eric's Number: %d", num);
        } else if (url.getPath().equals("/search")) {
            num += 1;
            return String.format("Number incremented!");
        } 
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
