package com.example.beehivecareproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WishlistPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist_page)
        val Home = findViewById<TextView>(R.id.home4)
        val about = findViewById<TextView>(R.id.about4)
        val Training = findViewById<TextView>(R.id.training4)
        val Wishlist = findViewById<TextView>(R.id.wishlist4)
        val IncomeGenerater1 = findViewById<TextView>(R.id.incomege4)
        val Contact = findViewById<TextView>(R.id.contact4)
        val Gallery = findViewById<TextView>(R.id.gallery4)
        val Donations = findViewById<TextView>(R.id.donations4)

        Home.setOnClickListener {
            var intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        about.setOnClickListener {
            var intent= Intent(this,AboutPage::class.java)
            startActivity(intent)
        }
        Training.setOnClickListener {
            var intent= Intent(this,TrainingPage::class.java)
            startActivity(intent)
        }
        Wishlist.setOnClickListener {
            var intent= Intent(this,WishlistPage::class.java)
            startActivity(intent)
        }
        IncomeGenerater1.setOnClickListener {
            var intent= Intent(this,IncomeGenerater::class.java)
            startActivity(intent)
        }
        Contact.setOnClickListener {
            var intent= Intent(this,ContactPage::class.java)
            startActivity(intent)
        }
        Gallery.setOnClickListener {
            var intent= Intent(this,GalleryPage::class.java)
            startActivity(intent)
        }
        Donations.setOnClickListener {
            var intent= Intent(this,DonationsPage::class.java)
            startActivity(intent)
        }
    }
}