package com.developer2t.uts_1710510031_sutrisno;

import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardFoodAdapter extends RecyclerView.Adapter<CardFoodAdapter.CardViewViewHolder> {

    private ArrayList<Food> listFood;

    public CardFoodAdapter(ArrayList<Food> list) {
        this.listFood = list;
    }

    @NonNull
    @Override
    public CardFoodAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_food_menus, viewGroup, false);

        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardFoodAdapter.CardViewViewHolder holder, int position) {
        final Food food = listFood.get(position);

        Glide.with(holder.itemView.getContext())
                .load(food.getImagesFood())
                .apply(new RequestOptions().override(350, 350))
                .into(holder.images);

        holder.tv_foodName.setText(food.getFoodName());
        holder.tv_foodDetail.setText(food.getFoodDetail());
        holder.tv_discountedPrice.setText(food.getDiscountedPrice());
        holder.tv_generalPrice.setText(food.getGeneralPrice());
        holder.tv_generalPrice.setPaintFlags(holder.tv_generalPrice.getPaintFlags()
                | Paint.STRIKE_THRU_TEXT_FLAG);

        //event onClick Listener
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),
                        "Berhasil di tambahkan",
                        Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(), FoodDetail.class);

                intent.putExtra("foodName", food.getFoodName());
                intent.putExtra("foodDetail", food.getFoodDetail());
                intent.putExtra("discountedPrice", food.getDiscountedPrice());
                intent.putExtra("generalPrice", food.getGeneralPrice());
                intent.putExtra("images", food.getImagesFood());
                holder.itemView.getContext().startActivity(intent);
                Log.e("ONCLICK", "DI CLICK NIHHHH");
            }
        });




    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {

        ImageView images;
        TextView tv_foodName, tv_foodDetail, tv_discountedPrice, tv_generalPrice;
        Button btnAdd;

        public CardViewViewHolder(@NonNull View itemView) {

            super(itemView);
            tv_foodName = itemView.findViewById(R.id.tv_foodName);
            tv_foodDetail = itemView.findViewById(R.id.tv_foodDetail);
            tv_discountedPrice = itemView.findViewById(R.id.tv_discounted_foodPrice);
            tv_generalPrice = itemView.findViewById(R.id.tv_general_foodPrice);
            btnAdd = itemView.findViewById(R.id.btnAdd);
            images = itemView.findViewById(R.id.img_food);
        }
    }
}
