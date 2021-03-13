package com.example.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Customadapter extends BaseAdapter {


    Context context;
    String[] name;
    int[] image;

    public Customadapter(Context context, String[] name, int[] image) {
        this.context = context;
        this.name = name;
        this.image = image;
    }


    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.listfile, null);
        TextView nameTv = view.findViewById(R.id.userName);
        ImageView imageView = view.findViewById(R.id.userImage);
        nameTv.setText(name[position]);
        imageView.setImageResource(image[position]);
        return view;
    }
}
