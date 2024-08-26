package com.example.beehivecareproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class ContactPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_page)
        val Home = findViewById<TextView>(R.id.home6)
        val about = findViewById<TextView>(R.id.about6)
        val Training = findViewById<TextView>(R.id.training6)
        val Wishlist = findViewById<TextView>(R.id.wishlist6)
        val IncomeGenerater1 = findViewById<TextView>(R.id.incomege6)
        val Contact = findViewById<TextView>(R.id.contact6)
        val Gallery = findViewById<TextView>(R.id.gallery6)
        val Donations = findViewById<TextView>(R.id.donations6)
        val Textview= findViewById<TextView>(R.id.textView)
        val button= findViewById<Button>(R.id.button)
        val Name = findViewById<EditText>(R.id.editTextText)
        val Email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val Subject = findViewById<EditText>(R.id.editTextText3)
        val Message = findViewById<EditText>(R.id.editTextText4)

        val database = Firebase.database
        val myRef1 = database.getReference("Bee Connection test").child("2")
        val myRef = database.getReference("Bee Hive Care Contact information ")
        var contactinformation : Contactclass
        button.setOnClickListener {
            contactinformation = Contactclass(Name.text.toString(), Email.text.toString(), Subject.text.toString(), Message.text.toString())
            myRef.setValue(contactinformation)
        }
        myRef1.setValue("E")
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot){
                Textview.text = snapshot.value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

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