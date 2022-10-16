package com.ru.pizzaapp;

import static com.ru.pizzaapp.utils.Firebase.fireStoreDb;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.ru.pizzaapp.models.Food;

import java.util.ArrayList;

public class FoodService {

    public MutableLiveData<ArrayList<Food>> fetchMenu() {
        MutableLiveData<ArrayList<Food>> menuLiveData = new MutableLiveData<>();

        //Fetching the data from firebase fireStore
        fireStoreDb.collection("menu").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<Food> menuList = new ArrayList<>();
                for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {

                    String name = documentSnapshot.getString("name");
                    String description = documentSnapshot.getString("description");
                    String imageUrl = documentSnapshot.getString("imageUrl");
                    String price = documentSnapshot.getString("price");

                    Food food = new Food(name, description, imageUrl, price);

                    menuList.add(food);
                }
                menuLiveData.setValue(menuList);
            }
        });

        return menuLiveData;
    }

}
