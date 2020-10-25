package com.swapnil.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.swapnil.intents.databinding.ActivityMainBinding;

public class SenderActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    public static final String EXTRA_MESSAGE = "name";
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String src = data.getStringExtra(EXTRA_MESSAGE);
            activityMainBinding.returnTxt.setText(src);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String send_mssg = activityMainBinding.btnSendtext.getText().toString();
                Intent intent = new Intent(SenderActivity.this, ReceiverActivity.class);
                intent.putExtra(EXTRA_MESSAGE, send_mssg);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }
}