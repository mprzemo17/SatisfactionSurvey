package com.example.myquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.myquiz.SpalshActivity.catList; //dodane

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import static com.example.myquiz.SpalshActivity.catList;


public class CategoryActivity extends AppCompatActivity {

    private GridView catGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        catGrid = findViewById(R.id.catGridview);

//        List<String> catList = new ArrayList<>();
//
//        catList.add("SATYSFAKCJA HAIR");
//        catList.add("BARBER CIESZYN"); //ilość kategorii





        CatGridAdapter adapter = new CatGridAdapter(catList);//było catList
        catGrid.setAdapter(adapter);

   }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            CategoryActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}