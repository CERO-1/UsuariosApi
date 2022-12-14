package com.juansergio.usersapijs.presentation.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.juansergio.usersapijs.databinding.ActivityLoginBinding
import com.juansergio.usersapijs.presentation.viewmodel.LoginviewModel

class Login : AppCompatActivity() {
    private val viewmodel: LoginviewModel by viewModels()

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignIn.setOnClickListener {
            viewmodel.getLoginUser(binding.atvEmailLog.text.toString())
        }
        viewmodel.progressState.observe(this) { show ->
            binding.progress.isVisible = show
        }
        viewmodel.stateINFO.observe(this) {
            if (binding.atvEmailLog.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Ingrese un Id", Toast.LENGTH_SHORT).show()
                binding.atvEmailLog.error = "Ingrese un Id"
            } else {
                if (it.size == 1) {
                    binding.progress.isInvisible = true
                    var intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    binding.progress.isInvisible = true
                    Toast.makeText(this, "EL id ingresado no existe", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
