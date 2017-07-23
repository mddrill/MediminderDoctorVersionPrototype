package com.wallapp.mddrill.mediminderdoctorversionprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mddrill on 7/22/17.
 */

public class PatientListAdapter extends ArrayAdapter<Patient> {

    PatientListAdapter(ArrayList<Patient> patients, Context context) {
        super(context, 0, patients);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Patient patient = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.activity_patient_adapter, parent, false);
        TextView patientNameTextView = (TextView) convertView.findViewById(R.id.patient_adapter_name);

        patientNameTextView.setText(patient.getName());
        // Return the completed view to render on screen
        return convertView;
    }
}
