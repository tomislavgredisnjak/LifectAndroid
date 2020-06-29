package com.example.lifeect.ui.trainings_detail.model;

import android.os.Handler;

import com.example.lifeect.interfaces.InterfacePremaServisu;
import com.example.lifeect.ServiceGenerator;
import com.example.lifeect.entity.Exercise;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingDetailInteractorImpl implements TrainingDetailInteractor {

    private List<Exercise> exercises = new ArrayList<>();
    private List<Exercise> exercisesTraining = new ArrayList<>();

    private static final String API_URL = "http://10.0.2.2:8080/api/";

    @Override
    public void prikaziVjezbe(final TrainingDetailInteractor.OnFinishedListener listener, Integer idTraining) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {

                InterfacePremaServisu client =
                        ServiceGenerator.createService(InterfacePremaServisu.class, API_URL);


                Call<List<Exercise>> call = client.dohvatiExercises();

                call.enqueue(new Callback<List<Exercise>>() {

                    @Override
                    public void onResponse(Call<List<Exercise>> call, Response<List<Exercise>> response) {

                        if (response.isSuccessful()) {
                            exercises = response.body();
                            for(Exercise exercise : exercises){
                                if(exercise.getId_exercise() <= idTraining*5){
                                    exercisesTraining.add(exercise);
                                }
                            }

                            listener.onFinished(exercisesTraining.subList(exercisesTraining.size()-5, exercisesTraining.size()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Exercise>> call, Throwable t) {
                        System.out.println("Error: " + t.getMessage());
                    }
                });
            }
        });
    }
}