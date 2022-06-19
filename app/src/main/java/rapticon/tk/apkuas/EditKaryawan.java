package rapticon.tk.apkuas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;

public class EditKaryawan extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText Nama,Bidang,Mulai,Selesai,Ket;
    Button Save;
    String nm,bd,ml, sl, id,kt,st;
    Database dbController = new Database(this);
    String[] jawaban = {"DITERIMA","DITOLAK"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);


        Nama = findViewById(R.id.ed_nama);
        Bidang = findViewById(R.id.ed_bidang);
        Mulai = findViewById(R.id.ed_mulai);
        Selesai = findViewById(R.id.ed_selesai);
        Ket = findViewById(R.id.ed_ket);
        Spinner Status = findViewById(R.id.ed_status);
        Save = findViewById(R.id.bt_simpan);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        bd = getIntent().getStringExtra("bidang");
        ml = getIntent().getStringExtra("mulai");
        sl = getIntent().getStringExtra("selesai");
        kt = getIntent().getStringExtra("keterangan");
        st = getIntent().getStringExtra("status");


        setTitle("Edit Data");
        Nama.setText(nm);
        Bidang.setText(bd);
        Mulai.setText(ml);
        Selesai.setText(sl);
        Ket.setText(kt);
        Status.setSelected(Boolean.parseBoolean(st));

        Status.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, jawaban);
        arrayAdapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item));
        Status.setAdapter(arrayAdapter);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Nama.getText().toString().equals("") || Mulai.getText().toString().equals("")||Bidang.getText().toString().equals("") ||Selesai.getText().toString().equals("")|| Ket.getText().toString().equals("")||Status.getSelectedItem().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Mohon isi data terlebih dahulu !!!",Toast.LENGTH_LONG).show();

                }else{
                    nm = Nama.getText().toString();
                    bd = Bidang.getText().toString();
                    ml = Mulai.getText().toString();
                    sl = Selesai.getText().toString();
                    kt = Ket.getText().toString();
                    st = Status.getSelectedItem().toString();
                    HashMap<String,String > values = new HashMap<>();
                    values.put("id",id);
                    values.put("nama",nm);
                    values.put("bidang",bd);
                    values.put("mulai",ml);
                    values.put("selesai",sl);
                    values.put("keterangan",kt);
                    values.put("status",st);
                    dbController.UpdateData(values);
                    callHome();
                }
            }
        });
    }
    public void callHome(){
        Intent i = new Intent(EditKaryawan.this,Data.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
