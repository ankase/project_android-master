package com.neverova.project.data

import com.neverova.project.R
import com.neverova.project.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
            Film("WALL·E", R.drawable.walle, "In the distant future, a small waste-collecting robot inadvertently embarks on a space journey that will ultimately decide the fate of mankind.", 8.3f),
            Film("Django Unchained", R.drawable.django_unchained, "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation-owner in Mississippi.", 6.5f),
            Film("Inglourious Basterds", R.drawable.inglourios_basterds, "In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same.", 7.6f),
            Film("Pulp Fiction", R.drawable.pulp_fiction, "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", 9.9f),
            Film("The Boy in the Striped Pyjamas", R.drawable.the_boy_in_the_striped_pyjamas, "Through the innocent eyes of Bruno, the eight-year-old son of the commandant at a German concentration camp, a forbidden friendship with a Jewish boy on the other side of the camp fence has startling and unexpected consequences.", 5.5f),
            Film("The Dark Knight Rises", R.drawable.the_dark_knight_rises, "Eight years after the Joker's reign of anarchy, Batman, with the help of the enigmatic Catwoman, is forced from his exile to save Gotham City from the brutal guerrilla terrorist Bane.", 2.0f),
            Film("The Green Mile", R.drawable.the_green_mile, "The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.", 4.8f),
            Film("The Hateful Eight", R.drawable.the_hateful_eight, "n the dead of a Wyoming winter, a bounty hunter and his prisoner find shelter in a cabin currently inhabited by a collection of nefarious characters.",3.5f)
    )
}