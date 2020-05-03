package com.developer2t.uts_1710510031_sutrisno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class FoodDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        Intent intent = getIntent();
        int foodImages =intent.getIntExtra("images",1);
        String foodName =intent.getStringExtra("foodName");
        String foodDetail =intent.getStringExtra("foodDetail");
        String discountedPrice =intent.getStringExtra("discountedPrice");
        String generalPrice =intent.getStringExtra("generalPrice");

        ImageView itemImages = findViewById(R.id.item_images);
        TextView tv_foodDetail = findViewById(R.id.tv_foodDetail);
        TextView tv_generalPrice = findViewById(R.id.tv_general_foodPrice);
        TextView tv_discountedPrice = findViewById(R.id.tv_discounted_foodPrice);
        TextView tv_foodName = findViewById(R.id.tv_foodName);


        Glide.with(this)
                .load(foodImages)
                .apply(new RequestOptions())
                .into(itemImages);

        tv_foodName.setText(foodName);
        tv_foodDetail.setText(foodDetail);
        tv_discountedPrice.setText(discountedPrice);
        tv_generalPrice.setText(generalPrice);
        tv_generalPrice.setPaintFlags(tv_generalPrice.getPaintFlags()
                | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    public void btnClick (View view){
        Toast.makeText(this,
                "Makanan ini berhasil di tambahkan ke keranjang",
                Toast.LENGTH_SHORT).show();
    }
}
