package com.ru.pizzaapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ru.pizzaapp.R;
import com.ru.pizzaapp.models.Category;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.EventsViewHolder> {
    private List<Category> categoriesList;
    private Context mContext;
    public CategoriesAdapter(Context context, List<Category> categoryList){
        this.mContext=context;
        this.categoriesList =categoryList;

    }
    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new EventsViewHolder(item);
    }
    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        final Category currentCategory = categoriesList.get(position);
        holder.category.setText(currentCategory.getName());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
    class EventsViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        EventsViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category_name);
        }

    }
}
