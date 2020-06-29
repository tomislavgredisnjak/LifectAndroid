package com.example.lifeect.ui.trainings.model;

import android.os.Handler;

import com.example.lifeect.interfaces.InterfacePremaServisu;
import com.example.lifeect.ServiceGenerator;
import com.example.lifeect.entity.Training;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingsInteractorImpl implements TrainingsInteractor {

    private List<Training> trainings = new ArrayList<>();

    private static final String API_URL = "http://10.0.2.2:8080/api/";

    @Override
    public void prikaziTreninge(final OnFinishedListener listener) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {

                InterfacePremaServisu client =
                        ServiceGenerator.createService(InterfacePremaServisu.class, API_URL);


                Call<List<Training>> call = client.dohvatiTrainings();

                call.enqueue(new Callback<List<Training>>() {

                    @Override
                    public void onResponse(Call<List<Training>> call, Response<List<Training>> response) {

                        if (response.isSuccessful()) {
                            trainings = response.body();
                            listener.onFinished(trainings);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Training>> call, Throwable t) {
                        System.out.println("Error: " + t.getMessage());
                    }
                });
            }
        });
    }
}
