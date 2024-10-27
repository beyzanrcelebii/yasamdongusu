package com.beyzanurcelebi.yasamdongusu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.beyzanurcelebi.yasamdongusu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        println("onCreate calistirildi")//kullanici daha gormuyor
    }

    override fun onStart() {//kullanıcı goruyor ama etkilesime gecemiyo .arayuz gozukuyor
        super.onStart()
        println("onStart calistirildi")
    }

    override fun onResume() { // kullanici artik uygulamayi gorur ve etkilesime gecebilir
        super.onResume()
        println("onResume calistirildi")
    }

    override fun onPause() {
        super.onPause()
        println("onPause calistirildi")
    }

    override fun onStop() {
        super.onStop()
        println("onStop calistirildi")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy calistirildi")
    }

    fun sonrakiSayfa(view : View){

        val intent = Intent(this,SecondActivity::class.java)
        val kullaniciGirdisi =binding.editText.text.toString() //1.sayfadaki kullanici girdisini 2.sayfaya iletme
        intent.putExtra("isim",kullaniciGirdisi)
        startActivity(intent)

       // finish() //2.sayfayi destroy eder
   //edit text'te(plain text) yazili olan seyi alma(kullanicidan girdi alma)
//   val kullaniciGirdisi =binding.editText.text.toString()
//  binding.textView.text = " ${kullaniciGirdisi}"
    }

}