package com.example.lifeect.ui.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.lifeect.R;
import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.ui.home.presenter.HomePresenter;
import com.example.lifeect.ui.home.presenter.HomePresenterImpl;
import com.example.lifeect.ui.trainings.presenter.TrainingsPresenter;
import com.example.lifeect.ui.trainings.presenter.TrainingsPresenterImpl;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment implements HomeView {


    @BindView(R.id.muscle1)
    SimpleDraweeView muscle1;
    @BindView(R.id.muscle2)
    SimpleDraweeView muscle2;
    @BindView(R.id.muscle3)
    SimpleDraweeView muscle3;
    @BindView(R.id.muscle4)
    SimpleDraweeView muscle4;
    private HomePresenter presenter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Fresco.initialize(getContext());
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,root);
        presenter = new HomePresenterImpl(this);
        presenter.checkMuscles();

        return root;
        }

    @Override
    public void showMuscle(List<MuscleGroup> muscle) {
        muscle1.setImageURI(muscle.get(0).getImageMuscleGroup());
        muscle2.setImageURI(muscle.get(1).getImageMuscleGroup());
        muscle3.setImageURI(muscle.get(2).getImageMuscleGroup());
        muscle4.setImageURI(muscle.get(3).getImageMuscleGroup());
    }

}

