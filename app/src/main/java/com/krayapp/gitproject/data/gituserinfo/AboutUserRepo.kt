package com.krayapp.gitproject.data.gituserinfo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class AboutUserRepo(
    @Expose val forks: Int? = null
): Parcelable {
}