package com.example.myquiz;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class SetsActivity extends AppCompatActivity {

    private GridView sets_grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        Toolbar toolbar = findViewById(R.id.set_toolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("CATEGORY");
        getSupportActionBar().setTitle(title);  //nazwa kategorii którą kliknąął użytkownik

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //button wstecz na toolbarze

        sets_grid = findViewById(R.id.sets_gridview);


        SetsAdapter adapter = new SetsAdapter(6); //ile setów ma być wygenerowanych
        sets_grid.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item .getItemId() == android.R.id.home)
        {
            SetsActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}