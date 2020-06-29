package com.example.lifeect.entity;

import com.google.gson.annotations.SerializedName;

public class Exercise {

    @SerializedName("Id_Exercise")
    Integer id_exercise;
    @SerializedName("Name")
    String name;
    @SerializedName("MusclesId")
    Integer muscleId;
    @SerializedName("Reps")
    Integer reps;
    @SerializedName("Sets")
    Integer sets;
    @SerializedName("ImageExercise")
    String imageExercise;


    public Exercise(Integer id_exercise, String name, Integer muscleId, Integer reps, Integer sets, String imageExercise) {
        this.id_exercise = id_exercise;
        this.name = name;
        this.muscleId = muscleId;
        this.reps = reps;
        this.sets = sets;
        this.imageExercise = imageExercise;
    }

    public Integer getId_exercise() {
        return id_exercise;
    }

    public void setId_exercise(Integer id_exercise) {
        this.id_exercise = id_exercise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(Integer muscleId) {
        this.muscleId = muscleId;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public String getImageExercise() {
        return imageExercise;
    }

    public void setImageExercise(String imageExercise) {
        this.imageExercise = imageExercise;
    }

    @Override
    public String toString(){
        return name;
    }
}
