package com.cognizant.weatherapp;

import com.cognizant.weatherapp.data.GetWeatherResponse;

/**
 * Created by rajajawahar on 20/02/18.
 */

public interface ReponseListener {

  void onSuccess(GetWeatherResponse response);

  void onFailure(Throwable throwable);
}
