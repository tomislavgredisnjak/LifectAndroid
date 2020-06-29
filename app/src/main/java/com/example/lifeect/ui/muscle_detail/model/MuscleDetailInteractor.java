package com.example.lifeect.ui.muscle_detail.model;

import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.MuscleGroup;

public interface MuscleDetailInteractor {

    interface OnFinishedListener {
        void onFinished(MuscleGroup muscleGroup);
    }

    void prikaziMisicnuGrupu(MuscleDetailInteractor.OnFinishedListener listener, Integer idMuscleGroup);
}
