package com.ru.pizzaapp;

import static com.ru.pizzaapp.utils.Firebase.fireStoreDb;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.ru.pizzaapp.models.Food;

import java.util.ArrayList;

public class FoodService {

    public MutableLiveData<ArrayList<Food>> fetchMenu() {
        MutableLiveData<ArrayList<Food>> menuLiveData = new MutableLiveData<>();

        //Fetching the data from firebase fireStore
        fireStoreDb.collection("menu").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<Food> menuList = new ArrayList<>();
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {

                        String name = documentSnapshot.getString("name");
                        String description = documentSnapshot.getString("description");
                        String imageUrl = documentSnapshot.getString("imageUrl");

                        Food food = new Food(name, description, imageUrl);

                        menuList.add(food);
                    }
                    menuLiveData.setValue(menuList);
                }
            }
        });

        return menuLiveData;
    }

}
