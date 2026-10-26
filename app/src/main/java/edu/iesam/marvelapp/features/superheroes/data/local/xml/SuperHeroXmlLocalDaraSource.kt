package edu.iesam.marvelapp.features.superheroes.data.local.xml

import android.content.Context
import edu.iesam.marvelapp.R
import edu.iesam.marvelapp.features.superheroes.domain.SuperHero

/*
* Conector para gestionar datos en un fichero XML o través de SharedPreferences
*
*/
class SuperHeroXmlLocalDaraSource(private val context: Context) {
    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_file_key),
        Context.MODE_PRIVATE
    )

    public fun findAl(): List<SuperHero> {
        // sharedPref.getString()
        return emptyList()
    }

    public fun findByUd(id: String): SuperHero {
        return SuperHero(
            "id",
            "name",
            "slug",
            urlImage = TODO()
        )
    }

    public fun save(superHeroes: List<SuperHero>) {

        //sharedPref.edit().putString("id", superHeroes.first().id)
        //sharedPref.edit().putString("name", superHeroes.first().name)
        //sharedPref.edit().putString("slug", superHeroes.first().slug)

        //with(sharedPref.edit()){
        //    putString("id", superHeroes.first().id)
        //   putString("name", superHeroes.first().name)
        // putString("slug", superHeroes.first().slug)
        // apply()
        //}


        // Dos formas de persistir un local
        sharedPref.edit().apply()
        // sharedPref.edit().commit()

        superHeroes.forEach { superHero ->
            with(sharedPref.edit()) {
                putString("id-${superHero.id}", superHero.id)
                putString("name-${superHero.id}", superHero.name)
                putString("slug-${superHero.id}", superHero.slug)
                apply()
            }
        }
    }
}