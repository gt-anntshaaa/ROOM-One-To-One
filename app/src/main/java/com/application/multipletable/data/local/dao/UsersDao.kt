package com.application.multipletable.data.local.dao

import androidx.room.*
import com.application.multipletable.data.local.entity.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: Users)

    @Query("SELECT*FROM users")
    fun loadAllUser() : Flow<List<Users>>

    @Query("DELETE FROM users WHERE user_id = :id")
    fun delete(id: Int)
}