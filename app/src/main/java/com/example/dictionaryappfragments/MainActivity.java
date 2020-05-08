package com.example.dictionaryappfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
        implements WordsFragment.OnListItemClickedListener{
    private ListView wordsLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelected(int pos) {
        FragmentManager fM = getSupportFragmentManager();
        MeaningFragment meaningF = (MeaningFragment)fM.findFragmentById(R.id.fragment2);
        meaningF.setMeaning(pos);
    }
}
