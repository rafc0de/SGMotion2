package com.example.sg2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sg2.DetailMenuActivity;
import com.example.sg2.Model.Makanan;
import com.example.sg2.R;

import java.util.List;

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.MyViewHolder> {
    private Context context;
    private List<Makanan> makananList;

    public ListMenuAdapter(Context context, List<Makanan> makananList) {
        this.context = context;
        this.makananList = makananList;
    }

    @NonNull
    @Override
    public ListMenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMenuAdapter.MyViewHolder myViewHolder, int i) {
        final Makanan makanan = makananList.get(i);
        myViewHolder.foodTitle.setText(makanan.getTitle());
        myViewHolder.foodPrice.setText("Rp "+makanan.getTitle());

        myViewHolder.cardMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailMenuActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return makananList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView foodTitle;
        TextView foodPrice;
        CardView cardMenu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodTitle = itemView.findViewById(R.id.tv_judul_makanan);
            foodPrice = itemView.findViewById(R.id.tv_harga_makanan);
            cardMenu = itemView.findViewById(R.id.cardview_menu);
        }
    }
}
