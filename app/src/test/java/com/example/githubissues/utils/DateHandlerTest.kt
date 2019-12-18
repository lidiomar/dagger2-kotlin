package com.example.githubissues.utils

import android.content.Context
import android.content.res.Resources
import android.text.format.DateUtils
import com.example.githubissues.R
import com.example.githubissues.util.DateHandler
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.text.SimpleDateFormat
import java.util.*

class DateHandlerTest {

    lateinit var date: Date
    private val pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
    private val seconds = "seconds"
    private val minutes = "minutes"
    private val hours = "hours"
    private val days = "days"
    private val weeks = "weeks"
    private val months = "months"
    private val years = "years"

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var resourcesMock: Resources

    private val dateUtilsMock = mockkStatic(DateUtils::class)

    @Before
    fun setup() {
        val sdfNow = SimpleDateFormat(pattern)
        val stringDateNow = "1970-01-01T01:00:00.000-0300"
        date = sdfNow.parse(stringDateNow)
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testSecondsAgo() {
        dateUtilsMock
        every { DateUtils.getRelativeTimeSpanString(date.time, getDatePlusSecond().time, DateUtils.SECOND_IN_MILLIS).toString() } returns seconds

        val relativeDate = DateHandler().getRelativeDate(context, date, getDatePlusSecond())
        assert(relativeDate.equals(seconds))
    }

    @Test
    fun testMinutesAgo() {
        dateUtilsMock
        every { DateUtils.getRelativeTimeSpanString(date.time, getDatePlusMinute().time, DateUtils.MINUTE_IN_MILLIS).toString() } returns minutes

        val relativeDate = DateHandler().getRelativeDate(context, date, getDatePlusMinute())
        assert(relativeDate.equals(minutes))
    }

    @Test
    fun testHoursAgo() {
        dateUtilsMock
        every { DateUtils.getRelativeTimeSpanString(date.time, getDatePlusHour().time, DateUtils.HOUR_IN_MILLIS).toString() } returns hours

        val relativeDate = DateHandler().getRelativeDate(context, date, getDatePlusHour())
        assert(relativeDate.equals(hours))
    }

    @Test
    fun testDaysAgo() {
        dateUtilsMock
        every { DateUtils.getRelativeTimeSpanString(date.time, getDatePlusDay().time, DateUtils.DAY_IN_MILLIS).toString() } returns days

        val relativeDate = DateHandler().getRelativeDate(context, date, getDatePlusDay())
        assert(relativeDate.equals(days))
    }

    @Test
    fun testWeeksAgo() {
        dateUtilsMock
        every { DateUtils.getRelativeTimeSpanString(date.time, getDatePlusWeek().time, DateUtils.WEEK_IN_MILLIS).toString() } returns weeks

        val relativeDate = DateHandler().getRelativeDate(context, date, getDatePlusWeek())
        assert(relativeDate.equals(weeks))
    }

    @Test
    fun testMonthAgo() {
        `when`(context.resources).thenReturn(resourcesMock)
        `when`(resourcesMock.getQuantityString(R.plurals.months_ago, 1, 1)).thenReturn(months)
        val relativeDate = DateHandler().getRelativeDate(context, date, getDatePlusMonth())
        assert(relativeDate.equals(months))
    }

    @Test
    fun testYearsAgo() {
        `when`(context.resources).thenReturn(resourcesMock)
        `when`(resourcesMock.getQuantityString(R.plurals.years_ago, 1, 1)).thenReturn(years)
        val relativeDate = DateHandler().getRelativeDate(context, date, getDatePlusYear())
        assert(relativeDate.equals(years))
    }


    private fun getDatePlusSecond(): Date {
        val sdf = SimpleDateFormat(pattern)
        val stringDate = "1970-01-01T01:00:30.000-0300"

        return sdf.parse(stringDate)
    }

    private fun getDatePlusMinute(): Date {
        val sdf = SimpleDateFormat(pattern)
        val stringDate = "1970-01-01T01:01:00.000-0300"

        return sdf.parse(stringDate)
    }

    private fun getDatePlusHour(): Date {
        val sdf = SimpleDateFormat(pattern)
        val stringDate = "1970-01-01T02:00:00.000-0300"

        return sdf.parse(stringDate)
    }

    private fun getDatePlusDay(): Date {
        val sdf = SimpleDateFormat(pattern)
        val stringDate = "1970-01-02T01:00:00.000-0300"

        return sdf.parse(stringDate)
    }

    private fun getDatePlusWeek(): Date {
        val sdf = SimpleDateFormat(pattern)
        val stringDate = "1970-01-08T01:00:00.000-0300"

        return sdf.parse(stringDate)
    }

    private fun getDatePlusMonth(): Date {
        val sdf = SimpleDateFormat(pattern)
        val stringDate = "1970-02-01T01:00:00.000-0300"

        return sdf.parse(stringDate)
    }

    private fun getDatePlusYear(): Date {
        val sdf = SimpleDateFormat(pattern)
        val stringDate = "1971-01-01T01:00:00.000-0300"

        return sdf.parse(stringDate)
    }

}