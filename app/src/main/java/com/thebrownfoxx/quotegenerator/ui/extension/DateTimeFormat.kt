package com.thebrownfoxx.quotegenerator.ui.extension

import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy")

fun LocalDate.formatted(): String = formatter.format(this)