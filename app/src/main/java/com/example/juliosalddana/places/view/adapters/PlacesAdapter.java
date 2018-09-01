package com.example.juliosalddana.places.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.model.datamodels.Place;

import java.util.ArrayList;
import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder>{

    List<Place> placeList = new ArrayList<>();
    /**
     * Crea el ViewHolder para este adapter
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View view = layoutInflater.inflate(R.layout.item_place, parent, false);
       return new PlaceViewHolder(view);
    }

    /**
     * Asigna valores a las propiedades del ViewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {

        Place place =  placeList.get(position);
        holder.imPlace.setImageResource(place.getImageId());
        holder.tvPlaceTitle.setText(place.getName());
        holder.tvPlaceDesription.setText(place.getDescription());
    }


    /**
     * Retorna el total de elementos en este adapter
     * @return
     */
    @Override
    public int getItemCount() {
        return placeList.size();
    }


    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    /**
     * ViewHolder, es el objecto que contiene las propiedades de un elemento de la lista
     */
    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView imPlace;
        TextView tvPlaceTitle;
        TextView tvPlaceDesription;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            imPlace = itemView.findViewById(R.id.im_place_item);
            tvPlaceTitle = itemView.findViewById(R.id.tv_place_item_title);
            tvPlaceDesription = itemView.findViewById(R.id.tv_place_item_description);
        }
    }
}
