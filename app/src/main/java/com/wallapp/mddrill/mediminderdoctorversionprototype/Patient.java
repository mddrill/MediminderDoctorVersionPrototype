package com.wallapp.mddrill.mediminderdoctorversionprototype;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mddrill on 7/22/17.
 */

public class Patient implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public static final Parcelable.Creator<Patient> CREATOR = new Parcelable.Creator<Patient>() {
        public Patient createFromParcel(Parcel in) {
            return new Patient();
        }

        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };
}
