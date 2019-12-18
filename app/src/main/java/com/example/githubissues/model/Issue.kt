package com.example.githubissues.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Issue(@SerializedName("url") val url: String?,
                 @SerializedName("repository_url") val repository_url: String?,
                 @SerializedName("labels_url") val labels_url: String?,
                 @SerializedName("comments_url") val comments_url: String?,
                 @SerializedName("events_url") val events_url: String?,
                 @SerializedName("html_url") val html_url: String?,
                 @SerializedName("id") val id: Int?,
                 @SerializedName("node_id") val node_id: String?,
                 @SerializedName("number") val number: Int?,
                 @SerializedName("title") val title: String?,
                 @SerializedName("user") val user: User?,
                 @SerializedName("labels") val labels: List<Label>?,
                 @SerializedName("state") val state: String?,
                 @SerializedName("locked") val locked: Boolean?,
                 @SerializedName("assignee") val assignee: Assignee?,
                 @SerializedName("assignees") val assignees: List<Assignee>?,
                 @SerializedName("milestone") val milestone: Milestone?,
                 @SerializedName("comments") val comments: Int?,
                 @SerializedName("created_at") val created_at: Date?,
                 @SerializedName("updated_at") val updated_at: Date?,
                 @SerializedName("closed_at") val closed_at: Date?,
                 @SerializedName("author_association") val author_association: String?,
                 @SerializedName("pull_request") val pull_request: PullRequest?,
                 @SerializedName("body") val body: String?)








