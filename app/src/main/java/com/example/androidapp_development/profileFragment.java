package com.example.androidapp_development;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class profileFragment extends Fragment {

    private TextView firstName, emailAdd, occup, desc;

    public profileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile1, container, false);

        firstName = rootView.findViewById(R.id.fname);
        emailAdd = rootView.findViewById(R.id.email);
        occup = rootView.findViewById(R.id.occ);
        desc = rootView.findViewById(R.id.desc);


        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("name")) {
                String fName = bundle.getString("name");
                firstName.setText(fName);
            }
        }
        return rootView;
        //  firstName.setText(fName);

      /*  firstName = rootView.findViewById(R.id.fname);
        emailAdd = rootView.findViewById(R.id.email);
        occup = rootView.findViewById(R.id.occ);
        desc = rootView.findViewById(R.id.desc);

        Bundle bundle =getArguments();

        //UNPACK OUR DATA FROM OUR BUNDLE
        assert this.getArguments() != null;
        String fName = bundle.getString("name");
       // String LName= bundle.getString("Lname");
        String myDescription = bundle.getString("Desc");
        String myOcccupation = bundle.getString("Occ");
        String myEmail = bundle.getString("Email");

//set data
        firstName.setText(fName);
        emailAdd.setText( myEmail);
        desc.setText( myDescription);
        occup.setText(myOcccupation);



        return rootView;*/

    }
}