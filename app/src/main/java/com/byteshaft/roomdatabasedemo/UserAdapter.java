package com.byteshaft.roomdatabasedemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<String> arrayList;

    UserAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.userName.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;

        public ViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
        }
    }
}
