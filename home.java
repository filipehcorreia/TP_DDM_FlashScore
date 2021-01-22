package com.ips.flashscoreapp.Class;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ips.flashscoreapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {


    public home() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    //set event listener to each card
    CardView.OnClickListener mCardClickListener = new CardView.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch(id){
                case R.id.idFirstCard:
                    Intent ft = new Intent(getActivity(), foot.class);
                    startActivity(ft);

                    break;
                case R.id.idSecondCard:
                    Intent bt = new Intent(getActivity(), basket.class);
                    startActivity(bt);
                    break;


            }//switch
        }//onClick
    };//mCardClickListener


    //after associate the xml elements to java objects
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView mCardFirst = getView().findViewById(R.id.idFirstCard);
        CardView mCardSecond = getView().findViewById(R.id.idSecondCard);

        //associate the event listener to each card
        mCardFirst.setOnClickListener(mCardClickListener);
        mCardSecond.setOnClickListener(mCardClickListener);

    }
}