package com.example.userapplication.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.userapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel>list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_cse,"Computer Science & Engineering","To attain a  B.Sc. in Computer Science & Engineering, a student must complete a minimum of 143 credits of course work which typically takes 4 years The courses of  the CSE undergraduate degree is designed keeping two things in mind. First, knowledge of Computer Science. "));
        list.add(new BranchModel(R.drawable.ic_eee,"Electrical & Electronic Engineering","The Department of Electrical and Electronic Engineering started its journey in 2009 with the primary goal of producing the best quality engineers and professionals in the relevant fields, who are capable of working at the frontier of cutting-edge technology, research, creation of new ideas, and design and development of new products."));
        list.add(new BranchModel(R.drawable.ic_bba,"Business Administration","The Department of Business Administration is one of the founding and the largest Department of the University. It has about 2000 (Two thousand) students and 64 highly qualified extremely dedicated vastly experienced faculty members. Among them, 34 full time and 30 Adjunct faculty."));
        list.add(new BranchModel(R.drawable.ic_eng,"Department of English","Department of English of Leading University started from the Fall semester 2004. Among all private universities in Sylhet, Department of English of LU is the pioneer in establishing both the graduate and post graduate programs."));

        adapter = new BranchAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        ImageView imageView = view.findViewById(R.id.lu_image);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/school-management-app-2.appspot.com/o/slider%2Fasset%204.jpeg?alt=media&token=9105e6bd-8462-48ac-834d-02e8f04e2a7e")
                .into(imageView);


        return  view;
    }
}