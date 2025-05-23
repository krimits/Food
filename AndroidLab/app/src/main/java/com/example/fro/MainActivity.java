package com.example.fro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button btn;

    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        text = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        inputText = findViewById(R.id.input);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textString = inputText.getText().toString();

                Toast.makeText(MainActivity.this, "String: "+textString, Toast.LENGTH_SHORT).show();
                Log.d("MYTAG","String: "+textString);

                Intent i = new Intent(getApplicationContext(), ShowActivity.class);

                i.putExtra("mytext",textString);
                i.putExtra("mynumber",1234);

                startActivity(i);

                //text.setText(textString);
            }
        });

    }
}