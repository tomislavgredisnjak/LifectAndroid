package com.example.lifeect.ui.exercises_detail.view;

import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.MuscleGroup;

public interface ExerciseDetailView {
    void getExercise(Exercise exercise);
    void getMuscleGroup(MuscleGroup muscleGroup);
}
