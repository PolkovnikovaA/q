package com.example.final5;

public class Modal {
    private String Dog;
    private String Info;

    public Modal(String dog, String info){
        Dog = dog;
        Info = info;
    }

    public void setDog(String dog) {
        Dog = dog;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getDog() {
        return Dog;
    }

    public String getInfo() {
        return Info;
    }
}
