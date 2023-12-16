package com.example.kotlin_formation.ui.inscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlin_formation.MainActivity
import com.example.kotlin_formation.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class InscriptionActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth;
    lateinit var email: EditText;
    lateinit var password: EditText;
    lateinit var btncre: Button;
    lateinit var btnlog: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)
        mAuth= FirebaseAuth.getInstance();
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btncre = findViewById(R.id.register)
        btncre.setOnClickListener{
            signUp();
        }
    }

    override fun onStart() {
        super.onStart()
        val CurrentUser: FirebaseUser? = mAuth.currentUser
        if (CurrentUser != null){
            Toast.makeText(this, "Already connected", Toast.LENGTH_LONG).show()
        }
    }
    fun signUp()
    {
        mAuth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener{
                task ->
            if(task.isSuccessful){
                val user = mAuth.currentUser
                Toast.makeText(this, "You create a new account ", Toast.LENGTH_LONG).show()
                var X = Intent(this, MainActivity::class.java)
                startActivity(X);
                Toast.makeText(this, "You Should Login In Now ", Toast.LENGTH_LONG).show()


            }else{
                Toast.makeText(this, "Authentification failed ", Toast.LENGTH_LONG).show()

            }
        }
    }
}
