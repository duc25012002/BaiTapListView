package com.example.buoi4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_danh_sach_ngon_ngu_code;
    ArrayList<String> danh_sach_ngon_ngu;
    String luuTru;

    EditText edt_nhap_du_lieu_them;

    Button btn_chon_su_kien, btn_chon_sua;

    int viTri = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        xuLy();
    }

    private void xuLy() {
        //b2
        danh_sach_ngon_ngu = new ArrayList<>();
        danh_sach_ngon_ngu.add("Android");
        danh_sach_ngon_ngu.add("Java");
        danh_sach_ngon_ngu.add("Flutter");
        danh_sach_ngon_ngu.add("IOS");
        danh_sach_ngon_ngu.add("C");

        //b3
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                danh_sach_ngon_ngu);


        //b4
        lv_danh_sach_ngon_ngu_code.setAdapter(adapter);


        //tao su kien click tren listview

        //nhan click luon
        lv_danh_sach_ngon_ngu_code.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // i: tra ve gia tri click tren lv.
                Toast.makeText(MainActivity.this, danh_sach_ngon_ngu.get(i) + " " + i, Toast.LENGTH_SHORT).show();
            }
        });


        //nhan click giu
        lv_danh_sach_ngon_ngu_code.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                luuTru = danh_sach_ngon_ngu.get(i);
                danh_sach_ngon_ngu.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Remove succes!" + " " + luuTru, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        //them du lieu vao listview
        btn_chon_su_kien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                danh_sach_ngon_ngu.add(edt_nhap_du_lieu_them.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });


        //sua du lieu
        lv_danh_sach_ngon_ngu_code.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_nhap_du_lieu_them.setText(danh_sach_ngon_ngu.get(i));
                viTri = i;
            }
        });


        btn_chon_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                danh_sach_ngon_ngu.set(viTri, edt_nhap_du_lieu_them.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void anhXa() {
        lv_danh_sach_ngon_ngu_code = (ListView) findViewById(R.id.lv_danh_sach_ngon_ngu_code);
        edt_nhap_du_lieu_them = findViewById(R.id.edt_nhap_du_lieu_them);
        btn_chon_su_kien = findViewById(R.id.btn_chon_su_kien);
        btn_chon_sua = findViewById(R.id.btn_chon_sua);
    }

}