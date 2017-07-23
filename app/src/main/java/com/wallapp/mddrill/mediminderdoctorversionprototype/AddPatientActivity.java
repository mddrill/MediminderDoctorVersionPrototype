package com.wallapp.mddrill.mediminderdoctorversionprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddPatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        Button addPatientButton = (Button) findViewById(R.id.add_patient_button);
        addPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText patientNameField = (EditText) findViewById(R.id.add_patient_name_field);
                EditText patientPhoneField = (EditText) findViewById(R.id.add_patient_phone_field);
                EditText patientAddressField = (EditText) findViewById(R.id.add_patient_address_field);
                String name = patientNameField.toString();
                String phone = patientPhoneField.toString();
                String address = patientAddressField.toString();
                Intent data = new Intent();
                data.putExtra("PATIENT", new Patient(name, phone, address));
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
