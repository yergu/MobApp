package com.example.androidapp_development.assignment4;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.androidapp_development.assignment4.ui.main.ProfileModel;
import com.example.androidapp_development.assignment4.ui.main.SectionsPagerAdapter;
import com.example.androidapp_development.assignment5.MatchesFragment;
import com.example.androidapp_development.databinding.ActivityAssignment4Binding;
import com.google.android.material.tabs.TabLayout;

public class signup4Activity extends AppCompatActivity {

    private ActivityAssignment4Binding binding;
    ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String occupation = getIntent().getStringExtra("occupation");
        String age = getIntent().getStringExtra("age");
        Bundle bundle =getIntent().getExtras();
        int resid = bundle.getInt("picId");
        ProfileModel profileModel = new ProfileModel(name, description,age,occupation);
        binding = ActivityAssignment4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), getFragments(profileModel));
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
    }

    private Fragment[] getFragments(ProfileModel profileModel){
        return new Fragment[]{
                Profile4Fragment.newInstance(profileModel),
                MatchesFragment.newInstance(),
                Settings4Fragment.newInstance()
        };
    }
}