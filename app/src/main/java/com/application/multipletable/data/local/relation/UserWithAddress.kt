package com.application.multipletable.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.application.multipletable.data.local.entity.Address
import com.application.multipletable.data.local.entity.Users

data class UserWithAddress(
    @Embedded val users: Users,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val address: Address
)
