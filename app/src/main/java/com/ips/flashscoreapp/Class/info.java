package com.ips.flashscoreapp.Class;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.chip.Chip;
import com.ips.flashscoreapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class info extends Fragment {

    Chip mChip1,mChip2,mChip3,mChip4;

    public info() {
        // Required empty public constructor
    }

    void sendToEmail(String emailAddr){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        //send email to the share screen
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{emailAddr});
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {

        }
    }
        //create event listener for each chip
    Chip.OnClickListener mChipClickListener = new Chip.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch(id){
                case R.id.idChip1:
                    sendToEmail("180100237@esg.ipsantarem.pt");
                    break;
                case R.id.idChip2:
                    sendToEmail("180100361@esg.ipsantarem.pt");
                    break;
                case R.id.idChip3:
                    sendToEmail("180100265@esg.ipsantarem.pt");
                    break;
                case R.id.idChip4:
                    sendToEmail("180100353@esg.ipsantarem.pt");
                    break;

            }//switch
        }//onClick
    };//mChipClickListener


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        //create each chip and link a click listener to each one
        mChip1=getView().findViewById(R.id.idChip1);
        mChip2=getView().findViewById(R.id.idChip2);
        mChip3=getView().findViewById(R.id.idChip3);
        mChip4=getView().findViewById(R.id.idChip4);

        mChip1.setOnClickListener(mChipClickListener);
        mChip2.setOnClickListener(mChipClickListener);
        mChip3.setOnClickListener(mChipClickListener);
        mChip4.setOnClickListener(mChipClickListener);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }
}