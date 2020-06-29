package com.example.lifeect.ui.trainings.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.lifeect.R;
import com.example.lifeect.entity.Training;
import com.example.lifeect.ui.trainings_detail.view.TrainingDetailActivity;
import com.example.lifeect.ui.trainings.presenter.TrainingsPresenter;
import com.example.lifeect.ui.trainings.presenter.TrainingsPresenterImpl;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class TrainingsFragment extends Fragment implements TrainingsView{

    @BindView(R.id.treninzi)
    ListView treninzi;
    private TrainingsPresenter presenter;
    @Nullable
    @BindView(R.id.training1)
    SimpleDraweeView trainingImage1;
    @Nullable
    @BindView(R.id.training2)
    SimpleDraweeView trainingImage2;
    @Nullable
    @BindView(R.id.training3)
    SimpleDraweeView trainingImage3;
    @Nullable
    @BindView(R.id.training4)
    SimpleDraweeView trainingImage4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Fresco.initialize(getContext());
        View root = inflater.inflate(R.layout.fragment_trainings, container, false);

        ButterKnife.bind(this, root);
        presenter = new TrainingsPresenterImpl(this);
        presenter.checkTrainings();

        return root;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showTrainings(List<Training> trainings) {

            if(trainingImage1!=null && trainingImage2!=null && trainingImage3!=null && trainingImage4!=null){
                trainingImage1.setImageURI(trainings.get(0).getImageTraining());
                trainingImage2.setImageURI(trainings.get(1).getImageTraining());
                trainingImage3.setImageURI(trainings.get(2).getImageTraining());
                trainingImage4.setImageURI(trainings.get(3).getImageTraining());
            }

        ArrayAdapter<Training> trainingViewAdapter = new ArrayAdapter<Training>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                trainings
        );
        treninzi.setAdapter(trainingViewAdapter);

    }

    @OnItemClick(R.id.treninzi)
    public void trainingClick(int position){

        Intent detailIntent = new Intent(getActivity().getApplicationContext(), TrainingDetailActivity.class);
        detailIntent.putExtra("training", position+1);

        startActivity(detailIntent);
    }

}
