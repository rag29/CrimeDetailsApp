package com.example.rob.crimedetailsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CrimeDetailsFragment extends Fragment {

    TextView topLabel;
    TextView date;
    TextView location;
    TextView category;
    TextView outcome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.crime_details_fragment, container, false);

        topLabel = view.findViewById(R.id.topLabel);
        date = view.findViewById(R.id.date);
        location = view.findViewById(R.id.location);
        category = view.findViewById(R.id.category);
        outcome = view.findViewById(R.id.outcome);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        topLabel = getView().findViewById(R.id.topLabel);
//        date = getView().findViewById(R.id.date);
//        location = getView().findViewById(R.id.location);
//        category = getView().findViewById(R.id.category);
//        outcome = getView().findViewById(R.id.outcome);
    }
}
