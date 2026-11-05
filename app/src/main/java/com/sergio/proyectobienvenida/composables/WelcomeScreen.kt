package com.sergio.proyectobienvenida.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergio.proyectobienvenida.R
import com.sergio.proyectobienvenida.ui.theme.ProyectoBienvenidaTheme


@Composable
fun WelcomeScreen(
    nombre: String,
    onCerrarSesion: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(32.dp))

        LogoCircular(icono = R.drawable.ic_lock_open, tamanoIcono = 32.dp)

        Spacer(Modifier.weight(1f))

        InsigniaCheck(modifier = Modifier.size(200.dp))

        Spacer(Modifier.height(32.dp))
        Text(
            text = "¡Hola, $nombre!",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Has iniciado sesión correctamente",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.weight(1f))

        Button(
            onClick = onCerrarSesion,
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
        ) {
            Text("Cerrar sesión", style = MaterialTheme.typography.titleMedium)
        }
        Spacer(Modifier.height(24.dp))
    }
}


@Composable
private fun InsigniaCheck(modifier: Modifier = Modifier) {

    val rojo = MaterialTheme.colorScheme.primary
    val rosaSuave = MaterialTheme.colorScheme.primaryContainer
    val blanco = MaterialTheme.colorScheme.onPrimary

    Canvas(modifier = modifier) {
        val centro = Offset(size.width / 2, size.height / 2)
        val radio = size.minDimension / 2


        drawCircle(rosaSuave.copy(alpha = 0.4f), radio, centro)
        drawCircle(rosaSuave, radio * 0.75f, centro)
        drawCircle(rojo, radio * 0.5f, centro)


        val check = Path().apply {
            moveTo(centro.x - radio * 0.22f, centro.y)
            lineTo(centro.x - radio * 0.05f, centro.y + radio * 0.17f)
            lineTo(centro.x + radio * 0.24f, centro.y - radio * 0.15f)
        }
        drawPath(
            path = check,
            color = blanco,
            style = Stroke(
                width = radio * 0.08f,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round,
            ),
        )
    }
}

@Preview(name = "Galaxy S24", showBackground = true, widthDp = 360, heightDp = 780)
@Composable
private fun WelcomeScreenPreview() {
    ProyectoBienvenidaTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            WelcomeScreen(nombre = "Sergio", onCerrarSesion = {})
        }
    }
}