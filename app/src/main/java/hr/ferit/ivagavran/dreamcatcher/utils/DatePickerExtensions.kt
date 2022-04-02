package hr.ferit.ivagavran.dreamcatcher.utils

import android.widget.DatePicker
import java.util.*

fun DatePicker.getDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, dayOfMonth)
    return calendar.time
}
