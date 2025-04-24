package com.example.fro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowActivity extends AppCompatActivity {

    TextView showText;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        showText = findViewById(R.id.showText);

        listView = findViewById(R.id.listView);

        Intent i = getIntent();

        String myText = i.getStringExtra("mytext");

        int myInt = i.getIntExtra("mynumber",0);

        Log.d("MYTAG",myInt+"");

        showText.setText(myText);

        String[] myArray = {"Item 1", "Item2", "Item3"};

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return myArray.length;
            }

            @Override
            public Object getItem(int i) {
                return myArray[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View v = LayoutInflater.from(ShowActivity.this).inflate(R.layout.list_item,viewGroup,false);
                //προσοχή το false στο τέλος!!!
                TextView text = v.findViewById(R.id.list_item_text);
                text.setText(getItem(i).toString());
                return v;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ShowActivity.this, "Item: "+i+" clicked!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}