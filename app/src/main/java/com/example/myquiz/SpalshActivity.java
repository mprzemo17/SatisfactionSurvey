package com.example.myquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.telephony.SubscriptionPlan;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.ComparisonChain.start;
import static java.lang.Thread.sleep;

public class SpalshActivity extends AppCompatActivity {

    private TextView appName;

 public static List<String> catList = new ArrayList<>();
 private FirebaseFirestore firestore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        appName = findViewById(R.id.appName);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.blacklist);
        appName.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        appName.setAnimation(anim);


        firestore = FirebaseFirestore.getInstance();



        new Thread() {
            @Override
            public void run() {

//                try {
//                    sleep(3000);

                    loadData();

//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//                Intent intent = new Intent(SpalshActivity.this, MainActivity.class);
//                startActivity(intent);
//                SpalshActivity.this.finish();

            }
        }.start();
    }



    private void loadData()
    {

        catList.clear();
        firestore.collection("QUIZ").document("Categories")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {


                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();

                    if (doc.exists())
                    {
                        long count = (long)doc.get("COUNT");

                        for (int i = 1; i <= count; i++)
                        {
                            String catName = doc.getString("CAT" + String.valueOf(i));  //succesfull query

                            catList.add(catName);
                        }

                        Intent intent = new Intent(SpalshActivity.this, MainActivity.class);
                        startActivity(intent);
                        SpalshActivity.this.finish();


                    } else {
                        Toast.makeText(SpalshActivity.this, "No Category Document Exsist!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else  //fail
                {
                    Toast.makeText(SpalshActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
                });

    }


}