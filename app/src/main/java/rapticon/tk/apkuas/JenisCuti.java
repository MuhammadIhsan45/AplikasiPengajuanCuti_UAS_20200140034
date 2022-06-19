package rapticon.tk.apkuas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import rapticon.tk.apkuas.Cuti.CutiDarurat;
import rapticon.tk.apkuas.Cuti.CutiSakit;
import rapticon.tk.apkuas.Cuti.CutiTahunan;
//membuat class jenisCuti dan bisa menggunakan fitur baru ke perangkat lama
public class JenisCuti extends AppCompatActivity {

    //deklarasi
    Button btn_ajukan,btn_lihat,btn_sakit,btn_darurat;

    //Override = sebuah situasi method class trurun menimpa method parent kelasnya
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //membuat cuper class
        super.onCreate(savedInstanceState);
        //meletakkan layout yang digunakan
        setContentView((R.layout.activity_jenis_cuti));

        //memilih komponen yang ada di layout untuk dijadikan objek pada Java.
        btn_ajukan = findViewById(R.id.bt_tahunan);
        btn_sakit = findViewById(R.id.bt_sakit);
        btn_darurat = findViewById(R.id.bt_darurat);
        btn_lihat = findViewById(R.id.bt_lihat);

        //Metode ini dipanggil bila pengguna menyentuh btn_ajukan
        btn_ajukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //membuat objek intent berpindah activity dari JenisCuti ke CutiTahunan
                Intent i = new Intent(JenisCuti.this, CutiTahunan.class);

                //berpindah ke CutiTahunan
                startActivity(i);

            }
        }
        );
        //Metode ini dipanggil bila pengguna menyentuh btn_lihat
        btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //membuat objek intent berpindah activity dari JenisCuti ke Data
                Intent i = new Intent(JenisCuti.this, Data.class);

                //berpindah ke Data
                startActivity(i);

            }
        }
        );
        //Metode ini dipanggil bila pengguna menyentuh btn_sakit
        btn_sakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //membuat objek intent berpindah activity dari JenisCuti ke CutiSakit
                Intent i = new Intent(JenisCuti.this, CutiSakit.class);

                //berpindah ke CutiSakit
                startActivity(i);

            }
        }
        );
        //Metode ini dipanggil bila pengguna menyentuh btn_sakit
        btn_darurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //membuat objek intent berpindah activity dari JenisCuti ke CutiDarurat
                Intent i = new Intent(JenisCuti.this, CutiDarurat.class);

                //berpindah ke CutiDarurat
                startActivity(i);

            }
        }
        );


    }
}
