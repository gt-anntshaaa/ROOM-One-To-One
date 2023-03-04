package com.application.multipletable.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "address", foreignKeys = [
    ForeignKey(
        entity = Users::class,
        parentColumns = ["user_id"],
        childColumns = ["user_id"],
        onDelete = CASCADE
    )
])
data class Address(
    @ColumnInfo(name = "user_id") val userId: Int?,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "street") val street: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "address_id")
    var addressId: Int = 0
}
