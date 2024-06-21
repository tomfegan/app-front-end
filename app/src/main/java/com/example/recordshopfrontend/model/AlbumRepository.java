package com.example.recordshopfrontend.model;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.example.recordshopfrontend.service.AlbumApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

import static com.example.recordshopfrontend.service.RetrofitInstance.getService;

public class AlbumRepository {
    private MutableLiveData<List<AlbumModel>> subscriber = new MutableLiveData<>();
    private Application application;
    public AlbumRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<AlbumModel>> getMutableLiveData() {
        AlbumApiService albumApiService = getService();
        Call<List<AlbumModel>> call = albumApiService.getAllAlbums();
        call.enqueue(new Callback<List<AlbumModel>>(){
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                List<AlbumModel> albumModelList = response.body();
                subscriber.setValue(albumModelList);
//                Log.d("My message", albumModelList.get(0).getAlbumName());
            }
            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable throwable) {
              // no implementation
            }
        });
        return subscriber;
    }

}
