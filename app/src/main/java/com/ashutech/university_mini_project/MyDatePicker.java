package com.ashutech.university_mini_project;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Ashutosh on 1/5/2017.
 */
public class MyDatePicker extends DialogFragment {

    public MyDatePicker() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d = null;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                // this method will be called when user clicks done button

                                Toast.makeText(getActivity(),
                                        "SELECTED DATE IS "+i+"-"+i1+"-"+i2+"", Toast.LENGTH_SHORT).show();
                                MainActivity mainActivity = (MainActivity) getActivity();
                                mainActivity.catchData(i+"/"+(i1+1)+"/"+i2);

                            }
                        }, year, month, date);
        d = datePickerDialog;
        return d;
    }
}
