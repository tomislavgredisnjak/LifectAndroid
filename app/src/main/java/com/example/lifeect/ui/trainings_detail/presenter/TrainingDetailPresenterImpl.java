package com.example.lifeect.ui.trainings_detail.presenter;

import com.example.lifeect.entity.Exercise;
import com.example.lifeect.ui.trainings_detail.model.TrainingDetailInteractor;
import com.example.lifeect.ui.trainings_detail.model.TrainingDetailInteractorImpl;
import com.example.lifeect.ui.trainings_detail.view.TrainingDetailView;

import java.util.ArrayList;
import java.util.List;

public class TrainingDetailPresenterImpl implements TrainingDetailPresenter, TrainingDetailInteractor.OnFinishedListener{
    private TrainingDetailView trainingDetailView;
    private TrainingDetailInteractor trainingDetailInteractor;

    public TrainingDetailPresenterImpl(TrainingDetailView trainingDetailView){
        this.trainingDetailView = trainingDetailView;
        this.trainingDetailInteractor = new TrainingDetailInteractorImpl();
    }

    @Override
    public void checkExercises(Integer idTraining) {
        trainingDetailInteractor.prikaziVjezbe(this,idTraining);
    }
    @Override
    public void onFinished(List<Exercise> exercises) {
        trainingDetailView.showExercises(exercises);
    }
}
