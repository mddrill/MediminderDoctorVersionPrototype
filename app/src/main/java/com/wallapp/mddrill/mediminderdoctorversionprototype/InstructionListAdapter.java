package com.wallapp.mddrill.mediminderdoctorversionprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by mddrill on 7/23/17.
 */

public class InstructionListAdapter extends ArrayAdapter<Instruction> {

    InstructionListAdapter(ArrayList<Instruction> instructions, Context context) {
        super(context, 0, instructions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Instruction instruction = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.activity_instruction_adapter, parent, false);

        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.time);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.patient);

        descriptionTextView.setText(instruction.getDescription());
        timeTextView.setText(instruction.getTime());
        // Return the completed view to render on screen
        return convertView;
    }
}
