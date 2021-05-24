package com.example.androidapp_development;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class profileFragment extends Fragment {

    private TextView firstName , emailAdd, occup, desc;
    public profileFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        firstName = (TextView) rootView.findViewById(R.id.fname);

        emailAdd = (TextView) rootView.findViewById(R.id.email);
        occup = (TextView) rootView.findViewById(R.id.occ);
        desc = (TextView) rootView.findViewById(R.id.desc);




        //UNPACK OUR DATA FROM OUR BUNDLE
        assert this.getArguments() != null;
        String FirstName = this.getArguments().getString("Name");
        String myDescription = this.getArguments().getString("Description");
        String myOcccupation = this.getArguments().getString("Occcupation");
        String myEmail = this.getArguments().getString("Email");


        firstName.setText("NAME : " + FirstName);
        emailAdd.setText("Email : " + myEmail);
        desc.setText("Description : " + myDescription);
        occup.setText("Occupation : " + myOcccupation);




        return rootView;
    }
}
