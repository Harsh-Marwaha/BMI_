package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView res,bm;
        EditText wt,ft,in;
        Button cal,btnImg;
        ProgressBar pb;



        wt=findViewById(R.id.wt);
        ft=findViewById(R.id.ft);
        in=findViewById(R.id.in);
        cal=findViewById(R.id.cal);
        res=findViewById(R.id.res);
        bm=findViewById(R.id.bm);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(wt.getText().toString());
                int feet = Integer.parseInt(ft.getText().toString());
                int inches = Integer.parseInt(ft.getText().toString());

                int totalht= (feet*12) + inches;
                double totalcm = totalht*2.54;
                double totalm = totalcm/100;

                double bmi = weight/(totalm*totalm);

                String s = String.format("%.2f",bmi);

                if (bmi > 25)
                {
                    res.setText("Overweight");
                    bm.setText(s);
                }
                else if(bmi<18.5)
                {
                    res.setText("Underweight");
                    bm.setText(s);
                }
                else
                {
                    res.setText("Healthy");
                    bm.setText(s);
                }
            }
        });
    };

}