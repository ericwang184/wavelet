import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {

    String strArray[] = new String[0];
    public String handleRequest(URI url) {
        if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                String newStrArray[] = new String[strArray.length + 1];
                for (int i = 0; i < strArray.length; i++){
                    newStrArray[i] = strArray[i];
                }
                newStrArray[strArray.length] = parameters[1];
                strArray = newStrArray;
            }
           
        } 
        return strArray.toString();
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
