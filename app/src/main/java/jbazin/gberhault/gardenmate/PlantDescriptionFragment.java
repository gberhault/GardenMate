////////////////////////////////////////////////////////////////////////////////
// Copyright (c) Guillaume Berhault and Jerome Bazin since 2017.
////////////////////////////////////////////////////////////////////////////////

package jbazin.gberhault.gardenmate;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PlantDescriptionFragment extends Fragment {

    private final String[] plantDescriptionFragmentData = {"pepper description goes here",
            "tomato description goes here"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.plant_description, container, false);
    }


    void updatePlantDescriptionDisplay(int position) {
        TextView textView = (TextView) getView().findViewById(R.id.plant_description);
        try {
            textView.setText(plantDescriptionFragmentData[position]);
        } catch (NullPointerException e) {
            Log.e("INTERNAL", "Text view from plant description fragment should not be null.");
            e.printStackTrace();
        }
    }
}
