package com.wallapp.mddrill.mediminderdoctorversionprototype;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mddrill on 7/22/17.
 */

public class Instruction implements Parcelable {
    public static final Parcelable.Creator<Instruction> CREATOR = new Parcelable.Creator<Instruction>() {
        public Instruction createFromParcel(Parcel in) {
            return new Instruction();
        }

        public Instruction[] newArray(int size) {
            return new Instruction[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
