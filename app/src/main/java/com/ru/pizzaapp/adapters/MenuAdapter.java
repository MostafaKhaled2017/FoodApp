package com.ru.pizzaapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ru.pizzaapp.R;
import com.ru.pizzaapp.models.Food;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.EventsViewHolder> {
    private List<Food> foodList;
    private Context mContext;

    public MenuAdapter(Context context) {
        foodList = new ArrayList<>();
        mContext = context;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_card, parent, false);
        return new EventsViewHolder(item);
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        final Food currentFood = foodList.get(position);
        holder.foodItem.setText(currentFood.getName());

        //Load the image in the app using glide library
        Glide.with(mContext).load(currentFood.getImageUrl()).into(holder.foodImage);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    class EventsViewHolder extends RecyclerView.ViewHolder {
        TextView foodItem;
        ImageView foodImage;

        EventsViewHolder(View itemView) {
            super(itemView);
            foodItem = itemView.findViewById(R.id.item_name);
            foodImage = itemView.findViewById(R.id.food_image);

        }

    }
}
