package com.developer2t.uts_1710510031_sutrisno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMenus;
    private ArrayList <Food> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bgApps = findViewById(R.id.bg_apps);
        LinearLayout textSplash = findViewById(R.id.txt_splash);
        LinearLayout content = findViewById(R.id.textContent);
        Animation showContent = AnimationUtils.loadAnimation(this, R.anim.contentanimet);

        bgApps.animate().alpha(0).setDuration(1700).setStartDelay(700);
        textSplash.animate().alpha(0).setDuration(1900).setStartDelay(300);
        content.startAnimation(showContent);

        rvMenus = findViewById(R.id.rvMenus);
        list.addAll(FoodData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView () {
        rvMenus.setLayoutManager(new LinearLayoutManager(this));
        CardFoodAdapter cardFoodAdapter = new CardFoodAdapter(list);
        rvMenus.setAdapter(cardFoodAdapter);
    }
}
