package com.sergio.proyectobienvenida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sergio.proyectobienvenida.composables.LoginScreen
import com.sergio.proyectobienvenida.composables.WelcomeScreen
import com.sergio.proyectobienvenida.ui.theme.ProyectoBienvenidaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoBienvenidaTheme {
                App()
            }
        }
    }
}


@Composable
private fun App() {
    var nombreUsuario by rememberSaveable { mutableStateOf<String?>(null) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        val nombre = nombreUsuario

        if (nombre == null) {
            LoginScreen(
                onLoginCorrecto = { nombreUsuario = it },
                modifier = modifier,
            )
        } else {
            WelcomeScreen(
                nombre = nombre,
                onCerrarSesion = { nombreUsuario = null },
                modifier = modifier,
            )
        }
    }
}