package com.uti.agriedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.uti.agriedu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        // Default fragment
        replaceFragment(Home())

        // Listener untuk bottom nav
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val handled = when (item.itemId) {
                R.id.home -> {
                    replaceFragment(Home())
                    true
                }
                R.id.ai -> {
                    // Buka URL OpenAI saat tombol AI diklik
                    val openaiUrl = "https://chatgpt.com/"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(openaiUrl))
                    startActivity(intent)
                    false // Mencegah item AI terpilih
                }
                R.id.setting -> {
                    replaceFragment(Setting())
                    true
                }
                else -> false
            }
            handled
        }

        // Handling padding untuk status/navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}