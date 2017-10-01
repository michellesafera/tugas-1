package com.example.michelle.resep_michelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements ResepAdapter.ResepListener {
    private ResepAdapter adapter;
    public static final String POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        String judul [] = getResources().getStringArray(R.array.judul_resep);
        Log.v("Main",judul[0]);
        String ket [] =  getResources().getStringArray(R.array.deskripsi_bahan);
        adapter = new ResepAdapter(judul, ket, this);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,adapter.getJudul(position));
        intent.putExtra(POSITION,position);
        startActivity(intent);
    }
}
