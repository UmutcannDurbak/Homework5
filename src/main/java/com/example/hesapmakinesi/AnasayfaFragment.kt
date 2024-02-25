package com.example.hesapmakinesi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hesapmakinesi.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private var toplam: Int = 0
    private var secilenSayi: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmentü
        binding = FragmentAnasayfaBinding.inflate(inflater,container, false )

        binding.apply {
            sayi0.setOnClickListener { appendNumber(0) }
            sayi1.setOnClickListener { appendNumber(1) }
            sayi2.setOnClickListener { appendNumber(2) }
            sayi3.setOnClickListener { appendNumber(3) }
            sayi4.setOnClickListener { appendNumber(4) }
            sayi5.setOnClickListener { appendNumber(5) }
            sayi6.setOnClickListener { appendNumber(6) }
            sayi7.setOnClickListener { appendNumber(7) }
            sayi8.setOnClickListener { appendNumber(8) }
            sayi9.setOnClickListener { appendNumber(9) }
            toplamaIslemi.setOnClickListener { performAddition() }
            toplamaEsittir.setOnClickListener { showTotal() }
            sifirlaButton.setOnClickListener { reset() }
        }


        return binding.root
    }
    private fun appendNumber(number: Int) {
        // Get current text from Sonuç TextView
        val currentText = binding.toplamaSonuc.text.toString()
        // Append the number to the end
        val newText = "$currentText$number"
        // Set the updated text to Sonuç TextView
        binding.toplamaSonuc.text = newText

        // Parse the updated text to integer and store it

        secilenSayi = newText.toIntOrNull() ?: 0
    }

    private fun performAddition() {
        // Reset the text to be added
        toplam += secilenSayi

        secilenSayi = 0

        binding.toplamaSonuc.text = ""
    }

    private fun showTotal() {
        toplam += secilenSayi

        secilenSayi = 0
        // Display the total in Sonuç TextView
        binding.toplamaSonuc.text = toplam.toString()
    }

    private fun reset() {
        // Tüm değerleri sıfırla
        toplam = 0
        secilenSayi = 0
        binding.toplamaSonuc.text = ""
    }

}