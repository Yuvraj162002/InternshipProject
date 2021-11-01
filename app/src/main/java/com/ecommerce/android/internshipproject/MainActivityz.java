package com.ecommerce.android.internshipproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityz extends AppCompatActivity {

    EditText ename;
    EditText price;
    EditText qty;
    EditText unitprice;

    MaterialButton save;
    TextView result;
    int total;

  DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityz);

         ename = findViewById(R.id.edit_text);
         price =  findViewById(R.id.edit_text2);
         qty = findViewById(R.id.edit_text5);
         unitprice = findViewById(R.id.edit_text3);
        save = findViewById(R.id.materialButton3);
        result = findViewById(R.id.text6);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Details");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityz.this,MainActivity.class);
                int num1 = Integer.valueOf(price.getText().toString());
                int num2 = Integer.valueOf(qty.getText().toString());
                int sum = num2*num1;

                intent.putExtra("sumis",sum);
                startActivity(intent);

                Detailsadded();


            }
        });

        qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.valueOf(price.getText().toString());
               int num2 = Integer.valueOf(qty.getText().toString());
                int sum = num2*num1;
              result.setText(String.valueOf(sum));



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        unitprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


    }

    private void Detailsadded() {
        String name = ename.getText().toString();
        String eprice  =price.getText().toString();
        String eqty = qty.getText().toString();
        String eunitprice = unitprice.getText().toString();

        Model model = new Model(name,eqty,eprice,eunitprice);

        databaseReference.push().setValue(model);
        Toast.makeText(MainActivityz.this, "Inserted", Toast.LENGTH_SHORT).show();
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);


        dialog.hide();
    }



}
