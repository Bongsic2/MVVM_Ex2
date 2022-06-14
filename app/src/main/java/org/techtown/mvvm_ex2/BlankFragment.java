package org.techtown.mvvm_ex2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.techtown.mvvm_ex2.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {


    private View view;
    private String fragment_number = "Fragment ";

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(int fragment_number) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();

        args.putString("fragment_number", fragment_number + "");

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            fragment_number += getArguments().getString("fragment_number");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentBlankBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false);
        view = binding.getRoot();

        //부모 액티비티의 viewModel 가져옴
        //  MainViewModel viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        //  MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        MainViewModel viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        binding.setFragmentNumber(fragment_number);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);


        return view;
    }

}