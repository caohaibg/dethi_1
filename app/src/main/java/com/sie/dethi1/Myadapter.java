package com.sie.dethi1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sie on 4/23/2018.
 */

public class Myadapter extends BaseAdapter {
    ArrayList<Sach> list;
    Context context;

    public Myadapter(ArrayList<Sach> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.item, null);

        ImageView imageView=view.findViewById(R.id.img);
        TextView ten=view.findViewById(R.id.ten);

        if (list.get(i).getTheloai().equals("1")){
            imageView.setImageResource(R.drawable.ic_camera_black_24dp);
        }else if (list.get(i).getTheloai().equals("2")){
            imageView.setImageResource(R.drawable.ic_cloud_black_24dp);
        }else {
            imageView.setImageResource(R.drawable.ic_beach_access_black_24dp);
        }
        ten.setText(list.get(i).getTen());
        return view;
    }
}
