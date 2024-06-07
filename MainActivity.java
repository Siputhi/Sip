package com.example.permissionwebsite;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  private Button requestPermissionButton;
  private Button sendDataButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    requestPermissionButton = findViewById(R.id.request_permission);
    sendDataButton = findViewById(R.id.send_data);

    requestPermissionButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS}, 1);
      }
    });

    sendDataButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (checkSelfPermission(android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
          // Send data to Telegram bot
          // ...
        } else {
          requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS}, 1);
        }
      }
    });
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {