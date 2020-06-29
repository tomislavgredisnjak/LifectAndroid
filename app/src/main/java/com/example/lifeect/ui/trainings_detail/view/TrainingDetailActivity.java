package com.example.lifeect.ui.trainings_detail.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.lifeect.R;
import com.example.lifeect.entity.Exercise;
import com.example.lifeect.ui.exercises_detail.view.ExerciseDetailActivity;
import com.example.lifeect.ui.trainings_detail.presenter.TrainingDetailPresenter;
import com.example.lifeect.ui.trainings_detail.presenter.TrainingDetailPresenterImpl;

import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class TrainingDetailActivity extends Activity implements TrainingDetailView{
    private TrainingDetailPresenter presenter;
    @BindView(R.id.lista_vjezbi)
    ListView vjezbe;
    private Integer idTraining;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_detail);
        ButterKnife.bind(this);
        presenter = new TrainingDetailPresenterImpl(this);
        idTraining = getIntent().getIntExtra("training",-1);

        presenter.checkExercises(idTraining);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showExercises(List<Exercise> exercises) {

        ArrayAdapter<String> trainingViewAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                exercises.stream().map(Exercise::getName).collect(Collectors.toList())
        );
        vjezbe.setAdapter(trainingViewAdapter);
    }

    @OnItemClick(R.id.lista_vjezbi)
    public void trainingClick(int position){

        Integer idExercise = (position+1)+((idTraining-1)*5);

        Intent detailIntent = new Intent(getApplicationContext(), ExerciseDetailActivity.class);
        detailIntent.putExtra("exercise", idExercise);
        startActivity(detailIntent);
    }
}
