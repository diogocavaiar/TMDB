package diogo.com.br.data.mapper

import java.util.*

interface IDateFormatter {

    fun format(value: Date, format: String = "dd/MM/yyyy"): String
}