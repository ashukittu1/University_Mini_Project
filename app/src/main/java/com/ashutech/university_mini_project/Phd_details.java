package com.ashutech.university_mini_project;


import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Phd_details extends Fragment {


    EditText et1,et2,et3,et4,et5,et6;
    Button b1,b2,b3;
    MyDatabase myDatabase;

 //   MainActivity mainActivity;


   String no, name,mobile, email, subject, description, date;


    public Phd_details() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_phd_details, container, false);
        et1 = (EditText) v.findViewById(R.id.editText1);
        et2 = (EditText) v.findViewById(R.id.editText2);
        et3 = (EditText) v.findViewById(R.id.editText3);
        et4 = (EditText) v.findViewById(R.id.editText4);
        et5 = (EditText) v.findViewById(R.id.editText5);
        et6 = (EditText) v.findViewById(R.id.editText6);
     //   et7 = (EditText) v.findViewById(R.id.editText7);

        b1 = (Button) v.findViewById(R.id.button1);
        b2 = (Button) v.findViewById(R.id.button2);
        b3 = (Button) v.findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatePicker myDatePicker = new MyDatePicker();
                myDatePicker.show(getActivity().getFragmentManager(),null);



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String no = et1.getText().toString();
                String name = et2.getText().toString();
                String mobile = et3.getText().toString();
                String email = et4.getText().toString();
                String subject = et5.getText().toString();
                String description = et6.getText().toString();
         //       String date = et7.getText().toString();
                myDatabase.insertStudent(no, name, mobile, email, subject, description);
                et1.setText("");
                et1.requestFocus();
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
           //     et7.setText("");
                Toast.makeText(getActivity(), "Data is successfully inserted into database", Toast.LENGTH_SHORT).show();

            }

        });



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatePicker myDatePicker = new MyDatePicker();
                myDatePicker.show(getActivity().getFragmentManager(),null);

            MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadSecondFrag();


            }
        });
        return v;
    }
}

