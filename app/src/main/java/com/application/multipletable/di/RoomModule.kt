package com.application.multipletable.di

import android.content.Context
import androidx.room.Room
import com.application.multipletable.data.local.AppDatabase
import com.application.multipletable.data.local.LocalDataSource
import com.application.multipletable.data.local.dao.AddressDao
import com.application.multipletable.data.local.dao.UsersDao
import com.application.multipletable.repository.EmployeeRepo
import com.application.multipletable.repository.EmployeeRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "Employees.db"
        ).build()
    }

    @Provides
    fun provideUserLocalDataSource(db: AppDatabase): UsersDao{
        return db.userDao()
    }

    @Provides
    fun provideAddressLocalDataSource(db: AppDatabase): AddressDao{
        return db.addressDao()
    }

    @Provides
    fun provideEmpRepo(local: LocalDataSource): EmployeeRepo{
        return EmployeeRepoImpl(local)
    }
}