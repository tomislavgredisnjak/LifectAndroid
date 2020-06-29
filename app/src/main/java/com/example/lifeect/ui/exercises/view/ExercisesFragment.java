package com.example.lifeect.ui.exercises.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.lifeect.R;
import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.exercises.presenter.ExercisesPresenter;
import com.example.lifeect.ui.exercises.presenter.ExercisesPresenterImpl;
import com.example.lifeect.ui.exercises_detail.view.ExerciseDetailActivity;
import com.example.lifeect.ui.muscle.presenter.MusclePresenterImpl;
import com.example.lifeect.ui.trainings.presenter.TrainingsPresenter;
import com.example.lifeect.ui.trainings.presenter.TrainingsPresenterImpl;
import com.example.lifeect.ui.trainings_detail.view.TrainingDetailActivity;

import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ExercisesFragment extends Fragment implements ExercisesView {

    @BindView(R.id.vjezbe)
    ListView vjezbe;
    private ExercisesPresenter presenter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exercises, container, false);

        ButterKnife.bind(this, root);

        presenter = new ExercisesPresenterImpl(this);
        presenter.checkExercises();

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showExercises(List<Exercise> exercises) {
        ArrayAdapter<Exercise> trainingViewAdapter = new ArrayAdapter<Exercise>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                exercises
        );
        vjezbe.setAdapter(trainingViewAdapter);
    }

    @OnItemClick(R.id.vjezbe)
    public void exerciseClick(int position){

        Intent detailIntent = new Intent(getContext(), ExerciseDetailActivity.class);
        detailIntent.putExtra("exercise", position+1);
        startActivity(detailIntent);
    }
}
