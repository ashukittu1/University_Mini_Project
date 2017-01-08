package com.ashutech.university_mini_project;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    EditText et1, et2, et3, et4, et5, et6;
    Button b1,b2;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        et1 = (EditText) v.findViewById(R.id.editText1);
        et2 = (EditText) v.findViewById(R.id.editText2);
        et3 = (EditText) v.findViewById(R.id.editText3);
        et4 = (EditText) v.findViewById(R.id.editText4);
        et5 = (EditText) v.findViewById(R.id.editText5);
        et6 = (EditText) v.findViewById(R.id.editText6);
        b1 = (Button) v.findViewById(R.id.button1);
        b2 = (Button) v.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("credentials", 0);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("no",et1.getText().toString());
                ed.putString("uname",et2.getText().toString());
                ed.putString("mail",et3.getText().toString());
                ed.putString("pw",et4.getText().toString());
                ed.putString("cpw",et5.getText().toString());
                ed.putString("pwhint",et6.getText().toString());
                ed.commit();//save into preference file
                Toast.makeText(getActivity(), "Successfully data saved", Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFragment2 loginFragment2 = new LoginFragment2();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container1,loginFragment2);
                fragmentTransaction.commit();
            }
        });

        return v;
    }

}
