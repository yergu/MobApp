package com.example.androidapp_development.assignment4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.androidapp_development.R;
import com.example.androidapp_development.assignment4.ui.main.ProfileModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile4Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile4Fragment extends Fragment {
    String name, description, age, occupation;
    Bundle args;

    public Profile4Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Profile.
     */
    public static Profile4Fragment newInstance(ProfileModel profileModel) {
        Profile4Fragment fragment = new Profile4Fragment();
        Bundle args = new Bundle();
        args.putString("name", profileModel.getName());
        args.putString("description", profileModel.getDescription());
        args.putString("age", profileModel.getAge());
        args.putString("occupation", profileModel.getOccupation());
        args.putString("occupation", profileModel.getOccupation());
        args.putInt("picId", R.drawable.cat);


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
        name = args.getString("name", "No name");
        description = args.getString("description", "No description");
        age = args.getString("age", "not provided");
        occupation = args.getString("occupation", "Not provided");
       // int resid = args.getInt("picId");

       //

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile_new, container, false);
        TextView nameView = view.findViewById(R.id.profile_name);
        TextView descriptionView = view.findViewById(R.id.profile_description);
        TextView ageView = view.findViewById(R.id.profile_age);
        TextView occupationView = view.findViewById(R.id.profile_occupation);
        ImageView profileImageView = view.findViewById(R.id.profile_image);
        Button backBtn = view.findViewById(R.id.profile_backBtn);
       // profileImageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), R.mipmap.profile_image_round));
        nameView.setText(name);
        descriptionView.setText(description);
        occupationView.setText(occupation);
        ageView.setText(age+" years");
        profileImageView.setImageResource(args.getInt("picId"));


        backBtn.setOnClickListener(view1->{
            getActivity().finish();
        });
        return view;
    }
}