package edu.iesam.marvelapp.features.superheroes.data.local.xml

import android.content.Context
import edu.iesam.marvelapp.R
import edu.iesam.marvelapp.core.serialization.JsonSerializer
import edu.iesam.marvelapp.core.serialization.KotlinJsonSerializer
import edu.iesam.marvelapp.features.superheroes.domain.SuperHero

/*
* Conector para gestionar datos en un fichero XML o través de SharedPreferences
*
*/
class SuperHeroXmlLocalDaraSource(
    private val context: Context,
    private val serializer: JsonSerializer<List<SuperHero>> = KotlinJsonSerializer.create()
) {
    private val keySuperHero = "key_superhero"

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_file_key),
        Context.MODE_PRIVATE
    )

    public fun findAl(): List<SuperHero> {
        return findAll()
    }

    public fun findByUd(id: String): SuperHero? {
        return findById(id)
    }

    public fun save(superHeroes: List<SuperHero>) {
        val json = serializer.toJson(superHeroes)
        with(sharedPref.edit()) {
            putString(keySuperHero, json)
            apply()
        }
    }

    fun findAll(): List<SuperHero> {
        val jsonList: String? = sharedPref.getString(keySuperHero, null)
        jsonList?.let {
            return serializer.fromJson(it)
        }
        return emptyList()
    }

    fun findById(id: String): SuperHero? {
        return findAll().find { it.id == id }
    }

    fun deleteById(id: String) {
        val list = findAll().filterNot { it.id == id }
        save(list)
    }

    fun deleteAll() {
        sharedPref.edit().apply {
            remove(keySuperHero)
            apply()
        }
    }
}