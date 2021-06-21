package com.krayapp.gitproject.data.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomGitUser::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RoomGitRepo(
    @PrimaryKey var id: String,
    var name: String,
    var forksCount: Int,
    var userId: String
) {
}