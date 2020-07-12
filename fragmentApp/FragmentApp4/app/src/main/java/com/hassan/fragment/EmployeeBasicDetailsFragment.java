package com.hassan.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hassan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeBasicDetailsFragment extends Fragment {

    EditText nameET, emailET, phoneET;

    BasicDetailsFragmentCallback basicDetailsFragmentCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employee_basic_details, container, false);
        nameET = (EditText) view.findViewById(R.id.nameET);
        emailET = (EditText) view.findViewById(R.id.emailET);
        phoneET = (EditText) view.findViewById(R.id.phoneET);
        Button continueBtn = (Button) view.findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(new ButtonListener());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        basicDetailsFragmentCallback = (BasicDetailsFragmentCallback) getActivity();
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            basicDetailsFragmentCallback.callEmployeeAddressDetailsFragment();
        }
    }

    public interface BasicDetailsFragmentCallback {
        void callEmployeeAddressDetailsFragment();
    }
}