package com.thebrownfoxx.quotegenerator.logic

import java.time.LocalDate
import kotlin.random.Random

enum class QuoteCategory(val quotes: List<String>) {
    Love(
        listOf(
            "Incest is best; put your brother to the test. - How to Get Away With Murder",
            "Love is the masterpiece that two souls paint together on the canvas of life.",
            "In the symphony of existence, our love is the most beautiful melody.",
            "Love is the language our hearts speak fluently, transcending all barriers.",
            "Every moment spent with you is a brushstroke on the canvas of my heart's masterpiece.",
            "Like a puzzle, our hearts fit together perfectly, creating a picture of love that's uniquely ours.",
            "Love is the fire that warms our souls, making every moment together an ember of passion.",
            "In the garden of life, our love is the most exquisite and enduring bloom.",
            "Love is not just a chapter in the book of life; it's the story that fills every page.",
            "Our love is the ink that writes the poetry of our shared journey.",
            "With you, love is not a destination; it's the adventurous path we choose to walk together.",
        )
    ),
    Inspirational(
        listOf(
            "Life is not a bed of roses neither it is full of thorns. Prosperity in every field of life never comes to you on its own. YOU HAVE TO STRUGGLE HARD TO GET TO IT. - Herbivore",
            "Life's challenges are the chisels that carve the masterpiece of your character.",
            "Your dreams are the stars that guide you through the darkest nights of doubt.",
            "In every setback, there's a hidden opportunity waiting to be uncovered.",
            "Strength is not the absence of fear but the courage to take action in its presence.",
            "The journey of a thousand miles begins with a single step; take that step today.",
            "Every moment is a chance to write a new chapter in the book of your life.",
            "Success is not about reaching the destination but enjoying the journey along the way.",
            "Your attitude determines your altitude; aim high and believe in your ascent.",
            "Adversity is the forge where resilience is shaped into a formidable weapon.",
            "In the garden of life, plant the seeds of kindness, and watch love and happiness bloom.",
        )
    ),
    Funny(
        listOf(
            "Life is too short for boring socks. Wear the ones with pizza and unicorns!",
            "I put the 'elusive' in 'exclusive club.'",
            "I'm not clumsy; I'm just performing impromptu interpretive dances.",
            "I don't need a hairstylist; my pillow gives me a new hairstyle every morning.",
            "I can't adult today. Please don't make me adult.",
            "I'm on a seafood diet. I see food, and I eat it.",
            "I told my computer I needed a break, and now it won't stop throwing me error messages.",
            "I'm not arguing; I'm just explaining why I'm right.",
            "I'm not a morning person. I'm not an afternoon person. Let's just say I'm not a person until I've had coffee.",
            "I used to be a people person, but people ruined that for me.",
        )
    );

    fun getRandomQuote(random: Random = Random, previousQuote: Quote? = null): Quote {
        val quotePool = if (previousQuote == null) quotes else quotes - previousQuote.value
        return Quote(
            value = quotePool.random(random),
            category = this,
        )
    }
}

fun getQuoteOfTheDay(): Quote {
    val seed = LocalDate.now().toEpochDay()
    val random = Random(seed)
    val category = QuoteCategory.values().random(random)
    return category.getRandomQuote(random)
}