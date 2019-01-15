package com.example.rickb.week2day1;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    private String year;
    private String make;
    private String model;
    private String color;
    private String engine;
    private String transmission;
    private String title;

    public Car(){

    }
    protected Car(Parcel in) {
        year= in.readString();
        make = in.readString();
        model = in.readString();
        color = in.readString();
        engine = in.readString();
        transmission = in.readString();
        title = in.readString();
    }
    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(year);
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(color);
        dest.writeString(engine);
        dest.writeString(transmission);
        dest.writeString(title);
    }
}
