package com.example.lifeect.ui.home.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.entity.Training;

import java.util.List;

public interface HomeView {

    void showMuscle(List<MuscleGroup> muscle);
}