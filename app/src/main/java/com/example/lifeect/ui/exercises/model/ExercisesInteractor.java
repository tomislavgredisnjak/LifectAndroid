package com.example.lifeect.ui.exercises.model;

import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.trainings.model.TrainingsInteractor;

import java.util.List;

public interface ExercisesInteractor {
    interface OnFinishedListener {
        void onFinished(List<Exercise> exercises);
    }

    void prikaziVjezbe(ExercisesInteractor.OnFinishedListener listener);

}
