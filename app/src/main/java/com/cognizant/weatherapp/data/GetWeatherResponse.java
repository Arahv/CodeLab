package com.cognizant.weatherapp.data;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

/**
 * Created by rajajawahar on 20/02/18.
 */

public class GetWeatherResponse {

  @SerializedName("city") private City city;
  @SerializedName("list") private List<Lists> list;
  @SerializedName("cnt") private int cnt;
  @SerializedName("message") private double message;
  @SerializedName("cod") private String cod;

  public static class City {
    @SerializedName("population") private int population;
    @SerializedName("country") private String country;
    @SerializedName("coord") private Coord coord;
    @SerializedName("name") private String name;
    @SerializedName("id") private int id;

    public int getPopulation() {
      return population;
    }

    public void setPopulation(int population) {
      this.population = population;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public Coord getCoord() {
      return coord;
    }

    public void setCoord(Coord coord) {
      this.coord = coord;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }
  }

  public static class Coord {
    @SerializedName("lon") private double lon;
    @SerializedName("lat") private double lat;

    public double getLon() {
      return lon;
    }

    public void setLon(double lon) {
      this.lon = lon;
    }

    public double getLat() {
      return lat;
    }

    public void setLat(double lat) {
      this.lat = lat;
    }
  }

  public static class Lists {
    @SerializedName("dt_txt") private Date date;
    @SerializedName("sys") private Sys sys;
    @SerializedName("wind") private Wind wind;
    @SerializedName("clouds") private Clouds clouds;
    @SerializedName("weather") private List<Weather> weather;
    @SerializedName("main") private Main main;
    @SerializedName("dt") private int dt;

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public Sys getSys() {
      return sys;
    }

    public void setSys(Sys sys) {
      this.sys = sys;
    }

    public Wind getWind() {
      return wind;
    }

    public void setWind(Wind wind) {
      this.wind = wind;
    }

    public Clouds getClouds() {
      return clouds;
    }

    public void setClouds(Clouds clouds) {
      this.clouds = clouds;
    }

    public List<Weather> getWeather() {
      return weather;
    }

    public void setWeather(List<Weather> weather) {
      this.weather = weather;
    }

    public Main getMain() {
      return main;
    }

    public void setMain(Main main) {
      this.main = main;
    }

    public int getDt() {
      return dt;
    }

    public void setDt(int dt) {
      this.dt = dt;
    }
  }

  public static class Sys {
    @SerializedName("pod") private String pod;
  }

  public static class Wind {
    @SerializedName("deg") private double deg;
    @SerializedName("speed") private double speed;
  }

  public static class Clouds {
    @SerializedName("all") private int all;
  }

  public static class Weather {
    @SerializedName("icon") private String icon;
    @SerializedName("description") private String description;
    @SerializedName("main") private String main;
    @SerializedName("id") private int id;

    public String getIcon() {
      return icon;
    }

    public void setIcon(String icon) {
      this.icon = icon;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getMain() {
      return main;
    }

    public void setMain(String main) {
      this.main = main;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }
  }

  public static class Main {
    @SerializedName("temp_kf") private double tempkf;
    @SerializedName("humidity") private int humidity;
    @SerializedName("grnd_level") private double grndLevel;
    @SerializedName("sea_level") private double seaLevel;
    @SerializedName("pressure") private double pressure;
    @SerializedName("temp_max") private double tempMax;
    @SerializedName("temp_min") private double tempMin;
    @SerializedName("temp") private double temp;

    public double getTempkf() {
      return tempkf;
    }

    public void setTempkf(double tempkf) {
      this.tempkf = tempkf;
    }

    public int getHumidity() {
      return humidity;
    }

    public void setHumidity(int humidity) {
      this.humidity = humidity;
    }

    public double getGrndLevel() {
      return grndLevel;
    }

    public void setGrndLevel(double grndLevel) {
      this.grndLevel = grndLevel;
    }

    public double getSeaLevel() {
      return seaLevel;
    }

    public void setSeaLevel(double seaLevel) {
      this.seaLevel = seaLevel;
    }

    public double getPressure() {
      return pressure;
    }

    public void setPressure(double pressure) {
      this.pressure = pressure;
    }

    public double getTempMax() {
      return tempMax;
    }

    public void setTempMax(double tempMax) {
      this.tempMax = tempMax;
    }

    public double getTempMin() {
      return tempMin;
    }

    public void setTempMin(double tempMin) {
      this.tempMin = tempMin;
    }

    public double getTemp() {
      return temp;
    }

    public void setTemp(double temp) {
      this.temp = temp;
    }
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public List<Lists> getList() {
    return list;
  }

  public void setList(List<Lists> list) {
    this.list = list;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public double getMessage() {
    return message;
  }

  public void setMessage(double message) {
    this.message = message;
  }

  public String getCod() {
    return cod;
  }

  public void setCod(String cod) {
    this.cod = cod;
  }
}
