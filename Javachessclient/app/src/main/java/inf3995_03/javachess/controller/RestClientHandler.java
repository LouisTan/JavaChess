package inf3995_03.javachess.controller;

import com.loopj.android.http.*;
/**
 * Created by lester on 16-11-13
 * Based on http://loopj.com/android-async-http/
 */

public class RestClientHandler {

    private static final String BASE_URL = "http://132.207.89.39/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
