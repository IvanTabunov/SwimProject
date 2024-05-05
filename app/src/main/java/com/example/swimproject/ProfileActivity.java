package com.example.swimproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.swimproject.bottomnav.info.InfoFragment;
import com.example.swimproject.bottomnav.profile.ProfileFragment;
import com.example.swimproject.bottomnav.workout.WorkoutFragment;
import com.example.swimproject.databinding.ActivityMainBinding;
import com.example.swimproject.databinding.ActivityProfileBinding;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(binding.NavigationContainer.getId(), new ProfileFragment()).commit();
        binding.mainButtonNavigation.setSelectedItemId(R.id.profile);

        Map<Integer, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.workout, new WorkoutFragment());
        fragmentMap.put(R.id.info, new InfoFragment());
        fragmentMap.put(R.id.profile, new ProfileFragment());

        binding.mainButtonNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = fragmentMap.get(item.getItemId());
            getSupportFragmentManager().beginTransaction().replace(binding.NavigationContainer.getId(), fragment).commit();
            return true;
        });
    }
}