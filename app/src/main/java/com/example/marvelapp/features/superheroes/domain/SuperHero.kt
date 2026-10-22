package com.example.marvelapp.features.superheroes.domain

import android.media.Image
import java.net.URL

data class SuperHero(val id: String, val name: String, val slug: String, val url: URL, val image: Image) {

}