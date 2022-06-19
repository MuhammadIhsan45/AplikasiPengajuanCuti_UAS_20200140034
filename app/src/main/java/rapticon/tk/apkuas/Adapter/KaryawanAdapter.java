package rapticon.tk.apkuas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import rapticon.tk.apkuas.Data;
import rapticon.tk.apkuas.Database;
import rapticon.tk.apkuas.EditKaryawan;
import rapticon.tk.apkuas.Karyawan;
import rapticon.tk.apkuas.R;

public class KaryawanAdapter extends RecyclerView.Adapter<KaryawanAdapter.TemanViewHolder> {
    private ArrayList<Karyawan> listData;
    public KaryawanAdapter(ArrayList<Karyawan> listData) {
        this.listData = listData;
    }

    private Context control;


    @Override
    public KaryawanAdapter.TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_karyawan, parent, false);
        control = parent.getContext();
        return new TemanViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull KaryawanAdapter.TemanViewHolder holder, int position) {
        String ml, bd, sl, id, nm, kt, st;

        id = listData.get(position).getId();
        nm = listData.get(position).getNama();
        bd = listData.get(position).getBidang();
        ml = listData.get(position).getMulai();
        sl = listData.get(position).getSelesai();
        kt = listData.get(position).getKeterangan();
        st = listData.get(position).getStatus();
        Database db = new Database(control);

        holder.namaTxt.setTextColor(Color.WHITE);
        holder.namaTxt.setTextSize(20);
        holder.namaTxt.setText(nm);
        holder.bidangTxt.setTextColor(Color.WHITE);
        holder.bidangTxt.setTextSize(20);
        holder.bidangTxt.setText(bd);
        holder.mulaiTxt.setTextColor(Color.WHITE);
        holder.mulaiTxt.setTextSize(20);
        holder.mulaiTxt.setText(ml);
        holder.selesaiTxt.setTextColor(Color.WHITE);
        holder.selesaiTxt.setTextSize(20);
        holder.selesaiTxt.setText(sl);
        holder.keteranganTxt.setTextColor(Color.WHITE);
        holder.keteranganTxt.setTextSize(20);
        holder.keteranganTxt.setText(kt);
        holder.statusTxt.setTextColor(Color.RED);
        holder.statusTxt.setTextSize(20);
        holder.statusTxt.setText(st);

        holder.cardku.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(control, holder.cardku);
                popupMenu.inflate(R.menu.pop_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem Item) {
                        switch (Item.getItemId()) {
                            case R.id.mnEdit:
                                Intent i = new Intent(control, EditKaryawan.class);
                                i.putExtra("id", id);
                                i.putExtra("nama", nm);
                                i.putExtra("bidang", bd);
                                i.putExtra("mulai", ml);
                                i.putExtra("selesai", sl);
                                i.putExtra("keterangan", kt);
                                i.putExtra("status", st);
                                control.startActivity(i);
                                break;
                            case R.id.mnHapus:
                                HashMap<String, String> values = new HashMap<>();
                                values.put("id", id);
                                db.DeleteData(values);
                                Intent j = new Intent(control, Data.class);
                                control.startActivity(j);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listData != null) ? listData.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView mulaiTxt, selesaiTxt, namaTxt, keteranganTxt, statusTxt, bidangTxt;

        public TemanViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
            namaTxt = (TextView) view.findViewById(R.id.txt_nama);
            bidangTxt = (TextView) view.findViewById(R.id.txt_bidang);
            mulaiTxt = (TextView) view.findViewById(R.id.txt_mulai);
            selesaiTxt = (TextView) view.findViewById(R.id.txt_selesai);
            keteranganTxt = (TextView) view.findViewById(R.id.txt_ket);
            statusTxt = (TextView) view.findViewById(R.id.txt_status);


        }
    }

}
