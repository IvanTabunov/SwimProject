package com.example.swimproject.bottomnav.workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import com.example.swimproject.databinding.FragmentsWorkoutBinding;

public class WorkoutFragment extends Fragment {
    private FragmentsWorkoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentsWorkoutBinding.inflate(inflater, container,false);



        return binding.getRoot();
    }
}
