package com.example.recordshopfrontend.ui.mainactivity;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.recordshopfrontend.model.AlbumModel;
import com.example.recordshopfrontend.model.AlbumRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    // We use AndroidViewModel for when we need to access Android-specific components. It exposes state to the UI and encapsulates related business logic. Its advantage is that it caches state and persists it through configuration changes. This means that your UI doesn’t have to fetch data again when navigating between activities, or following configuration changes, such as when rotating the screen. This is a sub-class of ViewModel that is aware of Android application context.
    // We're using it here so we can pass an instance of Application to the repository.
    AlbumRepository albumRepository;
    public MainActivityViewModel(@NotNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }
    //  implement a method that returns the data from a method call to the
    //  albumRepository method to getMutableLiveData()
    public MutableLiveData<List<AlbumModel>> invokeGetMutableLiveDataMethod() {
        return albumRepository.getMutableLiveData();
    }

}
