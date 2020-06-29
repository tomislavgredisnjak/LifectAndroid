package com.example.lifeect.ui.trainings_detail.model;

import com.example.lifeect.entity.Exercise;

import java.util.List;

public interface TrainingDetailInteractor {
    interface OnFinishedListener {
        void onFinished(List<Exercise> exercises);
    }

    void prikaziVjezbe(OnFinishedListener listener, Integer idTraining);
}
