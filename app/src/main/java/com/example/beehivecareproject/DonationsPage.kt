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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DonationsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donations_page)
        val Home = findViewById<TextView>(R.id.home8)
        val about = findViewById<TextView>(R.id.about8)
        val Training = findViewById<TextView>(R.id.training8)
        val Wishlist = findViewById<TextView>(R.id.wishlist8)
        val IncomeGenerater1 = findViewById<TextView>(R.id.incomege8)
        val Contact = findViewById<TextView>(R.id.contact8)
        val Gallery = findViewById<TextView>(R.id.gallery8)
        val Donations = findViewById<TextView>(R.id.donation8)

        val Button= findViewById<Button>(R.id.button2)
        val Textview= findViewById<TextView>(R.id.textView3)

        val Name = findViewById<EditText>(R.id.name)
        val Surname = findViewById<EditText>(R.id.surname)
        val Email = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val Phone = findViewById<EditText>(R.id.editTextPhone)
        val Password = findViewById<EditText>(R.id.editTextTextPassword)
        val TypeofDonate = findViewById<EditText>(R.id.donation)
        val NumberofDonate = findViewById<EditText>(R.id.editTextNumber)
        val Date = findViewById<EditText>(R.id.editTextDate)
        val Message = findViewById<EditText>(R.id.message)

        val database = Firebase.database
        val myRef1 = database.getReference("Houses New Database").child("2")
        val myRef = database.getReference("Bee Hive Care Donation database")

        var information : DonationClass



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
        Button.setOnClickListener {
            val dateString = Date.text.toString()
            val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val localDate = try {
                LocalDate.parse(dateString, dateFormatter)
            } catch (e: Exception) {
                LocalDate.now() // Default to current date if parsing fails
            }

            val information = DonationClass(
                Name.text.toString(),
                Surname.text.toString(),
                Email.text.toString(),
                Phone.text.toString().toIntOrNull() ?: 0, // Convert to Int, default to 0 if conversion fails
                Password.text.toString(),
                TypeofDonate.text.toString(),
                NumberofDonate.text.toString().toIntOrNull() ?: 0, // Convert to Int, default to 0 if conversion fails
                date = localDate,
                Message.text.toString()
            )

            myRef.setValue(information)
        }

        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot){
                Textview.text = snapshot.value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        myRef1.setValue("FireBase Is Working")

    }
}