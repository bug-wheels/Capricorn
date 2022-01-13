package com.github.bw.capricorn.client.util;

import com.github.bw.capricorn.client.gson.LenientGsonConverterFactory;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;

public class ClientGenerator {

  private final static Logger logger = LoggerFactory.getLogger(ClientGenerator.class);

  private static Retrofit.Builder initBuilder(String baseURL) {
    return new Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(LenientGsonConverterFactory.create());
  }

  public static <S> S createService(Class<S> serviceClass, String baseURL, boolean withLogger) {
    Builder builder = initBuilder(baseURL);

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    if (withLogger) {
      HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
      logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      httpClient.addInterceptor(logInterceptor);
    }

    httpClient.readTimeout(60, TimeUnit.SECONDS);
    builder.client(httpClient.build());
    return builder.build().create(serviceClass);
  }

  /**
   * Execute a REST call and block until the response is received.
   */
  public static <T> T executeSync(Call<T> call) {
    try {
      Response<T> response = call.execute();
      if (response.isSuccessful()) {
        return response.body();
      } else {
        throw new RuntimeException(response.message());
      }
    } catch (SocketTimeoutException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
