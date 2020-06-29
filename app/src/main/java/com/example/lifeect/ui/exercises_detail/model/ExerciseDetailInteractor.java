package com.example.lifeect.ui.exercises_detail.model;

import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.ui.exercises_detail.presenter.ExerciseDetailPresenterImpl;
import com.example.lifeect.ui.trainings_detail.model.TrainingDetailInteractor;

import java.util.List;

public interface ExerciseDetailInteractor {
    void prikaziMisicnuGrupu(OnFinishedListenerMuscle listener, Integer idMuscleGroup);

    interface OnFinishedListener {
        void onFinished(Exercise exercise);
    }
    interface OnFinishedListenerMuscle {
        void onFinished(MuscleGroup muscleGroup);
    }

    void prikaziVjezbu(OnFinishedListener listener, Integer idExercise);
}
