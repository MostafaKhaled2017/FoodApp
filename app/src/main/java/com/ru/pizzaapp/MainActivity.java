package com.ru.pizzaapp;

import static com.ru.pizzaapp.utils.Firebase.fireStoreDb;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.ru.pizzaapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //TODO: Reformat all code files
    //TODO: Test the app on different screen sizes and android versions
    //TODO: Remove redunant resources
    // TODO: Check the correctness of names of all files and directories
    //TODO: Make sure that the code is well documented and easy to understand
    //TODO: Modify the hardcoded values
    //TODO : Make all the app written in Russian language (Check other pages, Titles at the top and bottom .... )
    //TODO: Make the name of app and value consistent (Food or Pizza)
    //TODO: Revise all IDs in the xml files and make sure that they are unique and meaningful
    // TODO: Make sure that MVVM design pattern is completly followed (Check code of spinner and other pages)
    //TODO: Check the warnings of the different pages and fix them
    //TODO: Make sure to check the TODOs in all the other pages
    // TODO: Save copy of the TODOs written here

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //Initialize firebase settings to allow Offline persistence
        firebaseInit();
    }

    private void firebaseInit() {
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        fireStoreDb.setFirestoreSettings(settings);
    }


}