package com.example.lifeect.ui.exercises_detail.presenter;

import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.ui.exercises_detail.model.ExerciseDetailInteractor;
import com.example.lifeect.ui.exercises_detail.model.ExerciseDetailInteractorImpl;
import com.example.lifeect.ui.exercises_detail.view.ExerciseDetailView;
import com.example.lifeect.ui.trainings_detail.model.TrainingDetailInteractor;
import com.example.lifeect.ui.trainings_detail.model.TrainingDetailInteractorImpl;
import com.example.lifeect.ui.trainings_detail.view.TrainingDetailView;

public class ExerciseDetailPresenterImpl implements ExerciseDetailPresenter,  ExerciseDetailInteractor.OnFinishedListener, ExerciseDetailInteractor.OnFinishedListenerMuscle{

    private ExerciseDetailView exerciseDetailView;
    private ExerciseDetailInteractor exerciseDetailInteractor;

    public ExerciseDetailPresenterImpl(ExerciseDetailView exerciseDetailView){
        this.exerciseDetailView = exerciseDetailView;
        this.exerciseDetailInteractor = new ExerciseDetailInteractorImpl();
    }

    @Override
    public void getExerciseData(Integer idTraining) {
        exerciseDetailInteractor.prikaziVjezbu(this,idTraining);
    }

    @Override
    public void getMuscleGroupData(Integer idMuscleGroup) {
        exerciseDetailInteractor.prikaziMisicnuGrupu(this,idMuscleGroup);
    }

    @Override
    public void onFinished(Exercise exercise) {
        exerciseDetailView.getExercise(exercise);
    }

    @Override
    public void onFinished(MuscleGroup muscleGroup) {
        exerciseDetailView.getMuscleGroup(muscleGroup);
    }
}
