package com.example.final5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Mask implements Parcelable {
    private int ID;
    private String Dog;
    private String Info;

    protected Mask(Parcel in) {
        ID = in.readInt();
        Dog = in.readString();
        Info = in.readString();
    }

    public Mask(int id, String dog, String info){
        this.ID = id;
        Dog = dog;
        Info = info;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Dog);
        dest.writeString(Info);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Mask> CREATOR = new Creator<Mask>() {
        @Override
        public Mask createFromParcel(Parcel in) {
            return new Mask(in);
        }

        @Override
        public Mask[] newArray(int size) {
            return new Mask[size];
        }
    };

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDog(String dog) {
        Dog = dog;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getID() {
        return ID;
    }

    public String getDog() {
        return Dog;
    }

    public String getInfo() {
        return Info;
    }
}