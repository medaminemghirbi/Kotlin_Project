package com.example.kotlin_formation.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlin_formation.MainActivity
import com.example.kotlin_formation.R
import com.example.kotlin_formation.ui.inscription.InscriptionActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
class LoginActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth;
    lateinit var btnRegister: Button;
    lateinit var btnLogin: Button;
    lateinit var email: EditText;
    lateinit var password: EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth= FirebaseAuth.getInstance();
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btnRegister = findViewById(R.id.register)
        btnLogin = findViewById(R.id.login)
        btnRegister.setOnClickListener{
            var X = Intent(this, InscriptionActivity::class.java)
            startActivity(X);
        }
        btnLogin.setOnClickListener{
            Login();
        }
    }
    override fun onStart() {
        super.onStart()
        val CurrentUser: FirebaseUser? = mAuth.currentUser
        if (CurrentUser != null){
            Toast.makeText(this, "Already connected", Toast.LENGTH_LONG).show()
            var X = Intent(this, MainActivity::class.java)
            startActivity(X);
        }
    }
    fun Login()
    {
        mAuth.signInWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener{
                task ->
            if(task.isSuccessful){
                val user = mAuth.currentUser
                Toast.makeText(this, "You are Logged In", Toast.LENGTH_LONG).show()
                var X = Intent(this, MainActivity::class.java)
                startActivity(X);

            }else{
                Toast.makeText(this, "Authentification failed ", Toast.LENGTH_LONG).show()

            }
        }
    }
}