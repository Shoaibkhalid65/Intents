package com.example.intents;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnImplicit, btnExplicit;
    EditText edFirstName, edSecondName;
    public static final int SECOND_ACTIVITY_REQUEST_CODE = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnImplicit = findViewById(R.id.btn_implicit);
        btnExplicit = findViewById(R.id.btn_explicit);
        edFirstName = findViewById(R.id.ed_firstName);
        edSecondName = findViewById(R.id.ed_secondName);
        ActivityResultLauncher <SecondActivityArgument> launcher=registerForActivityResult(new SecondActivityContract(), new ActivityResultCallback<String>() {
            @Override
            public void onActivityResult(String output) {
                Toast.makeText(MainActivity.this, "Output : "+output, Toast.LENGTH_SHORT).show();
            }
        });

        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String firstName=edFirstName.getText().toString();
               String secondName=edSecondName.getText().toString();
               launcher.launch(new SecondActivityArgument(firstName,secondName));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SECOND_ACTIVITY_REQUEST_CODE&&resultCode==RESULT_OK){
            String resultData=data.getData().toString();
            Toast.makeText(this, "Full name is "+resultData, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Result not found", Toast.LENGTH_SHORT).show();
    }
}






