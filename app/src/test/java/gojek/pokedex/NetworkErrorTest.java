package gojek.pokedex;

import junit.framework.Assert;

import org.junit.Test;

import java.net.SocketTimeoutException;

public class NetworkErrorTest {
    @Test
    public void testThatItHandlesServerTimeoutExceptionWhenNotAbleToContactTheServer() {
        SocketTimeoutException timeOutException = new SocketTimeoutException();
        NetworkError networkError = new NetworkError(timeOutException);
        Assert.assertEquals("Server Timed Out, Please Try Again!", networkError.getMessage());
    }
}
