package com.example.michelle.resep_michelle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Michelle on 9/23/2017.
 */
public class DetailActivity extends AppCompatActivity {
    private ArrayList<Integer> mImageID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutitem);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        addImageID();
        bindData();
        TextView judulResep = (TextView)findViewById(R.id.judulResep);
        judulResep.setSelected(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void bindData(){
        int position;
        String judulresep;
        String bahan [] = getResources().getStringArray(R.array.detail_resepku);
        String cara [] = getResources().getStringArray(R.array.cara_resep);

        Intent intent = getIntent();
        judulresep = intent.getStringExtra(Intent.EXTRA_TEXT);
        position = intent.getIntExtra(MainActivity.POSITION, 0);
        TextView my_judul = (TextView) findViewById(R.id.judulResep);
        TextView my_bahan = (TextView) findViewById(R.id.bahan);

        TextView tv_keterangan = (TextView) findViewById(R.id.keterangan);
        ImageView image = (ImageView) findViewById(R.id.gambar);
        my_judul.setText(judulresep);
        my_bahan.setText(bahan[position]);

        tv_keterangan.setText(cara[position]);
        image.setImageResource(mImageID.get(position));

    }
    private void addImageID(){
        mImageID = new ArrayList<>();

        mImageID.add(R.drawable.satu);
        mImageID.add(R.drawable.dua);
        mImageID.add(R.drawable.tiga);
        mImageID.add(R.drawable.empat);
        mImageID.add(R.drawable.lima);
        mImageID.add(R.drawable.enam);
        mImageID.add(R.drawable.tujuh);
        mImageID.add(R.drawable.delapan);
        mImageID.add(R.drawable.sembilan);
        mImageID.add(R.drawable.sepuluh);
    }
}
