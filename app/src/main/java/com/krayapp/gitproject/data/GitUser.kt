package com.krayapp.gitproject.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitUser(
    val login: String
): Parcelable
