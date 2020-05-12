package com.tinuade.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent=getIntent();
        String message= intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView=findViewById(R.id.orderMessage);
        textView.setText(message);


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked=((RadioButton)view).isChecked();
        switch(view.getId()){
            case R.id.sameday:
                if (checked){
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                }
                break;
            case R.id.nextday:
                if (checked){
                    // next day service
                    displayToast(getString(R.string.next_day_ground_delivery));
                }
                break;
            case R.id.pickup:
                if (checked){
                    //pick up
                    displayToast(getString(R.string.pick_up));
                }
        }
    }
    public void displayToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
