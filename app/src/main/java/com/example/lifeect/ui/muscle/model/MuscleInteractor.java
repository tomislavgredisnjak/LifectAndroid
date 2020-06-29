package com.example.lifeect.ui.muscle.model;

import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.trainings.model.TrainingsInteractor;

import java.util.List;

public interface MuscleInteractor {

    interface OnFinishedListener {
        void onFinished(List<MuscleGroup> muscleGroups);
    }

    void prikaziMuscleGroups(MuscleInteractor.OnFinishedListener listener);

}
