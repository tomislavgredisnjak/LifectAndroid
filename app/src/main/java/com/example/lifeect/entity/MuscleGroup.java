package com.example.lifeect.entity;

import com.google.gson.annotations.SerializedName;

public class MuscleGroup {

    @SerializedName("Id_MuscleGroup")
    Integer id_muscleGroup;
    @SerializedName("Name")
    String name;
    @SerializedName("ImageMuscleGroup")
    String imageMuscleGroup;
    @SerializedName("About")
    String about;

    public MuscleGroup(Integer id_muscleGroup, String name, String imageMuscleGroup, String about) {
        this.id_muscleGroup = id_muscleGroup;
        this.name = name;
        this.imageMuscleGroup = imageMuscleGroup;
        this.about = about;
    }



    public Integer getId_muscleGroup() {
        return id_muscleGroup;
    }

    public void setId_muscleGroup(Integer id_muscleGroup) {
        this.id_muscleGroup = id_muscleGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageMuscleGroup() {
        return imageMuscleGroup;
    }

    public void setImageMuscleGroup(String imageMuscleGroup) {
        this.imageMuscleGroup = imageMuscleGroup;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return name;
    }
}
