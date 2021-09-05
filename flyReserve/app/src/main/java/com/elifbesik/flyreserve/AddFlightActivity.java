package com.elifbesik.flyreserve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class AddFlightActivity extends AppCompatActivity {
    private EditText editTextIsim ,editTextSoyisim,editTextTarih,editTextTarih2,editTextUlke,editTextHavaalani,editTextKoltuk;
    private String Isim,Soyisim,Tarih,Tarih2,Ulke,Havaalani,Koltuk;

    private void init (){
        editTextIsim=(EditText)findViewById(R.id.add_flight_editTextIsim);
        editTextSoyisim=(EditText)findViewById(R.id.add_flight_editTextSoyisim);
        editTextTarih=(EditText)findViewById(R.id.add_flight_editTextTarih);
        editTextTarih2=(EditText)findViewById(R.id.add_flight_editTextTarih2);
        editTextUlke=(EditText)findViewById(R.id.add_flight_editTextUlke);
        editTextHavaalani=(EditText)findViewById(R.id.add_flight_editTextHavaalani);
        editTextKoltuk=(EditText)findViewById(R.id.add_flight_editTextKoltuk);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);
        init();
    }
    public void ucusKaydet(View view) {
        Isim = editTextIsim.getText().toString();
        Soyisim = editTextSoyisim.getText().toString();
        Tarih = editTextTarih.getText().toString();
        Tarih2 = editTextTarih2.getText().toString();
        Ulke = editTextUlke.getText().toString();
        Havaalani = editTextHavaalani.getText().toString();
        Koltuk = editTextKoltuk.getText().toString();

        if (!TextUtils.isEmpty(Isim)) {
            if (!TextUtils.isEmpty(Soyisim)) {
                if (!TextUtils.isEmpty(Tarih)) {
                    if (!TextUtils.isEmpty(Tarih2)) {
                        if (!TextUtils.isEmpty(Ulke)) {
                            if (!TextUtils.isEmpty(Havaalani)) {
                                if (!TextUtils.isEmpty(Havaalani)) {
                                    //kaydet
                                    try {
                                        SQLiteDatabase database = this.openOrCreateDatabase("Biletler", MODE_PRIVATE, null);
                                        database.execSQL("CREATE TABLE IF NOT EXISTS biletler (id INTEGER PRIMARY KEY,Isim VARCHAR,Soyisim VARCHAR,Tarih VARCHAR,Tarih2 VARCHAR,Ulke VARCHAR,Havaalani VACHAR,Koltuk VARCHAR)");
                                        String sqlQuery = "INSERT INTO biletler (Isim,Soyisim,Tarih,Tarih2,Ulke,Havaalani,Koltuk)VALUES(?,?,?,?,?,?,?)";
                                        SQLiteStatement statement = database.compileStatement(sqlQuery);
                                        statement.bindString(1, Isim);
                                        statement.bindString(2, Soyisim);
                                        statement.bindString(3, Tarih);
                                        statement.bindString(4, Tarih2);
                                        statement.bindString(5, Ulke);
                                        statement.bindString(6, Havaalani);
                                        statement.bindString(7, Koltuk);
                                        statement.execute();

                                        temizle();
                                        showToast("kaydedildi");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else showToast("koltuk numaranızı seçiniz");
                            } else showToast("havaalanı seçiniz");
                        } else showToast("ülke seçinz.");
                    } else showToast("dönüş tarihi seçiniz.");
                } else showToast("gidiş tarihi seçiniz.");
            } else showToast("soyisim giriniz.");
        }else showToast("isim giriniz.");
    }
    private void showToast(String mesaj){
        Toast.makeText(getApplicationContext(),mesaj,Toast.LENGTH_LONG).show();
    }
    private void temizle(){
        editTextIsim.setText("");
        editTextSoyisim.setText("");
        editTextTarih.setText("");
        editTextTarih2.setText("");
        editTextUlke.setText("");
        editTextHavaalani.setText("");
        editTextKoltuk.setText("");
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent (this,MainActivity.class);
        finish();
        startActivity(backIntent);
    }
}