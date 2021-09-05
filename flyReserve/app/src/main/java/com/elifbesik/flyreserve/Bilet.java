package com.elifbesik.flyreserve;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

public class Bilet {
    private String isim, soyisim, ulke, havaalani;
    private String tarih,tarih2,koltuk;
    public Bilet() { }
    public Bilet(String isim, String soyisim,String tarih,String tarih2, String ulke, String havaalani,String koltuk) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.ulke = ulke;
        this.havaalani = havaalani;
        this.tarih = tarih;
        this.tarih2 = tarih2;
        this.koltuk = koltuk;
    }
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public String getSoyisim() {
        return soyisim;
    }
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
    public String getUlke() {
        return ulke;
    }
    public void setUlke(String ulke) {
        this.ulke = ulke;
    }
    public String getHavaalani() {
        return havaalani;
    }
    public void setHavaalani(String havaalani) {
        this.havaalani = havaalani;
    }
    public String getTarih() {
    return tarih;
    }
    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    public void setTarih2(String tarih2) {
        this.tarih2 = tarih2;
    }
    public String getTarih2() {
        return tarih2;
    }
    public void setKoltuk(String koltuk) {
        this.koltuk = koltuk;
    }
    public String getKoltuk() {
        return koltuk;
    }

    static public ArrayList<Bilet> getData(Context context) {
        ArrayList<Bilet> biletList = new ArrayList<>();
        ArrayList<String> isimList = new ArrayList<>();
        ArrayList<String> soyisimList = new ArrayList<>();
        ArrayList<String> tarihList = new ArrayList<>();
        ArrayList<String> tarihList2 = new ArrayList<>();
        ArrayList<String> ulkeList = new ArrayList<>();
        ArrayList<String> havaanaliList = new ArrayList<>();
        ArrayList<String> koltukList = new ArrayList<>();
        try {
            SQLiteDatabase database = context.openOrCreateDatabase("Biletler", Context.MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT * FROM biletler", null);
            int isimIndex = cursor.getColumnIndex("Isim");
            int soyisimIndex = cursor.getColumnIndex("Soyisim");
            int tarihIndex = cursor.getColumnIndex("Tarih");
            int tarihIndex2 = cursor.getColumnIndex("Tarih2");
            int ulkeIndex = cursor.getColumnIndex("Ulke");
            int havaalaniIndex = cursor.getColumnIndex("Havaalani");
            int koltukIndex = cursor.getColumnIndex("Koltuk");

            while (cursor.moveToNext()) {
                isimList.add(cursor.getString(isimIndex));
                soyisimList.add(cursor.getString(soyisimIndex));
                tarihList.add(cursor.getString(tarihIndex));
                tarihList2.add(cursor.getString(tarihIndex2));
                ulkeList.add(cursor.getString(ulkeIndex));
                havaanaliList.add(cursor.getString(havaalaniIndex));
                koltukList.add(cursor.getString(koltukIndex));
            }
            cursor.close();

            for(int i=0;i<isimList.size();i++){
                Bilet bilet = new Bilet();
                bilet.setIsim(isimList.get(i));
                bilet.setSoyisim(soyisimList.get(i));
                bilet.setTarih(tarihList.get(i));
                bilet.setTarih2(tarihList2.get(i));
                bilet.setUlke(ulkeList.get(i));
                bilet.setHavaalani(havaanaliList.get(i));
                bilet.setKoltuk(koltukList.get(i));

                biletList.add(bilet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return biletList;
    }

}
