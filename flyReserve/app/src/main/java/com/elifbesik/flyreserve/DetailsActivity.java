package com.elifbesik.flyreserve;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView txtAd,txtSoyad,txtTarih,txtTarih2,txtUlke,txtHavaalani,txtKoltuk;
    private String yolcuAdi,yolcuSoyadi,tarih,tarih2,ulke,havaalani,koltuk;

    private void init(){
        txtAd=(TextView)findViewById(R.id.detay_activity_textViewYolcuAdi);
        txtSoyad=(TextView)findViewById(R.id.detay_activity_textViewYolcuSoyadi);
        txtTarih=(TextView)findViewById(R.id.detay_activity_textViewTarih);
        txtTarih2=(TextView)findViewById(R.id.detay_activity_textViewTarih2);
        txtUlke=(TextView)findViewById(R.id.detay_activity_textViewULke);
        txtHavaalani=(TextView)findViewById(R.id.detay_activity_textViewHavaalani);
        txtKoltuk=(TextView)findViewById(R.id.detay_activity_textViewKoltuk);

        yolcuAdi =MainActivity.biletDetails.getYolcuAdi();
        yolcuSoyadi =MainActivity.biletDetails.getYolcuSoyadi();
        tarih =MainActivity.biletDetails.getTarih();
        tarih2 =MainActivity.biletDetails.getTarih2();
        ulke =MainActivity.biletDetails.getUlke();
        havaalani =MainActivity.biletDetails.getHavaalani();
        koltuk =MainActivity.biletDetails.getKoltuk();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();

        if(!TextUtils.isEmpty(yolcuAdi)&& !TextUtils.isEmpty(yolcuSoyadi)&& !TextUtils.isEmpty(tarih)&& !TextUtils.isEmpty(tarih2)&& !TextUtils.isEmpty(ulke)&& !TextUtils.isEmpty(havaalani)&& !TextUtils.isEmpty(koltuk)){
            txtAd.setText(yolcuAdi);
            txtSoyad.setText(yolcuSoyadi);
            txtTarih.setText(tarih);
            txtTarih2.setText(tarih2);
            txtUlke.setText(ulke);
            txtHavaalani.setText(havaalani);
            txtKoltuk.setText(koltuk);


        }

    }
}