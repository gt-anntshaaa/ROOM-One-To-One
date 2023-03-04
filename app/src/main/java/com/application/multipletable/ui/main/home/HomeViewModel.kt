package com.application.multipletable.ui.main.home

import androidx.lifecycle.*
import androidx.navigation.NavController
import com.application.multipletable.data.local.entity.Users
import com.application.multipletable.repository.EmployeeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: EmployeeRepo): ViewModel(){

    val loadAllUser:LiveData<List<Users>> = repo.loadDataUser.asLiveData()

    fun addUser(user: Users) = viewModelScope.launch {
        repo.insert(user)
    }

    fun deleteUser(id: Int){
        repo.deleteUser(id)
    }

    fun onItemClick(id: Int, navController: NavController){
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
        navController.navigate(action)
    }


    //    private val _user = MutableLiveData<List<Users>>()
//    val user: LiveData<List<Users>> get() = _user

//    private val listUser = mutableListOf<Users>()
//    fun addUser(username: String, email: String) {
//        listUser.add(Users(username,email))
//        _user.value = repo.insert(listUser)
//    }
}