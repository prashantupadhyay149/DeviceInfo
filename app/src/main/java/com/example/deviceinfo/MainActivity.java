package com.example.deviceinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   EditText Number1;
   int i;
   Button Increment,Decrement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Number1 =findViewById( R.id.Number );
        Increment=findViewById( R.id.Increment );
        Decrement=findViewById( R.id.Decrement );

        Number1.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


               if( Number1.getText().toString().equalsIgnoreCase( "" )){
                   Increment.setEnabled( false );
                   Decrement.setEnabled( false );
               }
               else if(Number1.getText().toString().equalsIgnoreCase( "0" )){;
                   i=0;
                   Increment.setEnabled( true );
                   Decrement.setEnabled( false );
                }
               else {
                   i = Integer.valueOf( Number1.getText().toString() );
                   Increment.setEnabled( true );
                   Decrement.setEnabled( true );
               }


            }

            @Override
            public void afterTextChanged(Editable s) {




            }
        } );

        Increment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++i;
                Number1.setText( String.valueOf( i )  );
            }
        } );

        Decrement.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --i;
                Number1.setText(String.valueOf( i )   );
            }
        } );



    }
}