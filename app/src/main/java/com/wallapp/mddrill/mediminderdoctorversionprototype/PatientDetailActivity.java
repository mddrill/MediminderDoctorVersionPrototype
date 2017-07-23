package com.wallapp.mddrill.mediminderdoctorversionprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static com.wallapp.mddrill.mediminderdoctorversionprototype.PatientListActivity.ADD_PATIENT_RESULT;

/**
 * Created by mddrill on 7/22/17.
 */

public class PatientDetailActivity extends AppCompatActivity {
    static final int ADD_INSTRUCTION_RESULT = 2;
    InstructionListAdapter instructionListAdapter;
    Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);

        patient = (Patient) getIntent().getSerializableExtra("PATIENT");

        ListView instructionListView = (ListView) findViewById(R.id.instruction_listview);
        instructionListAdapter = new PatientListAdapter(patient.getInstructions(), this);
        instructionListView.setAdapter(instructionListAdapter);
        instructionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(PatientDetailActivity.this, InstructionDetailActivity.class);
                intent.putExtra("INSTRUCTION", instructionListAdapter.getItem(position));
                startActivity(intent);
            }
        });


        TextView name = (TextView) findViewById(R.id.patient_name_textview);
        TextView phone = (TextView) findViewById(R.id.patient_phone_textview);
        TextView address = (TextView) findViewById(R.id.patient_address_textview);
        name.setText(patient.getName());
        phone.setText(patient.getPhone());
        address.setText(patient.getAddress());

        Button addInstructionButton = (Button) findViewById(R.id.add_patient_button);
        addInstructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(PatientDetailActivity.this, InstructionDetailActivity.class), ADD_INSTRUCTION_RESULT);
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
                case ADD_INSTRUCTION_RESULT:
                    Instruction instruction = (Instruction) data.getSerializableExtra("PATIENT");
                    patient.getInstructions().add(instruction);
                    instructionListAdapter.add(instruction);
                    instructionListAdapter.notifyDataSetChanged();
            }
        }
    }
}
