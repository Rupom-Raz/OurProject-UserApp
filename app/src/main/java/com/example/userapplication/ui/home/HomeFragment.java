package com.example.userapplication.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.userapplication.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {


    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        setSliderViews();
        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        return view;
    }

    private void openMap() {
        try {
            Uri uri = Uri.parse("geo:0, 0?q=Leading University");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setSliderViews() {
        for (int i = 0; i < 5; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/school-management-app-2.appspot.com/o/slider%2Fasset%2011.jpeg?alt=media&token=fc9539b8-0ca8-4174-87c8-551d36288b5a");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/school-management-app-2.appspot.com/o/slider%2Fasset%2012.jpeg?alt=media&token=360e5679-49b6-4743-940e-8e1a46070c94");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/school-management-app-2.appspot.com/o/slider%2Fasset%2013.jpeg?alt=media&token=814c1070-c211-4407-83cd-b5be650ecbef");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/school-management-app-2.appspot.com/o/slider%2Fasset%204.jpeg?alt=media&token=9105e6bd-8462-48ac-834d-02e8f04e2a7e");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/school-management-app-2.appspot.com/o/slider%2Fasset%205.jpeg?alt=media&token=f2646640-5baa-4f31-a319-530cc29e8533");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}