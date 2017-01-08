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


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment2 extends Fragment {

    EditText et1, et2, et3;
    Button b1,b2;

    public LoginFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login_fragment2, container, false);
        et1 = (EditText) v.findViewById(R.id.editText1);
        et2 = (EditText) v.findViewById(R.id.editText2);
        et3 = (EditText) v.findViewById(R.id.editText3);
        b1 = (Button) v.findViewById(R.id.button1);
        b2 = (Button) v.findViewById(R.id.button2);
        SharedPreferences sp = getActivity().getSharedPreferences("credentials", 0);
        final String val1 = sp.getString("uname", null);
        final String val2 = sp.getString("pw", null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if((val1.equals(et1.getText().toString())) || (val2.equals(et2.getText().toString()))){
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadSecondFrag();  // loading fragment two into activtity
                }
            }
        });
        return v;
    }

}
