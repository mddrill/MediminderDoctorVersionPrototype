package com.wallapp.mddrill.mediminderdoctorversionprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by mddrill on 7/23/17.
 */

public class InstructionDetailActivity extends AppCompatActivity {

    Instruction instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        instruction = (Instruction) getIntent().getSerializableExtra("PATIENT");

        TextView instructionDescriptionTextView = (TextView) findViewById(R.id.description);
        TextView instructionDetailTextView = (TextView) findViewById(R.id.details);
        TextView timeTextView = (TextView) findViewById(R.id.time);
        TextView patientTextView = (TextView) findViewById(R.id.patient);

        instructionDescriptionTextView.setText(instruction.getDescription());
        instructionDetailTextView.setText(instruction.getDetails());
        timeTextView.setText(instruction.getTime());
        patientTextView.setText(instruction.getPatient());
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
}
