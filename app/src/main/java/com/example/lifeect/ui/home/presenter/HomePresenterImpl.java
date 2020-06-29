package com.example.lifeect.ui.home.presenter;

import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.home.model.HomeInteractor;
import com.example.lifeect.ui.home.model.HomeInteractorImpl;
import com.example.lifeect.ui.home.view.HomeView;
import com.example.lifeect.ui.trainings.model.TrainingsInteractor;
import com.example.lifeect.ui.trainings.model.TrainingsInteractorImpl;
import com.example.lifeect.ui.trainings.presenter.TrainingsPresenter;
import com.example.lifeect.ui.trainings.view.TrainingsView;

import java.util.List;

public class HomePresenterImpl implements HomePresenter, HomeInteractor.OnFinishedListener {

    private HomeView homeView;
    private HomeInteractor homeInteractor;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        this.homeInteractor = new HomeInteractorImpl();
    }

    @Override
    public void checkMuscles() {
        homeInteractor.prikaziMisice(this);
    }

    @Override
    public void onFinished(List<MuscleGroup> muscles) {
        homeView.showMuscle(muscles);
    }



}