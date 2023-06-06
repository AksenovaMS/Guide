package com.example.lab6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;

public class Sightseeing implements Parcelable {

    private String name;
    private String description;
    private String time;
    private Point coordinates;

    public Sightseeing(String name, String description, String time, Point coordinates) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.coordinates = coordinates;
    }

    public Sightseeing(String name, String description, Point coordinates) {
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public Point getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return name;
    }

    protected Sightseeing(Parcel in) {
        name = in.readString();
        description = in.readString();
        time = in.readString();
        coordinates = new Point(in.readDouble(), in.readDouble());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(time);
        dest.writeDouble(coordinates.getLatitude());
        dest.writeDouble(coordinates.getLongitude());
    }
    public static final Creator<Sightseeing> CREATOR = new Creator<Sightseeing>() {
        @Override
        public Sightseeing createFromParcel(Parcel source) {
            return new Sightseeing(source);
        }

        @Override
        public Sightseeing[] newArray(int size) {
            return new Sightseeing[size];
        }
    };
}
