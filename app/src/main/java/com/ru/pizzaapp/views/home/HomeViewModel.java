package com.ru.pizzaapp.views.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment\n" +
                "        <com.google.android.material.appbar.CollapsingToolbarLayout\n" +
                "            id=\"@+id/collapsing_toolbar\"\n" +
                "            android:layout_width=\"match_parent\"\n" +
                "            android:layout_height=\"match_parent\"\n" +
                "            android:fitsSystemWindows=\"true\"\n" +
                "            app:contentScrim=\"?attr/colorPrimary\"\n" +
                "            app:layout_scrollFlags=\"scroll|snap|exitUntilCollapsed\"\n" +
                "            app:title=\"Pizza App\">\n" +
                "\n" +
                "            <androidx.appcompat.widget.AppCompatImageView\n" +
                "                android:layout_width=\"450dp\"\n" +
                "                android:layout_height=\"250dp\"\n" +
                "                android:src=\"@drawable/ic_notifications_black_24dp\"\n" +
                "                android:scaleType=\"centerCrop\"\n" +
                "                android:layout_gravity=\"center|end\"\n" +
                "                android:layout_margin=\"10dp\"\n" +
                "                app:layout_collapseMode=\"parallax\"/>\n" +
                "\n" +
                "            <androidx.appcompat.widget.Toolbar\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:layout_height=\"match_parent\">\n" +
                "\n" +
                "            </androidx.appcompat.widget.Toolbar>\n" +
                "\n" +
                "        </com.google.android.material.appbar.CollapsingToolbarLayout>");
    }

    public LiveData<String> getText() {
        return mText;
    }
}