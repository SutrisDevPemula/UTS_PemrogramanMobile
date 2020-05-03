package com.developer2t.uts_1710510031_sutrisno;

import java.util.ArrayList;

public class FoodData {

    private static String foodName[] = {
            "Paket Nila Goreng",
            "Nasi Ayam Geprek",
            "Paket Ayam Taliwang",
            "Nasi Rendang Sapi Cup",
            "Nasi Pecel"
    };

    private static String discountedPrice[] ={
            "Rp. 22.000",
            "Rp. 12.500",
            "Rp. 40.000",
            "Rp. 15.000",
            "Rp. 15.000"
    };

    private static String generalPrice[] = {
            "Rp. 27.500",
            "Rp. 16.000",
            "Rp. 45.000",
            "Rp. 25.000",
            "Rp. 20.000"
    };

    private static String foodDetail[] = {
            "Isi Paket (nila + nasi + tempe goreng + lalapan + es jeruk/es teh)",
            "Isi paket nasi + ayam + lalapan",
            "Isi Paket (nasi + ayam + tempe goreng + lalapan + es jeruk/es teh)",
            "Nasi rendang sapi cup bundo bali dijamin halal menggunakan daging sapi enak tepat " +
                    "untuk digunakan baik makan pagi, siang maupun malam",
            "Nasi pecel khas medan Isi (Nasi + sate jeroan + kripik + tempa goreng + sambel pecel + sayur)"
    };

    private static int photo[] = {
            R.drawable.nila,
            R.drawable.ayamgeprek,
            R.drawable.ayamtaliwang,
            R.drawable.nasi_rendang_sapi,
            R.drawable.nasi_pecel
    };

    static ArrayList <Food> getListData() {
        ArrayList<Food> list = new ArrayList<>();
        for (int i = 0; i < photo.length; i++) {
            Food food = new Food();
            food.setImagesFood(photo[i]);
            food.setFoodName(foodName[i]);
            food.setFoodDetail(foodDetail[i]);
            food.setDiscountedPrice(discountedPrice[i]);
            food.setGeneralPrice(generalPrice[i]);
            list.add(food);
        }

        return list;
    }
}
