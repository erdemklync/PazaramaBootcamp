package com.ekalyoncu.secondweek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonSignUp: Button

    var email: String = ""
    var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.login_edit_text_email)
        editTextPassword = findViewById(R.id.login_edit_text_password)
        buttonLogin = findViewById(R.id.login_button_login)
        buttonSignUp = findViewById(R.id.login_button_sign_up)

        editTextEmail.addTextChangedListener(
            object:TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(editable: Editable?) {
                    email = editable.toString()
                }
            }
        )

        editTextPassword.addTextChangedListener(
            object:TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(editable: Editable?) {
                    // Her girilen karakterde değişkenin değerini günceller.
                    password = editable.toString()
                }
            }
        )

        buttonSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java) // Sonraki Activity için intent oluşturur.
            startActivity(intent) // Intenti çağırır.
        }

        buttonLogin.setOnClickListener {
            // Login düğmesine tıklayınca ekranda Toast message gösterir.
            Toast.makeText(this, "Email: $email, Password: $password", Toast.LENGTH_LONG).show()
        }

    }
}