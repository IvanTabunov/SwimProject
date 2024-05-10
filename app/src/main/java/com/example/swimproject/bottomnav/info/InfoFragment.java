package com.example.swimproject.bottomnav.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.swimproject.StartActivity;
import com.example.swimproject.bottomnav.profile.AnthropometryActivity;
import com.example.swimproject.bottomnav.profile.RanksAndTitlesActivity;
import com.example.swimproject.bottomnav.profile.RecordsActivity;
import com.example.swimproject.databinding.FragmentInfoBinding;

public class InfoFragment extends Fragment {
    private FragmentInfoBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentInfoBinding.inflate(inflater, container,false);

        binding.buttonTechnique.setOnClickListener(v -> startActivityFromClass(TechniqueActivity.class));
        binding.buttonExercises.setOnClickListener(v -> startActivityFromClass(ExercisesActivity.class));
        binding.buttonAboutPreparation.setOnClickListener(v -> startActivityFromClass(PreparationActivity.class));
        binding.buttonRules.setOnClickListener(v -> startActivityFromClass(RulesActivity.class));

        return binding.getRoot();
    }

    private void startActivityFromClass(Class<?> activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }
}
