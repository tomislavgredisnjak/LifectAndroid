package com.example.lifeect.ui.trainings.model;

import com.example.lifeect.entity.Training;

import java.util.List;

public interface TrainingsInteractor {

    interface OnFinishedListener {
        void onFinished(List<Training> trainings);
    }

    void prikaziTreninge(OnFinishedListener listener);

}
