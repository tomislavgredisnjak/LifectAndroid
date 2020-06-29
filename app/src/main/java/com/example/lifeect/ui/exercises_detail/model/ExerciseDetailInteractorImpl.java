package com.example.lifeect.ui.exercises_detail.model;

import android.os.Handler;

import com.example.lifeect.interfaces.InterfacePremaServisu;
import com.example.lifeect.ServiceGenerator;
import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.MuscleGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExerciseDetailInteractorImpl implements ExerciseDetailInteractor {

    private static final String API_URL = "http://10.0.2.2:8080/api/";
    private Exercise exercise;
    private MuscleGroup muscleGroup;
    @Override
    public void prikaziMisicnuGrupu(final OnFinishedListenerMuscle listener, Integer idMuscleGroup) {
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


    @Override
    public void prikaziVjezbu(final ExerciseDetailInteractor.OnFinishedListener listener, Integer idTraining) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {

                InterfacePremaServisu client =
                        ServiceGenerator.createService(InterfacePremaServisu.class, API_URL);


                Call<Exercise> call = client.dohvatiExercise(idTraining);

                call.enqueue(new Callback<Exercise>() {

                    @Override
                    public void onResponse(Call<Exercise> call, Response<Exercise> response) {

                        if (response.isSuccessful()) {
                            exercise = response.body();


                            listener.onFinished(exercise);
                        }
                    }

                    @Override
                    public void onFailure(Call<Exercise> call, Throwable t) {
                        System.out.println("Error: " + t.getMessage());
                    }
                });
            }
        });
    }
}
