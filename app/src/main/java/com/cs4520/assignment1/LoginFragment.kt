package com.cs4520.assignment1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("LoginFragment", "onCreateView")
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val loginButton = view.findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            onLoginButtonPressed()
        }

        return view
    }

    // use the action 'action_loginFragment_to_productListFragment' to navigate to the product list
    // if username and password both equal "admin", navigate to the product list
    fun onLoginButtonPressed() {
        val username = view?.findViewById<EditText>(R.id.usernameEditText)?.text.toString()
        val password = view?.findViewById<EditText>(R.id.passwordEditText)?.text.toString()

        Log.d("LoginFragment", "onLoginButtonPressed")

        if (username == "admin" && password == "admin") {
            // clear the fields before navigating to the product list
            view?.findViewById<EditText>(R.id.usernameEditText)?.setText("")
            view?.findViewById<EditText>(R.id.passwordEditText)?.setText("")
            findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
        } else {
            // display a toast message to the user
            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }
}
