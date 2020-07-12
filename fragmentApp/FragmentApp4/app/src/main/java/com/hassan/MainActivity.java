package com.hassan;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.hassan.R;
import com.hassan.fragment.EmployeeAddressDetailsFragment;
import com.hassan.fragment.EmployeeAddressDetailsFragment;
import com.hassan.fragment.EmployeeBasicDetailsFragment;

public class MainActivity extends AppCompatActivity implements EmployeeBasicDetailsFragment.BasicDetailsFragmentCallback {

    FragmentManager fragmentManager;

    public static final String BASIC_DETAIL_FRAGMENT_TAG="EmployeeBasicFragment";
    public static final String EMPLOYEE_ADDRESS_FRAGMENT_TAG="EmployeeAddressFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        addEmployeeBasicDetailsFragment();
    }

    private void addEmployeeBasicDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout,new EmployeeBasicDetailsFragment(),BASIC_DETAIL_FRAGMENT_TAG);
        fragmentTransaction.addToBackStack(BASIC_DETAIL_FRAGMENT_TAG);
        fragmentTransaction.commit();
    }

    private void addEmployeeAddressDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout,new EmployeeAddressDetailsFragment(),EMPLOYEE_ADDRESS_FRAGMENT_TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void callEmployeeAddressDetailsFragment() {
        addEmployeeAddressDetailsFragment();
    }
}