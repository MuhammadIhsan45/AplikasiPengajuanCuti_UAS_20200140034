package rapticon.tk.apkuas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import rapticon.tk.apkuas.Adapter.KaryawanAdapter;

public class Data extends AppCompatActivity {
    private RecyclerView recyclerView;
    private KaryawanAdapter adapter;
    private ArrayList<Karyawan> karyawanArrayList;
    Database controller = new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_data);

        recyclerView =(RecyclerView) findViewById(R.id.recycleView);
        BacaData();
        adapter = new KaryawanAdapter(karyawanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Data.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
    public void BacaData(){
        ArrayList<HashMap<String,String>> daftarTeman = controller.getAllTeman();
        karyawanArrayList = new ArrayList<>();
        //memindah dari hasil query kedalam Karyawan
        for(int i=0;i<daftarTeman.size();i++){
            Karyawan karyawan = new Karyawan();
            karyawan.setId(daftarTeman.get(i).get("id").toString());
            karyawan.setNama(daftarTeman.get(i).get("nama").toString());
            karyawan.setBidang(daftarTeman.get(i).get("bidang").toString());
            karyawan.setMulai(daftarTeman.get(i).get("mulai").toString());
            karyawan.setSelesai(daftarTeman.get(i).get("selesai").toString());
            karyawan.setKeterangan(daftarTeman.get(i).get("keterangan").toString());
            karyawan.setStatus(daftarTeman.get(i).get("status").toString());
            //pindahkan dari karyawan kedalam ArrayList karyawan di adapter

            karyawanArrayList.add(karyawan);
        }
    }
}