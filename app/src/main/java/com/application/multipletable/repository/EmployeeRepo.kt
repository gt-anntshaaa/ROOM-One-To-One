package com.application.multipletable.repository

import androidx.lifecycle.LiveData
import com.application.multipletable.data.local.entity.Address
import com.application.multipletable.data.local.entity.Users
import kotlinx.coroutines.flow.Flow

interface EmployeeRepo {
    suspend fun <T> insert(t: T)
    fun deleteUser(id: Int)
    val loadDataUser: Flow<List<Users>>

    fun loadDataAddress(addressId: Int): Flow<Address>
}