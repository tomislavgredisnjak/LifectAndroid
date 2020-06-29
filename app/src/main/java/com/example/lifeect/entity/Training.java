package com.example.lifeect.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Training {

    @SerializedName("Id_Training")
    Integer id_training;
    @SerializedName("Name")
    String name;
    @SerializedName("Duration")
    Integer duration;
    @SerializedName("ImageTraining")
    String imageTraining;

    List<Exercise> exercises;

    public Training(Integer id_training, String name, Integer duration, String imageTraining) {
        this.id_training = id_training;
        this.name = name;
        this.duration = duration;
        this.imageTraining = imageTraining;
    }

    public Integer getId_training() {
        return id_training;
    }

    public void setId_training(Integer id_training) {
        this.id_training = id_training;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getImageTraining() {
        return imageTraining;
    }

    public void setImageTraining(String imageTraining) {
        this.imageTraining = imageTraining;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString(){

        return name;
    }
}

