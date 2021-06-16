package com.krayapp.gitproject.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitRepoList(
   @Expose val name : String? = null
):Parcelable {
}