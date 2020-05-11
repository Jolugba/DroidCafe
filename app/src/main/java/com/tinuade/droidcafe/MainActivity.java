package com.tinuade.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";
   private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void showDonutOrders(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }



    public void showFroyoOrder(View view) {
          mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }

    public void showIceCreamOrders(View view) {
          mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }


    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void fabButtonClicked(View view) {
        Intent intent=new Intent(this,OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);


    }
}