package com.elifbesik.flyreserve;

public class BiletDetails {
    private String yolcuAdi,yolcuSoyadi,tarih,tarih2,ulke,havaalani,koltuk;

    public BiletDetails(String yolcuAdi, String yolcuSoyadi, String tarih,String tarih2, String ulke, String havaalani,String koltuk) {
        this.yolcuAdi = yolcuAdi;
        this.yolcuSoyadi = yolcuSoyadi;
        this.tarih = tarih;
        this.tarih2 = tarih2;
        this.ulke = ulke;
        this.havaalani = havaalani;
        this.koltuk = koltuk;
    }

    public String getYolcuAdi() {
        return yolcuAdi;
    }

    public String getYolcuSoyadi() {
        return yolcuSoyadi;
    }

    public String getTarih() {
       return tarih;
    }
    public String getTarih2() {
        return tarih2;
    }

    public String getUlke() {
        return ulke;
    }

    public String getHavaalani() {
        return havaalani;
    }
    public String getKoltuk() {
        return koltuk;
    }
}
