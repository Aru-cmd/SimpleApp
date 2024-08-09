package com.example.myapplication4.api;
import com.example.myapplication4.adapter.Volcano;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface VolcanoApi {
    @GET("/api/volcanoes")
    
    Call<List<Volcano>> getVolcanoes();
}
