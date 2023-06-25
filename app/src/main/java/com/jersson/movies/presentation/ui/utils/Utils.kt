package com.jersson.movies.presentation.ui.utils

import com.jersson.movies.presentation.ui.commons.FINAL_DATE
import com.jersson.movies.presentation.ui.commons.INIT_DATE
import java.text.SimpleDateFormat
import java.util.*

fun convertDate(releaseDate: String): String {
    val dateInput = SimpleDateFormat(INIT_DATE, Locale.getDefault())
    val dateOutput = SimpleDateFormat(FINAL_DATE, Locale.getDefault())

    val date: Date = dateInput.parse(releaseDate) ?: return ""
    return dateOutput.format(date)
}