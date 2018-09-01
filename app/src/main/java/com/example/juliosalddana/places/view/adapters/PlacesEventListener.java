package com.example.juliosalddana.places.view.adapters;

/**
 * Interface que define los eventos que se pueden escuchar de un lugar dentro de la lista
 */
public interface PlacesEventListener {

    /**
     * Este funciòn se llamará cuando se haga tap sobre un item de la lista
     * @param placePosition
     */
    public void onSelectPlace(int placePosition);
}
