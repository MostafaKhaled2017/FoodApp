package com.ru.pizzaapp.views.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ru.pizzaapp.models.Food;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    MutableLiveData<ArrayList<Food>> menuLiveData;
    ArrayList<Food> menuList;

    public HomeViewModel() {
        menuLiveData = new MutableLiveData<>();
        init();
    }
    public MutableLiveData<ArrayList<Food>> getFoodMutableLiveData(){
        return menuLiveData;
    }

    public void init(){

        // Adding data to the list
        //TODO get data from server
        menuList = new ArrayList<>();
        menuList.add(new Food("Pizza", "Delecious Pizza", "https://www.pizzahut.com.ua/images/2019/11/26/5ddc0b0b5b8b0.jpg"));
        menuList.add(new Food("Burger", "Nice Burger", "https://www.pizzahut.com.ua/images/2019/11/26/5ddc0b0b5b8b0.jpg"));
        menuList.add(new Food("Salad", "Green Salad", "https://www.pizzahut.com.ua/images/2019/11/26/5ddc0b0b5b8b0.jpg"));
        menuList.add(new Food("Dessert", "Cool dessert", "https://www.pizzahut.com.ua/images/2019/11/26/5ddc0b0b5b8b0.jpg"));

        menuLiveData.setValue(menuList);
    }
}
