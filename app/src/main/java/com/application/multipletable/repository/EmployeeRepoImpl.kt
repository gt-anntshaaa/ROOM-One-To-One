package com.application.multipletable.repository

import androidx.lifecycle.LiveData
import com.application.multipletable.data.local.LocalDataSource
import com.application.multipletable.data.local.entity.Address
import com.application.multipletable.data.local.entity.Users
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EmployeeRepoImpl @Inject constructor(private val local: LocalDataSource) : EmployeeRepo {
    override suspend fun <T> insert(t: T) {
        when (t){
            is Users -> {
                local.insertUser(t as Users)
            }
            is Address -> {
                local.insertAddress(t as Address)
            }
        }
    }

    override fun deleteUser(id: Int) {
        local.delete(id)
    }

    override val loadDataUser: Flow<List<Users>> = local.loadUser
    override fun loadDataAddress(addressId: Int): Flow<Address> = local.loadAddress(addressId)


}