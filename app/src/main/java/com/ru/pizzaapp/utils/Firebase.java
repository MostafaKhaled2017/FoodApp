package com.ru.pizzaapp.utils;

import com.google.firebase.firestore.FirebaseFirestore;

public class Firebase {

    //FireStore is used as a source for the menu data
    public static FirebaseFirestore fireStoreDb = FirebaseFirestore.getInstance();
}
