package com.example.localeibra;

public class tshirtclass {
    private String Merk;
    private String Jenis;
    private String Harga;
    private String Desc;
    private int Gambar;

    public tshirtclass(String merk, String jenis, String harga, String desc, int gambar) {
        this.Merk = merk;
        this.Jenis = jenis;
        this.Harga = harga;
        this.Desc = desc;
        this.Gambar = gambar;
    }

    //getter and setter

    public String getMerk() {return Merk;}

    public void setMerk(String merk) {
        this.Merk = merk;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String jenis) {
        this.Jenis = jenis;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        this.Harga = harga;
    }


    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        this.Desc = desc;
    }


    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        this.Gambar = gambar;
    }
}







