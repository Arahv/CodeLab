package com.cognizant.weatherapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cognizant.weatherapp.R;
import com.cognizant.weatherapp.ReponseListener;
import com.cognizant.weatherapp.WeatherListViewModel;
import com.cognizant.weatherapp.adapter.WeatherListAdapter;
import com.cognizant.weatherapp.app.AppController;
import com.cognizant.weatherapp.data.GetWeatherResponse;
import com.cognizant.weatherapp.data.WeatherRepo;
import com.cognizant.weatherapp.utils.LoggerUtils;
import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;
import static com.cognizant.weatherapp.data.GetWeatherResponse.Lists;

public class DetailsActivity extends AppCompatActivity {

  @BindView(R.id.rv_details) RecyclerView rvDetails;

  private WeatherRepo weatherRepo;
  private WeatherListAdapter weatherListAdapter;

  public static Intent getCallingIntent(Activity activity, String searchKey) {
    Intent intent = new Intent(activity, DetailsActivity.class);
    intent.putExtra("searchKey", searchKey);
    return intent;
  }

  private String searchKey;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);
    ButterKnife.bind(this);
    weatherRepo = AppController.getInstance().getWeatherRepo();
    weatherListAdapter = new WeatherListAdapter(this);
    rvDetails.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
    rvDetails.setHasFixedSize(true);
    rvDetails.setAdapter(weatherListAdapter);
    if (getIntent().hasExtra("searchKey")) {
      searchKey = getIntent().getStringExtra("searchKey");
    }
    if (!searchKey.isEmpty()) {
      fetchDataFromAPI();
    }
  }

  private void fetchDataFromAPI() {
    weatherRepo.getWeatherResponse(searchKey, new ReponseListener() {
      @Override public void onSuccess(GetWeatherResponse response) {
        if (response.getCity() != null) {
          getSupportActionBar().setTitle(String.format("%s / %s", response.getCity().getName(),
              response.getCity().getCountry()));
          convertWeatherListToViewModels(response);
        }
      }

      @Override public void onFailure(Throwable throwable) {
        LoggerUtils.logUnExpectedException(throwable);
        Snackbar.make(rvDetails, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
      }
    });
  }

  private void convertWeatherListToViewModels(GetWeatherResponse getWeatherResponse) {
    List<WeatherListViewModel> weatherListViewModels = new ArrayList<>();
    List<GetWeatherResponse.Lists> list = getWeatherResponse.getList();
    for (int i = 0, size = list.size(); i < size; i++) {
      Lists lists = list.get(i);
      weatherListViewModels.add(createViewModel(lists));
    }
    weatherListAdapter.setDataToList(weatherListViewModels);
  }

  private WeatherListViewModel createViewModel(Lists list) {
    WeatherListViewModel weatherListViewModel = new WeatherListViewModel();
    weatherListViewModel.setDate(list.getDate());
    weatherListViewModel.setMaximumTemp(list.getMain().getTempMax());
    weatherListViewModel.setMinimumTemp(list.getMain().getTempMin());
    return weatherListViewModel;
  }
}
