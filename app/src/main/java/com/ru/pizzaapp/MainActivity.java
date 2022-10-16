package com.ru.pizzaapp;

import static com.ru.pizzaapp.utils.Firebase.fireStoreDb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.ru.pizzaapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //TODO: Adding progressbar with the pattern?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.ru.pizzaapp.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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