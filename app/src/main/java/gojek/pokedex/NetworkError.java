package gojek.pokedex;

public class NetworkError {
    public NetworkError(Throwable exception) {

    }

    public String getMessage() {
        return "Server Timed Out, Please Try Again!";
    }
}
