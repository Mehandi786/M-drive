package com.hassan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hassan.MainActivity;
import com.hassan.R;
import com.hassan.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeAddressDetailsFragment extends Fragment {

    EditText permAddressET, tempAddressET;
    Button backButton, submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employee_address_details, container, false);
        permAddressET = (EditText) view.findViewById(R.id.perAddrET);
        tempAddressET = (EditText) view.findViewById(R.id.tempAddrET);
        backButton = (Button) view.findViewById(R.id.backBtn);
        submitButton = (Button) view.findViewById(R.id.submitBtn);
        ButtonListener buttonListener = new ButtonListener();
        backButton.setOnClickListener(buttonListener);
        submitButton.setOnClickListener(buttonListener);
        return view;
    }

    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(backButton.getId() == view.getId()) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragment = fragmentManager.findFragmentByTag(MainActivity.BASIC_DETAIL_FRAGMENT_TAG);
                if( fragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.layout,fragment);
                    fragmentTransaction.commit();
                }
            }else {

            }
        }
    }
}