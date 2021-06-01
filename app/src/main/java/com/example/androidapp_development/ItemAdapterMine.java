package com.example.androidapp_development;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapterMine extends RecyclerView.Adapter<ItemAdapterMine.ViewHolder>
{
    List<Model>itemList1;

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent,int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem1,parent,false);
        return new ViewHolder(view);

    }

    public ItemAdapterMine(List<Model>itemList)
    {
        this.itemList1=itemList;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemImage.setImageResource(itemList1.get(position).getImage());
    holder.itemtext.setText(itemList1.get(position).getName());

        holder.button.setText("message");
        holder.button.setOnClickListener(v -> Toast.makeText(v.getContext()," Clicked on " + itemList1.get(position).getName(),Toast.LENGTH_SHORT).show());


    }

    @Override
    public int getItemCount() {
      return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemtext;
        Button button;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            itemImage=itemView.findViewById(R.id.itemImg);
            itemtext=itemView.findViewById(R.id.itemName);
            button=itemView.findViewById(R.id.likeButton);


        }


        public void setOnClickListener(View.OnClickListener onClickListener) {
        }
    }
}

