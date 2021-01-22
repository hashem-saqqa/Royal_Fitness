package com.example.royalfitnessmhr.ui.share;

import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.royalfitnessmhr.R;
import com.example.royalfitnessmhr.createacount;
import com.example.royalfitnessmhr.ui.fitnees.FitneesFragment;
import com.example.royalfitnessmhr.ui.fitnes.FitnesFragment;
import com.example.royalfitnessmhr.ui.home.HomeFragment;
import com.example.royalfitnessmhr.ui.salary.SalaryFragment;
import com.example.royalfitnessmhr.ui.serves.ServesFragment;

public class ShareFragment extends Fragment {
Button serves ;
    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        serves = root.findViewById(R.id.serves);
      serves.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FitneesFragment fitneesFragment = new FitneesFragment ();
              FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
              fragmentTransaction.replace(R.id.drawer_layout, fitneesFragment);
              fragmentTransaction.addToBackStack(null);
              fragmentTransaction.commit();
          }
      });


       shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

    }


}