package com.ecommerce.android.internshipproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView recyclerView;
    List<Model> modelList;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        modelList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Details");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelList.clear();

                for (DataSnapshot modelSnapshot : snapshot.getChildren()){
                    Model model = modelSnapshot.getValue(Model.class);
                    modelList.add(model);
                }

                Adapter adapter = new Adapter(MainActivity.this,modelList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        TextView total = findViewById(R.id.cardView2);
//
//      int username = getIntent().getIntExtra("sumis",0);
//
//        total.setText(String.valueOf(username));





        String CurrentDate ,  CurrentTime;
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd,yyyy");
        CurrentDate  = simpleDateFormat.format(cal.getTime());


        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss a");
        CurrentTime = simpleDateFormat1.format(cal.getTime());

      
    }
}