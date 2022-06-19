package rapticon.tk.apkuas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import rapticon.tk.apkuas.Login.Login_Hrd;
import rapticon.tk.apkuas.Login.Login_Karyawan;
import rapticon.tk.apkuas.Login.Login_Manager;
import rapticon.tk.apkuas.Login.Login_Supervisor;

//AppCompactActivity = aktifitas untuk mengunakan fitur baru ke prangkat lama
public class MainActivity extends AppCompatActivity {


    //Deklarasi button
    Button bt_karyawan,bt_hrd,bt_manager,bt_supervisor;

    //Override = sebuah situasi method class trurun menimpa method parent kelasnya
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //panggil super class untuk menyelesaikan
        super.onCreate(savedInstanceState);
        //mengatur letak layout yang ingin digunakan
        setContentView((R.layout.activity_main));


        //memilih komponen yang ada di layout untuk dijadikan objek pada Java.
        bt_karyawan = findViewById(R.id.btn_karyawan);
        bt_manager = findViewById(R.id.btn_manager);
        bt_supervisor = findViewById(R.id.btn_supervisor);
        bt_hrd = findViewById(R.id.btn_hrd);

        //Metode ini dipanggil bila pengguna menyentuh bt_karyawan
        bt_karyawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //aksi yang dilakukan
                //membuat objek intent berpindah activity dari MainActivity ke Login_Karyawan
                Intent i = new Intent(MainActivity.this, Login_Karyawan.class);

                //berpindah ke Login_Karyawan
                startActivity(i);

            }
        }
        );
        //Metode ini dipanggil bila pengguna menyentuh bt_hrd
        bt_hrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //aksi yang dilakukan
                //membuat objek intent berpindah activity dari MainActivity ke Login_Hrd
                Intent i = new Intent(MainActivity.this, Login_Hrd.class);

                //berpindah ke Login_Hrd
                startActivity(i);

            }
        }
        );
        //Metode ini dipanggil bila pengguna menyentuh bt_manager
        bt_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //aksi yang dilakukan
                //membuat objek intent berpindah activity dari MainActivity ke Login_Manager
                Intent i = new Intent(MainActivity.this, Login_Manager.class);

                //berpindah ke Login_Manager
                startActivity(i);

            }
        }
        );
        //Metode ini dipanggil bila pengguna menyentuh bt_manager
        bt_supervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //aksi yang dilakukan
                //membuat objek intent berpindah activity dari MainActivity ke Login_Supervisor
                Intent i = new Intent(MainActivity.this, Login_Supervisor.class);

                //berpindah ke Login_Supervisor
                startActivity(i);

            }
        }
        );

    }
}