package com.example.justorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quan=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plus(View view){
        TextView textView=findViewById(R.id.qtext);
        quan+=1;
        textView.setText(quan);
    }

    public void minus(View view){
        TextView textView=findViewById(R.id.qtext);
        if(quan==0)
            quan=0;
        else
            quan-=1;
        textView.setText(quan);
    }

    public void order(View view){
        TextView textView=findViewById(R.id.text);
        textView.setText("Name: Lyla the Katrepillar"+"\n"+"Quantity: "+quan+"\n"+"Total: "+5*quan+"\nThank you!");
    }
}
