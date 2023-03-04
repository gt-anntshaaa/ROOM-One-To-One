package com.application.multipletable.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.application.multipletable.data.local.dao.AddressDao
import com.application.multipletable.data.local.dao.UsersDao
import com.application.multipletable.data.local.entity.Address
import com.application.multipletable.data.local.entity.Users

@Database(entities = [Users::class, Address::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UsersDao
    abstract fun addressDao(): AddressDao
}