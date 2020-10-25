package com.swapnil.intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.swapnil.intents.databinding.ActivityReceiverBinding;

public class ReceiverActivity extends AppCompatActivity {

    ActivityReceiverBinding activityReceiverBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        activityReceiverBinding = ActivityReceiverBinding.inflate(getLayoutInflater());
        setContentView(activityReceiverBinding.getRoot());
        Intent intent = getIntent();
        String s = intent.getStringExtra(SenderActivity.EXTRA_MESSAGE);
        activityReceiverBinding.receiverTxt.setText(s);


        activityReceiverBinding.btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = activityReceiverBinding.replyMssg.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(SenderActivity.EXTRA_MESSAGE, res);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }


}