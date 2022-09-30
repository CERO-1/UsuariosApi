package com.juansergio.usersapijs.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.juansergio.usersapijs.data.model.UsuariosItem
import com.juansergio.usersapijs.databinding.ActivityMainBinding
import com.juansergio.usersapijs.presentation.view.adapters.UsersAdapter
import com.juansergio.usersapijs.presentation.viewmodel.UserviewModel

class MainActivity : AppCompatActivity(), ClickListener {
    private val viewmodel: UserviewModel by viewModels()

    lateinit var mAdapter: UsersAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        viewmodel.getAllUser()
        viewmodel.progressState.observe(this) { show ->
            binding.contenedor.progress.isVisible = show
        }

        mAdapter = UsersAdapter(this)
        binding.contenedor.recyclerusers.layoutManager = LinearLayoutManager(this)
        binding.contenedor.recyclerusers.adapter = mAdapter
        viewmodel.stateINFO.observe(this) {
                listadeusuarios ->
            if (listadeusuarios != null) {
                binding.contenedor.progress.isInvisible = true
                binding.contenedor.recyclerusers.visibility = View.VISIBLE
                mAdapter.setData(listadeusuarios as ArrayList<UsuariosItem>)
            } else {
                showToast("Ha ocurrido un error")
            }
        }
    }
    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    override fun itemSelectw(data: UsuariosItem) {
    }
}
interface ClickListener {
    fun itemSelectw(data: UsuariosItem)
}
