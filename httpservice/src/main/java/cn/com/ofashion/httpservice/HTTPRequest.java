package cn.com.ofashion.httpservice;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HTTPRequest {
    private OkHttpClient client;

    @Inject
    HTTPRequest(@NonNull OkHttpClient client) {
        this.client = client;
    }

    String execute(Request request) {
        try (Response response = client.newCall(request).execute()){
            assert response.body() != null;
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
