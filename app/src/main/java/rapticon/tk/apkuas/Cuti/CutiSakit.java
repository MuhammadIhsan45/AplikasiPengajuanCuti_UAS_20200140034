package rapticon.tk.apkuas.Cuti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import rapticon.tk.apkuas.Data;
import rapticon.tk.apkuas.Database;
import rapticon.tk.apkuas.R;

public class CutiSakit extends AppCompatActivity {
    private EditText tNama,tBidang,tMulai,tSelesai,tKet,tStatus;
    private Button simpanBtn;
    String nm, bd,ml, sl, kt,st;
    Database controller = new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuti_sakit);

        tNama = findViewById(R.id.txt_nama);
        tBidang = findViewById(R.id.txt_bidang);
        tMulai = findViewById(R.id.txt_mulai);
        tSelesai = findViewById(R.id.txt_selesai);
        tKet = findViewById(R.id.txt_ket);
        tStatus = findViewById(R.id.txt_status);
        simpanBtn = findViewById(R.id.btn_Form);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tNama.getText().toString().equals("") || tBidang.getText().toString().equals("") || tMulai.getText().toString().equals("")|| tSelesai.getText()
                        .toString().equals("")|| tKet.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Data belum komplit !", Toast.LENGTH_SHORT).show();
                } else {
                    nm = tNama.getText().toString();
                    bd = tBidang.getText().toString();
                    ml = tMulai.getText().toString();
                    sl = tSelesai.getText().toString();
                    kt = tKet.getText().toString();
                    st= tStatus.getText().toString();

                    HashMap<String, String> queryValues = new HashMap<>();
                    queryValues.put("nama", nm);
                    queryValues.put("bidang", bd);
                    queryValues.put("mulai", ml);
                    queryValues.put("selesai", sl);
                    queryValues.put("keterangan", kt);
                    queryValues.put("status", st);

                    controller.insertData(queryValues);

                    Intent intent = new Intent(CutiSakit.this, Data.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }
}