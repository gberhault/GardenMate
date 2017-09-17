////////////////////////////////////////////////////////////////////////////////
// Copyright (c) Guillaume Berhault and Jerome Bazin since 2017.
////////////////////////////////////////////////////////////////////////////////

package jbazin.gberhault.gardenmate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PlantsActivity extends AppCompatActivity implements PlantListFragment.SelectionListener {

    private PlantListFragment plantListFragment;
    private PlantDescriptionFragment plantDescriptionFragment;
    private boolean onTwoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);

        // If small screen is detected, load plant list fragment
        if (!isOnTwoPanes()) {
            plantListFragment = new PlantListFragment();

            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.activity_plants_fragment_container, plantListFragment);

            fragmentTransaction.commit();
        } else {
            plantDescriptionFragment = (PlantDescriptionFragment)
                    getFragmentManager().findFragmentById(R.id.fragment2);
        }

    }

    private boolean isOnTwoPanes() {
        return (findViewById(R.id.activity_plants_large) != null);
    }

    @Override
    public void onListItemClick(int position) {

        if (plantDescriptionFragment == null)
            plantDescriptionFragment = new PlantDescriptionFragment();

        if (!isOnTwoPanes()) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.activity_plants_fragment_container, plantDescriptionFragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

            fragmentManager.executePendingTransactions();
        }

        plantDescriptionFragment.updatePlantDescriptionDisplay(position);

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
