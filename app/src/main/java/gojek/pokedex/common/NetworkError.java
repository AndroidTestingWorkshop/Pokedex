package gojek.pokedex.common;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class NetworkError {
    private Throwable exception;

    public NetworkError(Throwable exception) {
        this.exception = exception;
    }

    public String getMessage() {
        if (exception instanceof SocketTimeoutException)
            return "Server Timed Out, Please Try Again!";
        if (exception instanceof UnknownHostException)
            return "No Internet Connection! Please Try Again!";
        return "Something went wrong! Please try again.";
    }
}
