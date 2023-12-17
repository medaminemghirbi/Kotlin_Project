package com.example.kotlin_formation.ui.countries

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_formation.databinding.FragmentCountriesBinding
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class SlideshowFragment : Fragment() {

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentCountriesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Read JSON file
        val jsonString = loadJSONFromAsset("countries.json")

        // Parse JSON
        val listcities = parseJSON(jsonString)
        //val listcities = listOf("sousse", "sfax", "tunis")
        val adp = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listcities)

        binding.listeVille.adapter = adp

        binding.listeVille.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.textView2.text = listcities[position]

                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.fr/search?q=" + listcities[position])
                startActivity(intent)
                Toast.makeText(requireContext(),"clicked item is "+ listcities[position], Toast.LENGTH_LONG)
            }
        }

        return root
    }
    private fun loadJSONFromAsset(fileName: String): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = requireActivity().assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }
    private fun parseJSON(jsonString: String?): List<String> {
        val listcities = mutableListOf<String>()
        try {
            val jsonObject = JSONObject(jsonString)

            // Iterate through the keys and get corresponding values
            val keys = jsonObject.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                val value = jsonObject.getString(key)
                listcities.add(value)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return listcities
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
