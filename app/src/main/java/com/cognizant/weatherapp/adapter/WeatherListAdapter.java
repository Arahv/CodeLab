package com.cognizant.weatherapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cognizant.weatherapp.R;
import com.cognizant.weatherapp.WeatherListViewModel;
import com.cognizant.weatherapp.app.ApiConstants;
import java.util.ArrayList;
import java.util.List;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherListHolder> {

  private Context context;

  private List<WeatherListViewModel> viewModels;

  public WeatherListAdapter(Context context) {
    this.context = context;
    viewModels = new ArrayList<>();
  }

  @Override public WeatherListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new WeatherListHolder(
        LayoutInflater.from(context).inflate(R.layout.item_weather_list, null));
  }

  @Override public void onBindViewHolder(WeatherListHolder holder, int position) {
    WeatherListViewModel viewModel = viewModels.get(position);
    holder.tvDate.setText(ApiConstants.dateFormat.format(viewModel.getDate()));
    holder.tvMaximumTemp.setText(String.format("Max Temp : %s", viewModel.getMaximumTemp()));
    holder.tvMinimumTemp.setText(String.format("Min Temp : %s", viewModel.getMinimumTemp()));
  }

  public void setDataToList(List<WeatherListViewModel> weatherListViewModels) {
    if (weatherListViewModels.isEmpty()) return;
    viewModels.clear();
    viewModels.addAll(weatherListViewModels);
    notifyDataSetChanged();
  }

  @Override public int getItemCount() {
    return viewModels.size();
  }

  class WeatherListHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_date) TextView tvDate;
    @BindView(R.id.tv_min_temp) TextView tvMinimumTemp;
    @BindView(R.id.tv_max_temp) TextView tvMaximumTemp;

    WeatherListHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
