package com.thebrownfoxx.quotegenerator.logic

import java.time.LocalDate

const val AuthorSeparator = "---"

fun String.toQuote(category: QuoteCategory): Quote {
    val quoteAndAuthor = split(AuthorSeparator)
    val quote = quoteAndAuthor.first()
    val author = quoteAndAuthor.getOrNull(1)
    return Quote(
        value = quote,
        category = category,
        author = author,
    )
}

data class Quote(
    val value: String,
    val category: QuoteCategory,
    val author: String? = null,
) {
    val quoteAndAuthorString = if (author == null) value else value + AuthorSeparator + author
}

data class FavoriteQuote(
    val quote: Quote,
    val dateFavorited: LocalDate,
)