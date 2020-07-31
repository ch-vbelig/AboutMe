package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Belig Chimitov")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickName(it)
//        }
        binding.doneButton.setOnClickListener{
            addNickName(it)
        }
    }

    fun addNickName(view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nickTextview = findViewById<TextView>(R.id.nickname_text)
//
//        nickTextview.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nickTextview.visibility = View.VISIBLE

//        binding.nicknameText.text = binding.nicknameEdit.text
//        binding.nicknameEdit.visibility = View.GONE
//        binding.doneButton.visibility = View.GONE
//        binding.nicknameText.visibility = View.VISIBLE

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            //nicknameText.text = nicknameEdit.text
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}