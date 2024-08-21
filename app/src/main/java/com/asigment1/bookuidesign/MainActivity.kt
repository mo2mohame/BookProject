package com.asigment1.bookuidesign

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.asigment1.bookuidesign.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val books = mutableListOf<Book>(
            Book(R.drawable.solitude, "One Hundred Years of Solitude", "by Gabriel García Márquez", 3.5f),
            Book(R.drawable.nostra, "Terra Nostra", "by Carlos Fuentes", 3f),
            Book(R.drawable.angels, "Angels & Demons", "by Dan Brown", 4f),
            Book(R.drawable.sword, "The Sword Thief", "by Peter Lerangis", 2f),
            Book(R.drawable.inferno, "Inferno", "by Dan Brown", 4.5f),
            Book(R.drawable.blood, "Bloodline", "by James Rollins", 2f),
            Book(R.drawable.spirits, "The House of the Spirits", "by Isabel Allende", 3f),
            Book(R.drawable.humming, "The Hummingbird's Daughter", "by Luis Alberto Urrea", 4.5f),
        )

        val adapter = BookAdapter(books)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.toolbar.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.notification -> {
                    Toast.makeText(this, R.string.notificationClick, Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

        binding.toolbar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }


        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.reviews -> {
                    Toast.makeText(this, R.string.reviewsClick, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.favs -> {
                    Toast.makeText(this, R.string.favoriteClick, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, R.string.searchClick, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this, R.string.profileClick, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, R.string.settingsClick, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else -> false
            }
        }
    }
}