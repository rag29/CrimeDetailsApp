package com.example.rob.crimedetailsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        setCrimeDetailsFragmentData();

        return view;
    }

    public void setCrimeDetailsFragmentData(){
        CrimeDetailsFragment.this.topLabel.setText(topLabel.getText() + " " + getArguments().getString("label"));
        CrimeDetailsFragment.this.date.setText(date.getText() + " " + getArguments().getString("date"));
        CrimeDetailsFragment.this.location.setText(location.getText() + "\n Street Name: " +getArguments().getString("streetName") + "\n Location ID: " + getArguments().getString("locationId") + "\n Longitude: " + getArguments().getString("longitude") + "\n Latitude: " + getArguments().getString("latitude"));
        CrimeDetailsFragment.this.category.setText(category.getText() + " " + getArguments().getString("category"));
        CrimeDetailsFragment.this.outcome.setText(outcome.getText() + " " + getArguments().getString("outcome") + "\n Date of Resolution: " + getArguments().getString("dateOfOutcome"));
    }
}
