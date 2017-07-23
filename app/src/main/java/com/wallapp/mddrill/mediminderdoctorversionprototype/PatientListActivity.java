package com.wallapp.mddrill.mediminderdoctorversionprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class PatientListActivity extends AppCompatActivity {

    static final int ADD_PATIENT_RESULT = 1;
    PatientListAdapter patientListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Joe Plummer", "4568901111", "123 Walnut Street"));
        patients.add(new Patient("Jane Doe", "4562224378", "123 Chestnut Street"));
        patients.add(new Patient("Joe Plummer", "4567770101", "123 Spering Ave"));

        ListView patientListView = (ListView) findViewById(R.id.patient_listview);
        patientListAdapter = new PatientListAdapter(patients, this);
        patientListView.setAdapter(patientListAdapter);
        patientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(PatientListActivity.this, PatientDetailActivity.class);
                intent.putExtra("PATIENT", patientListAdapter.getItem(position));
                startActivity(intent);
            }
        });

        Button addPatientButton = (Button) findViewById(R.id.add_patient_button);
        addPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(PatientListActivity.this, AddPatientActivity.class), ADD_PATIENT_RESULT);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case ADD_PATIENT_RESULT:
                    Patient patient = (Patient) data.getParcelableExtra("PATIENT");
                    patientListAdapter.add(patient);
                    patientListAdapter.notifyDataSetChanged();
            }
        }
    }
}
