package com.katerra.greendaosample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by divum on 25/12/17.
 */

public class StudentDetailsActivity extends AppCompatActivity {
   private EditText name;
   private EditText devision;
   private EditText standerd;
   private EditText address;
   private EditText contact;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_student);
        name = findViewById(R.id.etStudName);
        devision = findViewById(R.id.etStudDevision);
        standerd = findViewById(R.id.etStudStd);
        address = findViewById(R.id.etAddress);
        contact = findViewById(R.id.etStudContact);


    }
}
