////////////////////////////////////////////////////////////////////////////////
// Copyright (c) Guillaume Berhault and Jerome Bazin since 2017.
////////////////////////////////////////////////////////////////////////////////

package jbazin.gberhault.gardenmate;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlantListFragment extends ListFragment {

    private final String[] PLANTS = new DataImpl().getPlantList(PlantType.all);

    private SelectionListener callBack;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layout = android.R.layout.simple_list_item_activated_1;

        // Set the list adapter for this ListFragment
        setListAdapter(new ArrayAdapter<>(getActivity(), layout, PLANTS));

        // Retain this fragment across configuration changes.
        setRetainInstance(true);

    }

    // FOR API > 23
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callBack = (SelectionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement SelectionListener");
        }
    }

    // FOR API < 23
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callBack = (SelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SelectionListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // When using two-pane layout, configure the ListView to highlight the
        // selected list item

        if (isInTwoPaneMode()) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        callBack.onListItemClick(position);
    }

    // If there is a FeedFragment, then the layout is two-pane
    private boolean isInTwoPaneMode() {

        return getFragmentManager().findFragmentById(R.id.fragment2) != null;

    }

    public interface SelectionListener {
        void onListItemClick(int position);
    }

}
