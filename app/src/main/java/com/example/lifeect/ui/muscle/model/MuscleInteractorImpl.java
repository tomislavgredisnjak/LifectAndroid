package com.example.lifeect.ui.muscle.model;

import android.os.Handler;

import com.example.lifeect.interfaces.InterfacePremaServisu;
import com.example.lifeect.ServiceGenerator;
import com.example.lifeect.entity.MuscleGroup;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MuscleInteractorImpl implements MuscleInteractor{

        private List<MuscleGroup> muscleGroups = new ArrayList<>();


        private static final String API_URL = "http://10.0.2.2:8080/api/";

        @Override
        public void prikaziMuscleGroups(final MuscleInteractor.OnFinishedListener listener) {
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
                                muscleGroups = response.body();
                                listener.onFinished(muscleGroups);
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
