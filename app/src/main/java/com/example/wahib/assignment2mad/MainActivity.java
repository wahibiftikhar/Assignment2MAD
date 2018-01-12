package com.example.wahib.assignment2mad;

import android.graphics.ColorSpace;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static class PlaceholderFragment extends Fragment {

        RecyclerViewAdapter adapter;
        RecyclerView recyclerView;
        private static List<ColorSpace.Model> demoData;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_main, container, false);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            recyclerView = (RecyclerView) getView().findViewById(R.id.myList);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(llm);

            demoData = new ArrayList<ColorSpace.Model>();
            char c = 'A';
            for (byte i = 0; i < 20; i++) {
                ColorSpace.Model model = new ColorSpace.Model();
                model.name = c++;
                model.age = (byte) (20 + i);
                demoData.add(model);
            }
            adapter = new RecyclerViewAdapter(demoData);
            recyclerView.setAdapter(adapter);
        }
    }
}
}