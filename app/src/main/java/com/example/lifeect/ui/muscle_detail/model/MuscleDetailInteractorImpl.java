package com.example.lifeect.ui.muscle_detail.model;

import android.os.Handler;

import com.example.lifeect.interfaces.InterfacePremaServisu;
import com.example.lifeect.ServiceGenerator;
import com.example.lifeect.entity.MuscleGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MuscleDetailInteractorImpl implements MuscleDetailInteractor {

    private static final String API_URL = "http://10.0.2.2:8080/api/";
    private MuscleGroup muscleGroup;
    @Override
    public void prikaziMisicnuGrupu(final MuscleDetailInteractor.OnFinishedListener listener, Integer idMuscleGroup) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {

                InterfacePremaServisu client =
                        ServiceGenerator.createService(InterfacePremaServisu.class, API_URL);


                Call<MuscleGroup> call = client.dohvatiMuscleGroup(idMuscleGroup);

                call.enqueue(new Callback<MuscleGroup>() {

                    @Override
                    public void onResponse(Call<MuscleGroup> call, Response<MuscleGroup> response) {

                        if (response.isSuccessful()) {
                            muscleGroup = response.body();
                            listener.onFinished(muscleGroup);
                        }
                    }

                    @Override
                    public void onFailure(Call<MuscleGroup> call, Throwable t) {
                        System.out.println("Error: " + t.getMessage());
                    }
                });
            }
        });
    }
}
