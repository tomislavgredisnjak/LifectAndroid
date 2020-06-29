package com.example.lifeect.ui.trainings.presenter;

import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.trainings.model.TrainingsInteractor;
import com.example.lifeect.ui.trainings.model.TrainingsInteractorImpl;
import com.example.lifeect.ui.trainings.view.TrainingsView;

import java.util.ArrayList;
import java.util.List;

public class TrainingsPresenterImpl implements TrainingsPresenter, TrainingsInteractor.OnFinishedListener {

    private TrainingsView trainingsView;
    private TrainingsInteractor trainingsInteractor;

    public TrainingsPresenterImpl(TrainingsView trainingsView){
        this.trainingsView = trainingsView;
        this.trainingsInteractor = new TrainingsInteractorImpl();
    }

    @Override
    public void checkTrainings() {
        trainingsInteractor.prikaziTreninge(this);
    }

    @Override
    public void onFinished(List<Training> trainings) {
        trainingsView.showTrainings(trainings);
    }
}
