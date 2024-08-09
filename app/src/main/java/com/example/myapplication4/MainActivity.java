package com.example.myapplication4;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication4.adapter.Volcano;
import com.example.myapplication4.adapter.VolcanoAdapter;
import com.example.myapplication4.api.RetrofitClient;
import com.example.myapplication4.api.VolcanoApi;
import com.example.myapplication4.databinding.ActivityMainBinding;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private VolcanoAdapter adapter;
  private RecyclerView recyclerview;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.toolbar);
    getSupportActionBar().setTitle("chitChat");

    recyclerview = binding.recyclerView;

    recyclerview.setLayoutManager(new LinearLayoutManager(this));

    VolcanoApi api = RetrofitClient.getClient().create(VolcanoApi.class);
    Call<List<Volcano>> call = api.getVolcanoes();

    call.enqueue(
        new Callback<List<Volcano>>() {

          @Override
          public void onResponse(Call<List<Volcano>> call, Response<List<Volcano>> res) {
            if (res.isSuccessful()) {
              List<Volcano> volcanoList = res.body();
              adapter = new VolcanoAdapter(volcanoList, MainActivity.this);
              recyclerview.setAdapter(adapter);
            } else {
              Toast.makeText(MainActivity.this, "gagal fetch data", Toast.LENGTH_SHORT).show();
              Log.e("mainActivity", "error");
            }
          }

          @Override
          public void onFailure(Call<List<Volcano>> call, Throwable arg1) {
            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
          }
        });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }
}
