package com.example.a653401.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Created by A653401 on 06-01-2017.
 * This class will be used as a Parcelable Object.
 */
@Data
public class MovieModel implements Parcelable {

    public MovieModel() {}

    private String poster_path;

    private boolean adult;

    private String overview;

    private String release_date;

    private ArrayList<Integer> genre_ids;

    private int id;

    private String original_title;

    private String title;

    private String original_language;

    private int page;

    public MovieModel(android.os.Parcel in)
    {
        readFromParcel(in);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(poster_path);
        parcel.writeString(overview);
        parcel.writeInt(adult ? 1 : 0);
        parcel.writeString(release_date);
        parcel.writeSerializable(genre_ids);
        parcel.writeInt(id);
        parcel.writeString(original_title);
        parcel.writeString(title);
        parcel.writeString(original_language);
        parcel.writeInt(page);
    }

    private void  readFromParcel(android.os.Parcel in)
    {
        poster_path = in.readString();
        overview = in.readString();
        adult = in.readInt()==0 ? true : false;
        release_date = in.readString();
        genre_ids = (ArrayList<Integer>) in.readSerializable();
        id = in.readInt();
        original_title = in.readString();
        title = in.readString();
        original_language = in.readString();
        page = in.readInt();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel parcel) {
            return new MovieModel(parcel);
        }

        @Override
        public MovieModel[] newArray(int i) {
            return new MovieModel[i];
        }
    };
}
