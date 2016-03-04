package com.cs160.joleary.catnip;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kstukalova on 3/3/16.
 */
public class ExampleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView partyView = (TextView) view.findViewById(R.id.party);
        nameView.setText(getArguments().getString("name"));
        partyView.setText(getArguments().getString("party"));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent watchIntent = new Intent(v.getContext(), WatchToPhoneService.class);
                watchIntent.putExtra("name", getArguments().getString("name"));
                v.getContext().startService(watchIntent);;
            }
        });
    }
}

