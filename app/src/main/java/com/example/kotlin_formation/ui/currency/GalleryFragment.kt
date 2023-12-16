package com.example.kotlin_formation.ui.currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_formation.databinding.FragmentCurrencyBinding

class GalleryFragment : Fragment() {

    private var res: Int = 0
    private var _binding: FragmentCurrencyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentCurrencyBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val radiogroup: RadioGroup = binding.radioGroup
        val sum: RadioButton = binding.Sum
        val square: RadioButton = binding.Square
        val calcul: Button = binding.calcul
        val result: EditText = binding.result
        val value1: EditText = binding.value1
        val value2: EditText = binding.value2

        calcul.setOnClickListener {
            val selectedOptionId: Int = radiogroup.checkedRadioButtonId

            if (selectedOptionId != -1) {
                val selectedRadioButton: RadioButton = root.findViewById(selectedOptionId)
                var valueButton = selectedRadioButton.text.toString()
                val num1: String = value1.text.toString()
                val num2: String = value2.text.toString()
                val n1: Int = num1.toInt()
                val n2: Int = num2.toInt()

                if (valueButton == "Sum") {
                    res = n1 + n2
                } else if (valueButton == "Square") {
                    res = n2 * n1
                }

                valueButton = res.toString()
                result.setText(valueButton)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}