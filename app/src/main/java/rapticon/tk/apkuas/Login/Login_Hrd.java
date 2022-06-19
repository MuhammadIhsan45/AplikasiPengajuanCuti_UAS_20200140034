package rapticon.tk.apkuas.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import rapticon.tk.apkuas.Data;
import rapticon.tk.apkuas.R;
//membuat class Login_Hrd dengan bisa mengungakan fitur baru diperangkat lama
public class Login_Hrd extends AppCompatActivity {

    //Deklarasi
    EditText et_nama, et_password;
    Button login;
    String nama, password;

    //Override = sebuah situasi method class trurun menimpa method parent kelasnya
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //memanggil super class
        super.onCreate(savedInstanceState);
        //meletakkan layout yang ingin digunakan
        setContentView((R.layout.activity_login_hrd));

        //memilih komponen yang ada di layout untuk dijadikan objek pada Java.
        et_nama = findViewById(R.id.etUsername);
        et_password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btSignin);

        //Metode ini dipanggil bila pengguna menyentuh login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            //aksi yang akan dilakukan saat button di klik
            public void onClick(View view) {
                //memangggil validasi
                validasi();

            }
        }
        );

    }
    //validasi akan dipanggil
    public void validasi() {

        nama = et_nama.getText().toString();
        password = et_password.getText().toString();

        if (nama.isEmpty() && password.isEmpty()) {
            et_nama.setError("Mohon cek Username & Password");
            et_password.setError("Mohon cek Username & Password");

        } else if (nama.equals("ihsan") && password.equals("ihsan")) {
            //membuat pesan singkat dalam popup kecil
            //LENGTH_SHORT = 2.5 s
            Toast.makeText(Login_Hrd.this, "Login Sukses", Toast.LENGTH_SHORT).show();

            //membuat objek baru bundle
            Bundle b = new Bundle();

            //memasukkan value dari variabel nama dengan kunci "a"
            //dan dimasukkan kedalam bundle
            b.putString("a", nama.trim());


            //membuat objek intent berpindah activity dari MainActivity ke Data
            Intent i = new Intent(getApplicationContext(), Data.class);

            //memasukkan bundle intent untuk dikirimkan ke Data
            i.putExtras(b);

            //berpindah ke Data
            startActivity(i);

        } else if (nama != ("ihsan") && password.equals("ihsan")) {
            Toast.makeText(Login_Hrd.this, "Username Salah", Toast.LENGTH_SHORT).show();

        } else if (nama.equals("ihsan") && password != ("ihsan")) {
            Toast.makeText(Login_Hrd.this, "Password Salah", Toast.LENGTH_SHORT).show();
        } else if (nama != ("ihsan") && password != ("ihsan")) {
            Toast.makeText(Login_Hrd.this, "Username dan Password Salah", Toast.LENGTH_SHORT).show();
        }

    }
}