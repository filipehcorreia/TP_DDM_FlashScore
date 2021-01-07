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
 * Use the {@link info#newInstance} factory method to
 * create an instance of this fragment.
 */
public class info extends Fragment {

    Chip mChip1,mChip2,mChip3,mChip4;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public info() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment info.
     */
    // TODO: Rename and change types and number of parameters
    public static info newInstance(String param1, String param2) {
        info fragment = new info();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    void sendToEmail(String emailAddr){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{emailAddr});
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {

        }
    }

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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mChip1=getView().findViewById(R.id.idChip1);
        mChip2=getView().findViewById(R.id.idChip2);
        mChip3=getView().findViewById(R.id.idChip3);
        mChip4=getView().findViewById(R.id.idChip4);

        mChip1.setOnClickListener(mChipClickListener);
        mChip2.setOnClickListener(mChipClickListener);
        mChip3.setOnClickListener(mChipClickListener);
        mChip4.setOnClickListener(mChipClickListener);
//TODO Talvez meter aqui um array
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_info, container, false);
    }
}