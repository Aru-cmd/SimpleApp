package com.example.myapplication4.adapter;

public class Volcano {
  private String nama, 
                 bentuk,
                 tinggi_meter,
                 estimasi_letusan_terakhir,
                 geolokasi;

  public String getNama() {
    return this.nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getBentuk() {
    return this.bentuk;
  }

  public void setBentuk(String bentuk) {
    this.bentuk = bentuk;
  }

  public String getTinggi_meter() {
    return this.tinggi_meter;
  }

  public void setTinggi_meter(String tinggi_meter) {
    this.tinggi_meter = tinggi_meter;
  }

  public String getEstimasi_letusan_terakhir() {
    return this.estimasi_letusan_terakhir;
  }

  public void setEstimasi_letusan_terakhir(String estimasi_letusan_terakhir) {
    this.estimasi_letusan_terakhir = estimasi_letusan_terakhir;
  }

  public String getGeolokasi() {
    return this.geolokasi;
  }

  public void setGeolokasi(String geolokasi) {
    this.geolokasi = geolokasi;
  }
}
