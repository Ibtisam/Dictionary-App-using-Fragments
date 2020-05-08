package com.example.dictionaryappfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeaningFragment extends Fragment {
    public MeaningFragment() {
        // Required empty public constructor
    }

    public void setMeaning(int pos){
        String[] meanings = getResources().getStringArray(R.array.meanings);
        String[] words = getResources().getStringArray(R.array.words);
        TextView meaningTV = getActivity().findViewById(R.id.meaning_tv);
        meaningTV.setMovementMethod(new ScrollingMovementMethod());
        meaningTV.setText("The meaning of the word: "+words[pos]+" is\n"+meanings[pos]);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meaning, container, false);
    }
}
