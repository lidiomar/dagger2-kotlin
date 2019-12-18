package com.example.githubissues.util

import android.content.Context
import android.text.format.DateUtils
import com.example.githubissues.R
import java.util.*

class DateHandler {

    fun getRelativeDate(context: Context, date: Date, dateNow: Date): String {

        val monthInMillis = DateUtils.WEEK_IN_MILLIS * 4
        val yearInMillis = DateUtils.WEEK_IN_MILLIS * 4 * 12
        val interval = dateNow.time - date.time

        return when(interval) {
            in 0 until DateUtils.MINUTE_IN_MILLIS -> {
                DateUtils.getRelativeTimeSpanString(date.time, dateNow.time, DateUtils.SECOND_IN_MILLIS).toString()
            }
            in DateUtils.MINUTE_IN_MILLIS until DateUtils.HOUR_IN_MILLIS -> {
                DateUtils.getRelativeTimeSpanString(date.time, dateNow.time, DateUtils.MINUTE_IN_MILLIS).toString()
            }
            in DateUtils.HOUR_IN_MILLIS until DateUtils.DAY_IN_MILLIS -> {
                DateUtils.getRelativeTimeSpanString(date.time, dateNow.time, DateUtils.HOUR_IN_MILLIS).toString()
            }
            in DateUtils.DAY_IN_MILLIS until DateUtils.WEEK_IN_MILLIS -> {
                DateUtils.getRelativeTimeSpanString(date.time, dateNow.time, DateUtils.DAY_IN_MILLIS).toString()
            }
            in DateUtils.WEEK_IN_MILLIS until monthInMillis -> {
                DateUtils.getRelativeTimeSpanString(date.time, dateNow.time, DateUtils.WEEK_IN_MILLIS).toString()
            }
            in monthInMillis until yearInMillis -> {
                var numberOfMonths = interval / monthInMillis
                context.resources.getQuantityString(R.plurals.months_ago, numberOfMonths.toInt(),numberOfMonths.toInt())
            }
            else -> {
                var numberOfYears = interval / yearInMillis
                context.resources.getQuantityString(R.plurals.years_ago, numberOfYears.toInt(),numberOfYears.toInt())
            }
        }
    }
}