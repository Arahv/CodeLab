package com.cognizant.weatherapp.app;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ApiConstants {

  public static final String BASE_URL = "http://api.openweathermap.org/";

  public static SimpleDateFormat dateFormat =
      new SimpleDateFormat("hh:mm a dd/MM/yyyy", Locale.getDefault());
}
