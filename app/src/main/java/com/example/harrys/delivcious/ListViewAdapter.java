package com.example.harrys.delivcious;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Product> {

    public ListViewAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
    }

    private static class ViewHolder {
        ImageView myImage;
        TextView myTitle;
        TextView myDesc;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.baris, parent, false);
            holder = new ViewHolder();

            holder.myImage = (ImageView) convertView.findViewById(R.id.gambarList);
            holder.myTitle = (TextView) convertView.findViewById(R.id.nama_delivList);
            holder.myDesc = (TextView) convertView.findViewById(R.id.deskripsiList);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = getItem(position);

        holder.myImage.setImageResource(product.getImages());
        holder.myTitle.setText(product.getmJudul());
        holder.myDesc.setText(product.getmDeskripsi());

        return convertView;
    }
}
