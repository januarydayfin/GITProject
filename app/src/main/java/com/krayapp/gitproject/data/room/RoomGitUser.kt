package com.krayapp.gitproject.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomGitUser (
    @PrimaryKey var id: String,
    var login: String,
    var avatarUrl: String,
    var reposUrl: String
)
