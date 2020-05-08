package com.example.dictionaryappfragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordsFragment extends Fragment {
    private OnListItemClickedListener listener;
    private ListView wordsLV;
    public WordsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnListItemClickedListener) context;
        }catch(ClassCastException exp){
            throw new ClassCastException(context.toString() + " must implement OnListItemClickListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_words, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wordsLV = getActivity().findViewById(R.id.WordsListView);
        ArrayAdapter<String> listArrAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_item,getResources().getStringArray(R.array.words));
        wordsLV.setAdapter(listArrAdapter);
        wordsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(position);
            }
        });
    }

    // Container Activity must implement this interface
    public interface OnListItemClickedListener {
        public void onItemSelected(int pos);
    }

}
