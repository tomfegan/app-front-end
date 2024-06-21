package com.example.recordshopfrontend.ui.mainactivity;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recordshopfrontend.R;
import com.example.recordshopfrontend.databinding.ActivityMainBinding;
import com.example.recordshopfrontend.model.AlbumModel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<AlbumModel> albums;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);
        getAllAlbums();
    }

    private void getAllAlbums() {
        viewModel
                .invokeGetMutableLiveDataMethod()
                .observe(this, albumsFromLiveData -> {
                    // albums refers to the variable name of your List of Album objects
                    // albumsFromLiveData is cast to this type
                    albums = (ArrayList<AlbumModel>) albumsFromLiveData;

                    // This method will be created next
                    displayInRecyclerView();

                    Log.d("My message", albumsFromLiveData.get(0).getAlbumName());

                });
    }

    private void displayInRecyclerView() {
        // Assign the RecyclerView variable to binding.recyclerView
        recyclerView = activityMainBinding.recyclerView;

        // Assign the AlbumAdapter variable to a new AlbumAdapter(), passing in the List of Albums to be displayed
        albumAdapter = new AlbumAdapter(albums, this);

        // Set the recyclerView adapter to the created albumAdapter
        recyclerView.setAdapter(albumAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Create a new LinearLayoutManager and set this as the recyclerView layout manager
        recyclerView.setLayoutManager(layoutManager);

        // Set the recyclerView's setHasFixedSize() method to true
        recyclerView.setHasFixedSize(true);
//        recyclerView.hasFixedSize();

        // Finally, call the album adapter's notifyDataSetChanged() method
        albumAdapter.notifyDataSetChanged();

    }

}
