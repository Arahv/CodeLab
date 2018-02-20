package com.cognizant.weatherapp.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rajajawahar on 20/02/18.
 */

public interface WeatherApi {

  @GET("/data/2.5/forecast?appid=daedf5f06bf6c41a48b1821c79ff1bd2&units=metric")
  Call<GetWeatherResponse> getWeatherListBySearch(@Query("q") String search);
}
