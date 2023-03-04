package com.application.multipletable.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.application.multipletable.data.local.entity.Address
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {
    @Query("SELECT*FROM address WHERE address_id = :addressId")
    fun loadAddress(addressId: Int): Flow<Address>

    @Insert
    fun insert(address: Address)
}