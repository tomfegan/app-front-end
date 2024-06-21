package com.example.recordshopfrontend.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recordshopfrontend.databinding.ActivityAlbumBinding;
import com.example.recordshopfrontend.model.AlbumModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<AlbumModel> albumModelList;
    private Context context;

    public AlbumAdapter(List<AlbumModel> albumModelList, Context context) {
        this.albumModelList = albumModelList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return new AlbumViewHolder(ActivityAlbumBinding
                .inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_album, viewGroup, false);
//        return new AlbumViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull AlbumViewHolder albumViewHolder, int position) {
        AlbumModel album = albumModelList.get(position);
        albumViewHolder.activityAlbumBinding.setAlbum(album);
    }
    @Override
    public int getItemCount() {
        return albumModelList.size();
    }
    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        private ActivityAlbumBinding activityAlbumBinding;
        public AlbumViewHolder(ActivityAlbumBinding activityAlbumBinding) {
            super(activityAlbumBinding.getRoot());
            this.activityAlbumBinding = activityAlbumBinding;
        }
    }

}
