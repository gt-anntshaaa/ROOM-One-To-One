package com.application.multipletable.ui.main.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.application.multipletable.data.local.entity.Address
import com.application.multipletable.repository.EmployeeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repo: EmployeeRepo) : ViewModel() {
    fun insert(address: Address) = viewModelScope.launch {
        withContext(Dispatchers.IO){
            repo.insert(address)
        }
    }

//    fun loadAddress(addressId: Int): LiveData<Address> {
//        return repo.loadDataAddress(addressId).asLiveData()
//    }

    private val _address = MutableLiveData<Address>()
    val address: LiveData<Address> get() = _address

    fun loadAddressById(addressId: Int): LiveData<Address>{
        return repo.loadDataAddress(addressId).asLiveData()
    }

}