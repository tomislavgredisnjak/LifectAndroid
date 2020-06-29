package com.example.lifeect.ui.home.model;

import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.trainings.model.TrainingsInteractor;

import java.util.List;

public interface HomeInteractor {
    interface OnFinishedListener {
        void onFinished(List<MuscleGroup> muscles);
    }

    void prikaziMisice(HomeInteractor.OnFinishedListener listener);
}
