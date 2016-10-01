package gojek.pokedex;

import java.net.SocketTimeoutException;

public class NetworkError {
    private Throwable exception;

    public NetworkError(Throwable exception) {
        this.exception = exception;
    }

    public String getMessage() {
        if (exception instanceof SocketTimeoutException)
            return "Server Timed Out, Please Try Again!";
        return "No Internet Connection! Please Try Again!";
    }
}
