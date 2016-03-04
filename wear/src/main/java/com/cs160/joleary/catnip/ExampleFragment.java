package com.cs160.joleary.catnip;

import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kstukalova on 3/3/16.
 */
public class ExampleFragment extends CardFragment{
        @Override
        public View onCreateContentView(LayoutInflater inflater, ViewGroup container,
                                        Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_mine, container, false);
        }
    }

