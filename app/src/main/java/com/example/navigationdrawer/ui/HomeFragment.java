package com.example.navigationdrawer.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.navigationdrawer.MyAdapter;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment
{
    ViewPager viewPager;
    MyAdapter myAdapter;
    CircleIndicator circleIndicator;

    Timer timer;
    Handler handler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {


        View view=inflater.inflate(R.layout.fragment_home,container,false);


        viewPager=view.findViewById(R.id.viewpager);
        circleIndicator=view.findViewById(R.id.circleind);
        List<Integer> imageList=new ArrayList<>();
        imageList.add(R.drawable.sandwich1);
        imageList.add(R.drawable.sweet2);
        imageList.add(R.drawable.sweet3);
        imageList.add(R.drawable.sweet11);
        myAdapter=new MyAdapter(imageList);

        viewPager.setAdapter(myAdapter);
        circleIndicator.setViewPager(viewPager);

        handler=new Handler();
        timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {

                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        int i=viewPager.getCurrentItem();

                        if (i==imageList.size()-1)
                        {
                            i=0;
                            viewPager.setCurrentItem(i,true);
                        }
                        else {
                            i++;
                            viewPager.setCurrentItem(i, true);
                        }

                    }
                });

            }
        },4000,4000);



        return view;
    }

}