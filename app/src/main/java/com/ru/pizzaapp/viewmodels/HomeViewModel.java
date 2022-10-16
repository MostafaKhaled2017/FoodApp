package com.ru.pizzaapp.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ru.pizzaapp.FoodService;
import com.ru.pizzaapp.models.Food;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    MutableLiveData<ArrayList<Food>> menuLiveData;

    FoodService foodService = new FoodService();

    public HomeViewModel() {
        menuLiveData = new MutableLiveData<>();
        init();
    }
    public MutableLiveData<ArrayList<Food>> getFoodMutableLiveData(){
        return menuLiveData;
    }

    public void init(){

        fetchMenu();

    }

    private void fetchMenu() {
        menuLiveData = foodService.fetchMenu();
    }
}
