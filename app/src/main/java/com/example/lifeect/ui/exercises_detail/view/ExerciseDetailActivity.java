package com.example.lifeect.ui.exercises_detail.view;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.lifeect.R;
import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.ui.exercises_detail.presenter.ExerciseDetailPresenter;
import com.example.lifeect.ui.exercises_detail.presenter.ExerciseDetailPresenterImpl;
import com.example.lifeect.ui.trainings_detail.presenter.TrainingDetailPresenter;
import com.example.lifeect.ui.trainings_detail.presenter.TrainingDetailPresenterImpl;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExerciseDetailActivity extends Activity implements ExerciseDetailView {

    @BindView(R.id.exerciseImage)
    SimpleDraweeView exerciseImage;
    @BindView(R.id.exerciseName)
    TextView exerciseName;
    @BindView(R.id.exerciseMuscleId)
    TextView exerciseMuscleId;
    @BindView(R.id.exerciseReps)
    TextView exerciseReps;
    @BindView(R.id.exerciseSets)
    TextView exerciseSets;

    private ExerciseDetailPresenter presenter;
    private Integer idTraining;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_exercise_detail);
        ButterKnife.bind(this);
        presenter = new ExerciseDetailPresenterImpl(this);

        idTraining = getIntent().getIntExtra("exercise",-1);

        presenter.getExerciseData(idTraining);
    }

    @Override
    public void getExercise(Exercise exercise) {
        exerciseName.setText(exercise.getName().toUpperCase());
        exerciseReps.setText("Broj ponavljanja: " + exercise.getReps().toString());
        exerciseSets.setText("Broj serija: " + exercise.getSets().toString());
        Uri uri = Uri.parse(exercise.getImageExercise());
        exerciseImage.setImageURI(uri);
        presenter.getMuscleGroupData(exercise.getMuscleId());
    }

    @Override
    public void getMuscleGroup(MuscleGroup muscleGroup) {
        exerciseMuscleId.setText("Mišična skupina: " + muscleGroup.getName());
    }

}
