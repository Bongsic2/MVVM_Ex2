package org.techtown.mvvm_ex2;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> data;

    //data binding시 필요
    public LiveData<Integer> getMutableData()
    {
        if(data == null)
            data = new MutableLiveData(0);

        return data;
    }

    //값 증가
    public void add()
    {
        data.setValue(data.getValue()+1);
        Log.i("MainViewModel", data.getValue().toString());
    }
}