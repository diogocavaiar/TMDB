package com.example.tmdb.util.extensions

import diogo.com.br.data.mapper.IDateFormatter
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter : IDateFormatter {
    override fun format(value: Date, format: String): String {
        val simpleDateFormat = SimpleDateFormat(format)

        return simpleDateFormat.format(value)
    }
}