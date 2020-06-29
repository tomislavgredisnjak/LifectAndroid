package com.example.lifeect.ui.muscle.view;

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
import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.ui.exercises_detail.view.ExerciseDetailActivity;
import com.example.lifeect.ui.muscle.presenter.MusclePresenter;
import com.example.lifeect.ui.muscle.presenter.MusclePresenterImpl;
import com.example.lifeect.ui.muscle_detail.view.MuscleDetailActivity;

import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MuscleFragment extends Fragment implements MuscleView {

    @BindView(R.id.misici)
    ListView misici;
    private MusclePresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_muscle, container, false);

        ButterKnife.bind(this, root);
        presenter = new MusclePresenterImpl(this);
        presenter.checkMuscleGroups();
        return root;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showMuscleGroups(List<MuscleGroup> muscleGroups) {
        ArrayAdapter<String> muscleGroupViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                muscleGroups.stream().map(MuscleGroup::getName).collect(Collectors.toList())
        );

        misici.setAdapter(muscleGroupViewAdapter);
    }
    @OnItemClick(R.id.misici)
    public void muscleClick(int position){
        Intent detailIntent = new Intent(getContext(), MuscleDetailActivity.class);
        detailIntent.putExtra("muscle", position+1);
        startActivity(detailIntent);
    }

}
