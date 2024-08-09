package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import com.example.myapplication4.databinding.LayoutActivityUtamaBinding;

public class ActivityUtama extends AppCompatActivity {
  private LayoutActivityUtamaBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = LayoutActivityUtamaBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.toolbar);

    binding.text.setOnClickListener(v -> {
      Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu arg0) {
    // TODO: Implement this method
    getMenuInflater().inflate(R.menu.action_menu, arg0);

    return super.onCreateOptionsMenu(arg0);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem arg0) {
    // TODO: Implement this method
    int id = arg0.getItemId();
    if (id == R.id.search) {
      Toast.makeText(ActivityUtama.this, "test", Toast.LENGTH_SHORT).show();
    }
    return super.onOptionsItemSelected(arg0);
  }
}
