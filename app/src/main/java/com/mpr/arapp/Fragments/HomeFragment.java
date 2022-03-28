package com.mpr.arapp.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.mpr.arapp.R;

import java.util.function.Consumer;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private ArFragment arFragment;
    private static final String GLTF_ASSET =
            "https://github.com/KhronosGroup/glTF-Sample-Models/raw/master/2.0/Duck/glTF/Duck.gltf";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // arFragment = (ArFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.arFragment);
     //   arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {});
        /*arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor(); // used to describe the orientation in the real world
                // our 3d model will be displayed on this anchor
                *//*ModelRenderable.builder()
                        .setSource(getContext(),)*//*
            }
        });*/

        ModelRenderable.builder()
                .setSource(getContext(), RenderableSource.builder().setSource(
                        getContext(),
                        Uri.parse(GLTF_ASSET),
                        RenderableSource.SourceType.GLTF2)
                        .setScale(0.5f)  // Scale the original model to 50%.
                        .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                        .build())
                .setRegistryId(GLTF_ASSET)
                .build()
                .thenAccept(new Consumer<ModelRenderable>() {
                    @Override
                    public void accept(ModelRenderable modelRenderable) {

                    }
                })
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(getContext(), "Unable to load renderable " +
                                            GLTF_ASSET, Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        });

        /*blueSphereRenderable = redSphereRenderable.makeCopy();
        blueSphereRenderable.getMaterial().setFloat3(
                MaterialFactory.MATERIAL_COLOR, new Color(android.graphics.Color.BLUE));*/

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}