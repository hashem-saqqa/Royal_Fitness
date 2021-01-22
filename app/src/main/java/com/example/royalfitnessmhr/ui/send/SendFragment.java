package com.example.royalfitnessmhr.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.royalfitnessmhr.R;
import com.example.royalfitnessmhr.kapten;
import com.example.royalfitnessmhr.kaptenadapter;
import com.example.royalfitnessmhr.ui.home.HomeFragment;
import com.example.royalfitnessmhr.ui.salary.SalaryFragment;

import java.util.ArrayList;

public class SendFragment extends Fragment {
    RecyclerView recyclerView;

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
          recyclerView = root.findViewById(R.id.rc_kapten);
        ArrayList<kapten> kaptens = new ArrayList<>();
        kaptens.add(new kapten(R.drawable.g,"محمةد حسونة"));
        kaptens.add(new kapten(R.drawable.g,"محمةد حسونة"));
        kaptenadapter adapter = new kaptenadapter(kaptens);
         RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(),2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);


        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}