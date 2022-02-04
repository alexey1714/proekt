package com.example.proga.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proga.databinding.ActivityChatBinding
import com.example.proga.databinding.ActivityMainBinding

class ChatActivity : AppCompatActivity() {
    lateinit var bindingC : ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingC = ActivityChatBinding.inflate(layoutInflater)
        setContentView(bindingC.root)
    }
}