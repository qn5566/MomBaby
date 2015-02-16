package com.mababy.main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.mababy.main.fragment.animator.IO2014HeaderAnimator;
import com.mababy.main.R;
import com.mababy.main.fragment.animator.StikkyHeaderBuilder;

public class Fragmenta extends Fragment {

	private ListView mListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListView = (ListView) getView().findViewById(R.id.listview);
    }

    @Override
    public void onStart() {
        super.onStart();

       // getActivity().getActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();

        getActivity().getActionBar().show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        IO2014HeaderAnimator animator = new IO2014HeaderAnimator(getActivity());

        StikkyHeaderBuilder.stickTo(mListView)
            .setHeader(R.id.header, (ViewGroup) getView())
            .minHeightHeaderRes(R.dimen.min_height_header_materiallike)
            .animator(animator)
            .build();

        populateListView();
    }

    private void populateListView() {

        String[] elements = new String[500];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = "row " + i;
        }

        mListView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, elements));
    }

}
