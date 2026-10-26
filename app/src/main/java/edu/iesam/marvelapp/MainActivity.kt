package edu.iesam.marvelapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.marvelapp.features.superheroes.data.local.xml.SuperHeroXmlLocalDaraSource
import edu.iesam.marvelapp.features.superheroes.domain.SuperHero

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Crear un ficher SharedPreferences para verlo
        val xml = SuperHeroXmlLocalDaraSource(this)
        xml.save(mutableListOf(SuperHero("id","SuperMan", "super-man", "https://")))
    }
}