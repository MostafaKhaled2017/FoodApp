package com.ru.pizzaapp.views.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ru.pizzaapp.adapters.MenuAdapter;
import com.ru.pizzaapp.databinding.FragmentHomeBinding;
import com.ru.pizzaapp.models.Food;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    RecyclerView recyclerView;
    MenuAdapter menuAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.foodItemsCategory;
        menuAdapter = new MenuAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(menuAdapter);



        recyclerView.setNestedScrollingEnabled(false);


        Observer<ArrayList<Food>> foodListUpdateObserver = foods -> {
            menuAdapter.setFoodList(foods);
            menuAdapter.notifyDataSetChanged();
        };

        homeViewModel.getFoodMutableLiveData().observe(getViewLifecycleOwner(), foodListUpdateObserver);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}