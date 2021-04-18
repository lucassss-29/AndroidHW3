package com.example.week3

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivitySignUpBinding
import java.util.regex.Matcher
import java.util.regex.Pattern


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    public lateinit var viewModel : MainViewModel
    public lateinit var viewModelFactory : MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModelFactory = MainViewModelFactory("","","","")
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        binding.apply {
            buttonLogIn.setOnClickListener{
                if(!isEmailValid(etSignupEmail.text.toString().trim())&&!isValidPassword(editTextPassword.text.toString().trim())){
                    Toast.makeText(this@SignUpActivity, "Your Email and password is invalid. Please try again!", Toast.LENGTH_SHORT).show()
                }
                else if(!isEmailValid(etSignupEmail.text.toString().trim())) {
                    Toast.makeText(this@SignUpActivity, "Your Email is invalid. Please try again!", Toast.LENGTH_SHORT).show()
                }else if(!isValidPassword(editTextPassword.text.toString().trim())) {
                    Toast.makeText(this@SignUpActivity, "Your Password is invalid. Please try again!", Toast.LENGTH_SHORT).show()
                }else{
                    Singleton.instance!!.userName = etSignupUsername.text.toString().trim()
                    Singleton.instance!!.password = editTextPassword.text.toString()
                    Singleton.instance!!.email = etSignupEmail.text.toString().trim()
                    val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
    fun isEmailValid(email: CharSequence?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*()])(?=\\S+$).{8,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }
}