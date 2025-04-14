package com.frete.listapedidos.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frete.listapedidos.R;
import com.frete.listapedidos.databinding.FragmentAddOrderBinding;
import com.frete.listapedidos.databinding.FragmentHomeBinding;
import com.frete.listapedidos.viewmodel.OrderViewModel;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}