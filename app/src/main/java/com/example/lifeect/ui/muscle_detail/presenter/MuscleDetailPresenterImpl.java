package com.example.lifeect.ui.muscle_detail.presenter;

import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.ui.exercises_detail.model.ExerciseDetailInteractor;
import com.example.lifeect.ui.exercises_detail.model.ExerciseDetailInteractorImpl;
import com.example.lifeect.ui.exercises_detail.presenter.ExerciseDetailPresenter;
import com.example.lifeect.ui.exercises_detail.view.ExerciseDetailView;
import com.example.lifeect.ui.muscle_detail.model.MuscleDetailInteractor;
import com.example.lifeect.ui.muscle_detail.model.MuscleDetailInteractorImpl;
import com.example.lifeect.ui.muscle_detail.view.MuscleDetailView;

public class MuscleDetailPresenterImpl implements MuscleDetailPresenter,  MuscleDetailInteractor.OnFinishedListener{

    private MuscleDetailView muscleDetailView;
    private MuscleDetailInteractor muscleDetailInteractor;

    public MuscleDetailPresenterImpl(MuscleDetailView muscleDetailView){
        this.muscleDetailView = muscleDetailView;
        this.muscleDetailInteractor = new MuscleDetailInteractorImpl();
    }


    @Override
    public void getMuscleGroupData(Integer idMuscleGroup) {
        muscleDetailInteractor.prikaziMisicnuGrupu(this,idMuscleGroup);
    }

    @Override
    public void onFinished(MuscleGroup muscleGroup) {
        muscleDetailView.getMuscleGroup(muscleGroup);
    }
}
