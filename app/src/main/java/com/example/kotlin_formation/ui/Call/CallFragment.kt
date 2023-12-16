package com.example.kotlin_formation.ui.Call
import android.Manifest

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlin_formation.databinding.FragmentCallBinding

class CallFragment : Fragment() {
    private var _binding: FragmentCallBinding? = null

    private val binding get() = _binding!!
    companion object {
        fun newInstance() = CallFragment()
        private const val CALL_PERMISSION_REQUEST_CODE = 123
    }

    private lateinit var viewModel: CallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCallBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button.setOnClickListener {
            val phoneNumber = binding.editTextPhoneNumber.text.toString()
            if (phoneNumber.isNotEmpty()) {
                if (hasCallPermission()) {
                    makePhoneCall(phoneNumber)
                } else {
                    requestCallPermission()
                }
            }
        }

        return root
    }
    private fun hasCallPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCallPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.CALL_PHONE),
            CALL_PERMISSION_REQUEST_CODE
        )
    }

    private fun makePhoneCall(phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:$phoneNumber"))
        if (callIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(callIntent)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, make the phone call
                val phoneNumber = binding.editTextPhoneNumber.text.toString()
                if (phoneNumber.isNotEmpty()) {
                    makePhoneCall(phoneNumber)
                }
            } else {
                // Permission denied, show a message or take appropriate action
                Toast.makeText(
                    requireContext(),
                    "Permission denied. Cannot make a phone call.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CallViewModel::class.java)
        // TODO: Use the ViewModel
    }

}