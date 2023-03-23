package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel() {

    private var _shoeList:MutableLiveData<List<Shoe>> = MutableLiveData(listOf())
    var shoelist:LiveData<List<Shoe>> = _shoeList

    fun addShoe(shoe:Shoe) {
        _shoeList.value = _shoeList.value?.plus(shoe)?: listOf(shoe)
    }

}