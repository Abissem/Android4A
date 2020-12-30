package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.example.android4a.presentation.list.DisplayListActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess ->{
                    val intent = Intent(this, DisplayListActivity::class.java)
                    startActivity(intent)
                }
                    LoginError -> {
                        MaterialAlertDialogBuilder(this)
                            .setTitle("D'OH !")
                            .setMessage("Ton compte n'existe pas hihihi! Apporte moi une Duff ! (Indice: Appuie sur Sign up si tu n'as pas de compte")
                            .setPositiveButton("Ok") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                    }
            }
        })

        login_button.setOnClickListener {
            if (login_edit.text.toString().trim().isNotEmpty() && password_edit.text.toString().trim().isNotEmpty())
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString().trim())
            else{
                MaterialAlertDialogBuilder(this)
                        .setTitle("D'OH !")
                        .setMessage("Remplit avec tes informations. ")
                        .setPositiveButton("Ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
            }
        }

        create_account_button.setOnClickListener {
            if (login_edit.text.toString().trim().isNotEmpty() && password_edit.text.toString().trim().isNotEmpty())
                mainViewModel.onClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString().trim())
            else{
                MaterialAlertDialogBuilder(this)
                        .setTitle("D'OH !")
                        .setMessage("Remplit avec tes informations. ")
                        .setPositiveButton("Ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
            }
        }
    }
}