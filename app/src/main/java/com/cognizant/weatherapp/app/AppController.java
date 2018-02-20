package com.cognizant.weatherapp.app;

import android.app.Application;
import com.cognizant.weatherapp.BuildConfig;
import com.cognizant.weatherapp.R;
import com.cognizant.weatherapp.data.WeatherApi;
import com.cognizant.weatherapp.data.WeatherRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppController extends Application {

  public static AppController instance;
  private HttpLoggingInterceptor logging;
  private Gson gson;
  private WeatherRepo weatherRepo;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    gson = new GsonBuilder().setDateFormat(getString(R.string.date_time_format)).create();
    logging = new HttpLoggingInterceptor();
    logging.setLevel(
        BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
  }

  public static AppController getInstance() {
    return instance;
  }

  private WeatherRepo creatWeatherRepo() {
    OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging)
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .build();
    Retrofit retrofit = new Retrofit.Builder().client(httpClient)
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
    return new WeatherRepo(retrofit.create(WeatherApi.class));
  }

  public WeatherRepo getWeatherRepo() {
    if (weatherRepo == null) {
      weatherRepo = creatWeatherRepo();
    }
    return weatherRepo;
  }
}
