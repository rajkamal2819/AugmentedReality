package com.mpr.arapp.Fragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.mpr.arapp.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private ArFragment arFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        arFragment = (ArFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.arFragment);
     //   arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {});
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor(); // used to describe the orientation in the real world
                // our 3d model will be displayed on this anchor
                /*ModelRenderable.builder()
                        .setSource(getContext(),)*/
            }
        });

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}