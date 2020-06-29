package com.example.lifeect.ui.home.model;

import android.os.Handler;

import com.example.lifeect.ServiceGenerator;
import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.entity.Training;
import com.example.lifeect.interfaces.InterfacePremaServisu;
import com.example.lifeect.ui.trainings.model.TrainingsInteractor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractorImpl implements HomeInteractor {

    private List<MuscleGroup> muscles = new ArrayList<>();

    private static final String API_URL = "http://10.0.2.2:8080/api/";

    @Override
    public void prikaziMisice(final OnFinishedListener listener) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {

                InterfacePremaServisu client =
                        ServiceGenerator.createService(InterfacePremaServisu.class, API_URL);

                Call<List<MuscleGroup>> call = client.dohvatiMuscleGroups();

                call.enqueue(new Callback<List<MuscleGroup>>() {

                    @Override
                    public void onResponse(Call<List<MuscleGroup>> call, Response<List<MuscleGroup>> response) {

                        if (response.isSuccessful()) {
                            muscles = response.body();
                            listener.onFinished(muscles);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<MuscleGroup>> call, Throwable t) {
                        System.out.println("Error: " + t.getMessage());
                    }
                });
            }
        });
    }
}