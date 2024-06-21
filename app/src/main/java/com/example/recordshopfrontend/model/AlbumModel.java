package com.example.recordshopfrontend.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.recordshopfrontend.BR;
import com.google.gson.annotations.SerializedName;

public class AlbumModel extends BaseObservable {
    @SerializedName("artist") // This allows GSON to map the key names in the JSON string to the Java object and vice-versa while serialising and deserialising. The String argument the annotation is expecting has to exactly match the key name in the JSON string.
    private String artist;
    @SerializedName("albumName")
    private String albumName;
    @SerializedName("genre")
    private String genre;
    @SerializedName("releaseYear")
    private String releaseYear;
    @SerializedName("copiesInStock")
    private String copiesInStock;
    @SerializedName("id")
    private int id;
    public AlbumModel(String artist, String albumName, String genre,
                      String releaseYear, String copiesInStock, int id) {
        this.artist = artist;
        this.albumName = albumName;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.copiesInStock = copiesInStock;
        this.id = id;
    }
    public AlbumModel() {
    }
    @Bindable
    public String getArtist() {
        return artist;
    }
    @Bindable
    public String getAlbumName() {
        return albumName;
    }
    @Bindable
    public String getGenre() {
        return genre;
    }
    @Bindable
    public String getReleaseYear() {
        return releaseYear;
    }
    @Bindable
    public String getCopiesInStock() {
        return copiesInStock;
    }
    @Bindable
    public int getId() {
        return id;
    }


    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        notifyPropertyChanged(BR.albumName);
    }
    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }
    public void setCopiesInStock(String copiesInStock) {
        this.copiesInStock = copiesInStock;
        notifyPropertyChanged(BR.copiesInStock);
    }
    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
}
