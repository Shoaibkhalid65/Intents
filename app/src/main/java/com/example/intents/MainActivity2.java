package com.example.intents;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView tvFirstName,tvSecondName;
    Button btnFinish;
    String firstName,secondName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvFirstName=findViewById(R.id.tv_firstname);
        tvSecondName=findViewById(R.id.tv_secondName);
        btnFinish=findViewById(R.id.btn_finish);
        firstName=getIntent().getStringExtra(SecondActivityContract.FIRST_NAME);
        secondName=getIntent().getStringExtra(SecondActivityContract.SECOND_NAME);
        tvFirstName.setText(firstName);
        tvSecondName.setText(secondName);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        Intent intent=new Intent();
        String fullName=firstName+" "+secondName;
        intent.setData(Uri.parse(fullName));
        setResult(RESULT_OK,intent);
        super.finish();
    }
}