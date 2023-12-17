package com.example.kotlin_formation.ui.profil

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.kotlin_formation.MainActivity
import com.example.kotlin_formation.R
import com.example.kotlin_formation.databinding.FragmentHomeBinding
import com.example.kotlin_formation.databinding.FragmentProfilBinding
import com.example.kotlin_formation.ui.home.HomeViewModel
import com.example.kotlin_formation.ui.login.LoginActivity
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfilFragment : Fragment() {
    lateinit var mAuth: FirebaseAuth;
    lateinit var email: TextView;
    lateinit var update: Button;
    lateinit var name: EditText;
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = ProfilFragment()
    }

    private lateinit var viewModel: ProfilViewModel

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAuth= FirebaseAuth.getInstance();
        val CurrentUser: FirebaseUser? = mAuth.currentUser
        val profilViewModel = ViewModelProvider(this).get(ProfilViewModel::class.java)

        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        if (CurrentUser != null){
            binding.hi.setText( "hi \n"+CurrentUser.getEmail());
            binding.changeemail.setOnClickListener{

                changeEmail(binding.email.getText().toString());
            }
            binding.changepassword.setOnClickListener{
                if(binding.password.getText().toString() == binding.passwordConf.getText().toString()){
                    changePassword(binding.password.getText().toString());
                }else{
                    Toast.makeText(context, "Password And Password Confirmation are not the same", Toast.LENGTH_LONG).show()

                }

            }
        }
        val root: View = binding.root
        return root
    }

    private fun changeEmail(newEmail: String) {
        val currentUser = mAuth.currentUser

        currentUser?.verifyBeforeUpdateEmail(newEmail)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    binding.hi.text = "hi \n$newEmail"
                    Toast.makeText(context, "Updated successfully", Toast.LENGTH_LONG).show()
                    mAuth.signOut()
                    navigateToLoginPage()
                } else {
                    Toast.makeText(context, " ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun changePassword(newPassword: String){
        val currentUser = mAuth.currentUser

        currentUser?.updatePassword(newPassword)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Updated successfully", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, " ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
    private fun navigateToLoginPage() {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfilViewModel::class.java)
        // TODO: Use the ViewModel
    }

}