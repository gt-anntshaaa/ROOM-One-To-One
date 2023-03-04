package com.application.multipletable.data.local

import com.application.multipletable.data.local.dao.AddressDao
import com.application.multipletable.data.local.dao.UsersDao
import com.application.multipletable.data.local.entity.Address
import com.application.multipletable.data.local.entity.Users
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val usersDao: UsersDao, private val addressDao: AddressDao) {
    suspend fun insertUser(users: Users){
        usersDao.insert(users)
    }
    val loadUser: Flow<List<Users>> = usersDao.loadAllUser()

    fun delete(id: Int){
        usersDao.delete(id)
    }

    suspend fun insertAddress(address: Address){
        addressDao.insert(address)
    }
    fun loadAddress(addressId: Int): Flow<Address> = addressDao.loadAddress(addressId)
}