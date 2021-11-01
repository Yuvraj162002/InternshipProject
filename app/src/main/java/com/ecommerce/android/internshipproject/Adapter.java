package com.ecommerce.android.internshipproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;



public class Adapter extends ArrayAdapter {

    private Activity context;
    List<Model> modelList;
     public Adapter(Activity context,  List<Model> modelList) {
        super(context, R.layout.llist_view, modelList);
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.llist_view,null,true);

        TextView ename = view.findViewById(R.id.name);
        TextView eprice = view.findViewById(R.id.total_value);
        TextView epiece  = view.findViewById(R.id.piece);

        Model model = modelList.get(position);

        ename.setText(model.getName());
        epiece.setText(model.getPiece());
        eprice.setText(model.getPrice());

        return  view;
    }
}
