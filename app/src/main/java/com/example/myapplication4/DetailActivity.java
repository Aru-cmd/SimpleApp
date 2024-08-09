package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication4.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
  private ActivityDetailBinding binding;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    binding = ActivityDetailBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    
    Intent i = getIntent();
    
    String nama = i.getStringExtra("nama_gn");
    String tinggi = i.getStringExtra("tinggi_gn");
    String bentuk = i.getStringExtra("bentuk_gn");
    String last = i.getStringExtra("terakhir_meletus");
    String lokasi = i.getStringExtra("lokasi_gn");
    
    binding.tvDetailName.setText(nama);
    binding.tvDetailHeight.setText(tinggi);
    binding.tvDetailShape.setText(bentuk);
    binding.tvDetailLastEruption.setText(last);
    binding.tvDetailLocation.setText(lokasi);
  }
}
