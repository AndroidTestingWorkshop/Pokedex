package gojek.pokedex;

import junit.framework.Assert;

import org.junit.Test;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import gojek.pokedex.common.NetworkError;

public class NetworkErrorTest {
    @Test
    public void testThatItHandlesServerTimeoutExceptionWhenNotAbleToContactTheServer() {
        SocketTimeoutException timeOutException = new SocketTimeoutException();
        NetworkError networkError = new NetworkError(timeOutException);
        Assert.assertEquals("Server Timed Out, Please Try Again!", networkError.getMessage());
    }

    @Test
    public void testThatItHandlesInternetConnectionIssues() {
        UnknownHostException noInternetConnectionPresent = new UnknownHostException();
        NetworkError networkError = new NetworkError(noInternetConnectionPresent);
        Assert.assertEquals("No Internet Connection! Please Try Again!", networkError.getMessage());
    }

    @Test
    public void testThatItHandlesIssuesWhichAreNotExpected() {
        ParseException parseException = new ParseException("", 1);
        NetworkError networkError = new NetworkError(parseException);
        Assert.assertEquals("Something went wrong! Please try again.", networkError.getMessage());
    }
}
