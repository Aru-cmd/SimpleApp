package com.example.myapplication4.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication4.DetailActivity;
import com.example.myapplication4.databinding.ItemVolcanoBinding;
import java.util.List;

public class VolcanoAdapter extends RecyclerView.Adapter<VolcanoAdapter.VH> {
  private final List<Volcano> volcanoList;
  private final Context ctx;

  public VolcanoAdapter(List<Volcano> volcanoList, Context ctx) {
    this.volcanoList = volcanoList;
    this.ctx = ctx;
  }

  @NonNull
  @Override
  public VH onCreateViewHolder(ViewGroup arg0, int arg1) {
    LayoutInflater inflater = LayoutInflater.from(arg0.getContext());

    ItemVolcanoBinding binding = ItemVolcanoBinding.inflate(inflater, arg0, false);

    return new VH(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull VH arg0, int arg1) {
    Volcano vol = volcanoList.get(arg1);
    arg0.binding.tvName.setText(vol.getNama());
    arg0.binding.tvHeight.setText(vol.getTinggi_meter());
    arg0.binding.tvShape.setText(vol.getBentuk());
    arg0.binding.tvLastEruption.setText(vol.getEstimasi_letusan_terakhir());
    arg0.binding.tvLocation.setText(vol.getGeolokasi());
    arg0.binding.cardview.setOnClickListener(
        v -> {
          Intent i = new Intent(arg0.itemView.getContext(), DetailActivity.class);
          i.putExtra("nama_gn", vol.getNama());
          i.putExtra("bentuk_gn", vol.getBentuk());
          i.putExtra("tinggi_gn", vol.getTinggi_meter());
          i.putExtra("terakhir_meletus", vol.getEstimasi_letusan_terakhir());
          i.putExtra("lokasi_gn", vol.getGeolokasi());
          arg0.itemView.getContext().startActivity(i);
        });
  }

  @Override
  public int getItemCount() {
    return volcanoList.size();
  }

  static class VH extends RecyclerView.ViewHolder {
    private final ItemVolcanoBinding binding;

    public VH(ItemVolcanoBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }
  }
}
