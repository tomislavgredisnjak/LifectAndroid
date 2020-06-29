package com.example.lifeect.ui.muscle_detail.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.lifeect.R;
import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.ui.muscle_detail.presenter.MuscleDetailPresenter;
import com.example.lifeect.ui.muscle_detail.presenter.MuscleDetailPresenterImpl;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MuscleDetailActivity extends Activity implements MuscleDetailView {

    private MuscleDetailPresenter presenter;
    private Integer idMuscleGroup;

    @BindView(R.id.muscleImage)
    SimpleDraweeView muscleImage;
    @BindView(R.id.muscleName)
    TextView muscleName;
    @BindView(R.id.muscleAbout)
    TextView muscleAbout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_muscle_detail);
        ButterKnife.bind(this);
        presenter = new MuscleDetailPresenterImpl(this);

        idMuscleGroup = getIntent().getIntExtra("muscle",-1);

        presenter.getMuscleGroupData(idMuscleGroup);
    }

    @Override
    public void getMuscleGroup(MuscleGroup muscleGroup) {
        muscleImage.setImageURI(muscleGroup.getImageMuscleGroup());
        muscleName.setText(muscleGroup.getName().toUpperCase());
        muscleAbout.setText(muscleGroup.getAbout());
    }
}
