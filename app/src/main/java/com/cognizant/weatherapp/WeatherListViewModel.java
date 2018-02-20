package com.cognizant.weatherapp;

import java.util.Date;

/**
 * Created by rajajawahar on 20/02/18.
 */

public class WeatherListViewModel {

  private Date date;
  private double minimumTemp;
  private double maximumTemp;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getMinimumTemp() {
    return minimumTemp;
  }

  public void setMinimumTemp(double minimumTemp) {
    this.minimumTemp = minimumTemp;
  }

  public double getMaximumTemp() {
    return maximumTemp;
  }

  public void setMaximumTemp(double maximumTemp) {
    this.maximumTemp = maximumTemp;
  }
}
