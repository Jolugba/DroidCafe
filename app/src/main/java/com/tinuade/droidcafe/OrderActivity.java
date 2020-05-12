package com.tinuade.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent=getIntent();
        String message= intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView=findViewById(R.id.orderMessage);
        textView.setText(message);

        // Create the spinner.
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.labels_array,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner!=null){
            spinner.setAdapter(adapter);
        }


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

    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Implementers can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      String spinnerLabel = parent.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
