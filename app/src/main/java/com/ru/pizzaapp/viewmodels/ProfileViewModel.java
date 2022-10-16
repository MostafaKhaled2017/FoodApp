package com.ru.pizzaapp.viewmodels;

import static com.ru.pizzaapp.utils.Strings.SOON;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(SOON);
    }

    public LiveData<String> getText() {
        return mText;
    }
}