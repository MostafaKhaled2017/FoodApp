package com.ru.pizzaapp.views;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ru.pizzaapp.R;
import com.ru.pizzaapp.adapters.MenuAdapter;
import com.ru.pizzaapp.databinding.FragmentHomeBinding;
import com.ru.pizzaapp.models.Food;
import com.ru.pizzaapp.viewmodels.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    RecyclerView recyclerView;
    MenuAdapter menuAdapter;

    Spinner citiesSpinner;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.foodRecyclerview;
        menuAdapter = new MenuAdapter(getContext());
        citiesSpinner = binding.citiesSpinner;

        initializeSpinner();

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

    private void initializeSpinner() {
        //Assign the string array to the spinner
        ArrayAdapter<String> customAdapter= new ArrayAdapter(getContext(), R.layout.spinner_item, R.id.spinner_text, getResources().getStringArray(R.array.russian_cities));
        citiesSpinner.setAdapter(customAdapter);

        citiesSpinner.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);


        //TODO: Set a maximum height for the spinner, so that it doesn't take up the whole screen

        citiesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String city = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}