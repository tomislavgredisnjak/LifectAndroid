package com.example.lifeect.ui.muscle.presenter;

import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.muscle.model.MuscleInteractor;
import com.example.lifeect.ui.muscle.model.MuscleInteractorImpl;
import com.example.lifeect.ui.muscle.view.MuscleView;
import com.example.lifeect.ui.trainings.model.TrainingsInteractor;
import com.example.lifeect.ui.trainings.model.TrainingsInteractorImpl;
import com.example.lifeect.ui.trainings.view.TrainingsView;

import java.util.ArrayList;
import java.util.List;

public class MusclePresenterImpl implements MusclePresenter, MuscleInteractor.OnFinishedListener{

    private MuscleView muscleView;
    private MuscleInteractor muscleInteractor;
    private List<MuscleGroup> muscleGroups = new ArrayList<>();

    public MusclePresenterImpl(MuscleView muscleView){
        this.muscleView = muscleView;
        this.muscleInteractor = new MuscleInteractorImpl();
    }

    @Override
    public void checkMuscleGroups() {
        muscleInteractor.prikaziMuscleGroups(this);
        muscleView.showMuscleGroups(muscleGroups);
    }

    @Override
    public void onFinished(List<MuscleGroup> muscleGroups) {
        muscleView.showMuscleGroups(muscleGroups);
    }

}
