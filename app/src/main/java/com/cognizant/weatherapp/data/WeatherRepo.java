package com.cognizant.weatherapp.data;

import com.cognizant.weatherapp.R;
import com.cognizant.weatherapp.ReponseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rajajawahar on 20/02/18.
 */

public class WeatherRepo {

  private WeatherApi weatherApi;

  public WeatherRepo(WeatherApi weatherApi) {
    this.weatherApi = weatherApi;
  }

  public void getWeatherResponse(String input, final ReponseListener responseListener) {
    weatherApi.getWeatherListBySearch(input).enqueue(new Callback<GetWeatherResponse>() {
      @Override
      public void onResponse(Call<GetWeatherResponse> call, Response<GetWeatherResponse> response) {
        if (response.isSuccessful()) {
          GetWeatherResponse weatherResponse = response.body();
          if (weatherResponse.getCod().equals(R.string.success_code)) {
            responseListener.onSuccess(weatherResponse);
          }
        }
      }

      @Override public void onFailure(Call<GetWeatherResponse> call, Throwable t) {
        responseListener.onFailure(t);
      }
    });
  }
}
