package jbazin.gberhault.gardenmate;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class PlantsActivity extends AppCompatActivity implements PlantListFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PlantListFragment plantListFragment = new PlantListFragment();
        fragmentTransaction.add(R.id.mainAcitivityFrameLayoutContainer, plantListFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onItemSelected() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PlantDescriptionFragment plantDescriptionFragment = new PlantDescriptionFragment();
        fragmentTransaction.replace(R.id.mainAcitivityFrameLayoutContainer, plantDescriptionFragment);
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
