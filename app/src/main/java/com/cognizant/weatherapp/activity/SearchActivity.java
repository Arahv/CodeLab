package com.cognizant.weatherapp.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cognizant.weatherapp.R;

public class SearchActivity extends AppCompatActivity {

  @BindView(R.id.et_city) EditText etCity;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    ButterKnife.bind(this);
  }

  public void search(View view) {

    String input = etCity.getText().toString().trim();
    if (input.isEmpty()) {
      Snackbar.make(etCity, "Enter valid input", Snackbar.LENGTH_SHORT).show();
      return;
    }
    startActivity(DetailsActivity.getCallingIntent(this, input));
  }
}
