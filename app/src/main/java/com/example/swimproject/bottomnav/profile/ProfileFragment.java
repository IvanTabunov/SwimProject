package com.example.swimproject.bottomnav.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.swimproject.StartActivity;
import com.example.swimproject.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        binding.buttonAnthropometry.setOnClickListener(v -> startActivityFromClass(AnthropometryActivity.class));
        binding.buttonRanksTitles.setOnClickListener(v -> startActivityFromClass(RanksAndTitlesActivity.class));
        binding.buttonRecords.setOnClickListener(v -> startActivityFromClass(RecordsActivity.class));
        binding.buttonExit.setOnClickListener(v -> startActivityFromClass(StartActivity.class));

        return binding.getRoot();
    }

    private void startActivityFromClass(Class<?> activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }
}
