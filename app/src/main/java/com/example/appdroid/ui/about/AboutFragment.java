package com.example.appdroid.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appdroid.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager, viewPager2;
    private branchAdapter adapter;
    private List<BranchModel> list,list2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about, container, false);

        list= new ArrayList<>();
        list.add(new BranchModel(R.drawable.party,"ECLECIA","\n DESCRIPTION\n" +
                "Eclecia, the cultural extravangza is organised by the Student's Council of Heritage Institute of Technology, Kolkata. It is student-elected body having representatives from current batches of the institute.\n \n EVENTS \n" +
                "Fashion Show Paint Ball Band Performances Drama Short Film Competition Quiz And Debates T-Shirt/Tattoo/Face Painting Dj Night Mohit Chauhan's Performance On 6th April 2015",R.drawable.eclecia ));
        list.add(new BranchModel(R.drawable.cognitio2,"DAKSHH","“ DESCRIPTION\n" +
                "We, at Heritage Institute of Technology, Kolkata are proud to present you our annual Tech Fest, DAKSHH '15! To reach the zenith of technical prowess is what we, at our college, strive for and Dakshh is an embodiment of that ambition. With a multitude of events ranging from robotics to coding to gaming, Dakshh has always provided an exhilarating atmosphere to every single participant.\n EVENTS\n" +
                "A :: Robotics : [Sample Arena available in brochure and on net] 1. Manual Robotics(Xlration) 2. Robowars 3. Robo Soccers 4. InstaRobo(Making of Robo)(and much more ....)",R.drawable.dakshh));
        list.add(new BranchModel(R.drawable.sports,"Sports","Keeping this in mind the college pays a lot of emphasis on the all round development of the students. There is an athletic ground, a cricket ground in the campus. Apart from this, each of the hostels are provided with equipments of various sports like Table Tennis, Lawn tennis, cricket, football, badminton, carom, chess, etc. The students actively participate in these sports and there is a college team for cricket, football, basketball, badminton, volleyball, table tennis as well as athletics. They represent the college in various sports events held countrywide and make the college proud by bringing back scores of medals and trophies. The college also organizes various sports events \n",R.drawable.hitsports));
        adapter= new branchAdapter(getContext(),list);
        viewPager= view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        //ImageView imageView= view.findViewById(R.id.cllg_img);

        //Glide.with(getContext())
                //.load("")
                //.into(imageView);

        list2= new ArrayList<>();
        list2.add(new BranchModel(R.drawable.club,"Resonance","Category- Music", R.drawable.reso));
        list2.add(new BranchModel(R.drawable.club,"Ghungroo","Category- Dance", R.drawable.ghungroo));
        list2.add(new BranchModel(R.drawable.club,"Anubhav","Category- Drama", R.drawable.anubh));
        list2.add(new BranchModel(R.drawable.club,"Pravasana","Category- Photography, film and painting", R.drawable.pravs));
        list2.add(new BranchModel(R.drawable.club,"Rotract","Category- Social and community outreach", R.drawable.rot));
        list2.add(new BranchModel(R.drawable.club,"NSS","Category- Social and community outreach", R.drawable.nss));
        list2.add(new BranchModel(R.drawable.club,"DSC","Category- Google Developer Society", R.drawable.dsc));
        list2.add(new BranchModel(R.drawable.club,"Robotics club","Category- Robotics", R.drawable.robo));
        adapter= new branchAdapter(getContext(),list2);
        viewPager= view.findViewById(R.id.viewPager2);
        viewPager.setAdapter(adapter);

        return view;

    }
}