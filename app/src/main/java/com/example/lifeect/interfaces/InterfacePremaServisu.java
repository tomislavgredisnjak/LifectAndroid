package com.example.lifeect.interfaces;

import com.example.lifeect.entity.Exercise;
import com.example.lifeect.entity.MuscleGroup;
import com.example.lifeect.entity.Training;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfacePremaServisu {

    @GET("Exercises")
    Call<List<Exercise>> dohvatiExercises();

    @GET("Exercises/{id}")
    Call<Exercise> dohvatiExercise(@Path("id") int exerciseId);

    @GET("Trainings")
    Call<List<Training>> dohvatiTrainings();

    @GET("Trainings/{id}")
    Call<Training> dohvatiTraining(@Path("id") int trainingId);

    @GET("MuscleGroups")
    Call<List<MuscleGroup>> dohvatiMuscleGroups();

    @GET("MuscleGroups/{id}")
    Call<MuscleGroup> dohvatiMuscleGroup(@Path("id") int muscleGroupId);


}
