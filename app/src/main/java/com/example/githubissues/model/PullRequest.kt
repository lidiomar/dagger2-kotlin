package com.example.githubissues.model

import com.google.gson.annotations.SerializedName

data class PullRequest(@SerializedName("url") val url: String?,
                       @SerializedName("html_url") val html_url: String?,
                       @SerializedName("diff_url") val diff_url: String?,
                       @SerializedName("patch_url") val patch_url: String?)

