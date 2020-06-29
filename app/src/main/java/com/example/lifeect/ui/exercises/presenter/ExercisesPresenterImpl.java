package com.example.lifeect.ui.exercises.presenter;

import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.exercises.model.ExercisesInteractor;
import com.example.lifeect.ui.exercises.model.ExercisesInteractorImpl;
import com.example.lifeect.ui.exercises.view.ExercisesView;
import com.example.lifeect.ui.trainings.model.TrainingsInteractor;
import com.example.lifeect.ui.trainings.model.TrainingsInteractorImpl;
import com.example.lifeect.ui.trainings.presenter.TrainingsPresenter;
import com.example.lifeect.ui.trainings.view.TrainingsView;

import java.util.List;

public class ExercisesPresenterImpl implements ExercisesPresenter, ExercisesInteractor.OnFinishedListener {

    private ExercisesView exercisesView;
    private ExercisesInteractor exercisesInteractor;

    public ExercisesPresenterImpl(ExercisesView exercisesView) {
        this.exercisesView = exercisesView;
        this.exercisesInteractor = new ExercisesInteractorImpl();
    }

    @Override
    public void checkExercises() {
        exercisesInteractor.prikaziVjezbe(this);
    }

    @Override
    public void onFinished(List<Exercise> exercises) {
        exercisesView.showExercises(exercises);
    }
}