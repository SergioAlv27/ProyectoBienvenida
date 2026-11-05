# 🔐 ProyectoBienvenida — Login y Bienvenida con Jetpack Compose

App Android hecha **100 % en Jetpack Compose** con **Material Design 3**. Tiene dos pantallas: un **Login** con validación y una pantalla de **Bienvenida** que recibe el nombre del usuario.

> Tarea individual · 2.º DAM · Programación multimedia y dispositivos móviles
> Autor: **Sergio Álvarez**

---

## 📱 Funcionalidades

**Pantalla 1 — Login**
- Campos de **correo** y **contraseña** con esquinas redondeadas.
- Botón del **ojo** para mostrar u ocultar la contraseña.
- **Validación** contra datos de prueba:
  - Si los datos son incorrectos, los campos se ponen en rojo y aparece el mensaje *"⚠ El correo o la contraseña no son correctos"*.
  - Al volver a escribir, el error desaparece.
- Botón tipo **píldora** "Entrar".
- El estado se conserva **al girar el móvil**.

**Pantalla 2 — Bienvenida**
- Recibe el **nombre del usuario como parámetro** y lo muestra en *"¡Hola, Sergio!"*.
- **Ilustración propia dibujada con Canvas**: insignia con ondas y marca de verificación.
- Botón **Cerrar sesión**, que vuelve al Login con el formulario vacío.

## 🔑 Datos de prueba

| Campo | Valor |
|---|---|
| Correo | `sergio@gmail.com` |
| Contraseña | `1234` |
| Nombre mostrado | `Sergio` |

Están definidos como constantes al principio de `LoginScreen.kt`.

## 🛠️ Tecnologías

- Kotlin
- Jetpack Compose + Material 3
- Android Studio · Gradle (Kotlin DSL)
- SDK mínimo: API 26 (Android 8.0)
- Sin XML de layouts, sin librería de navegación y sin ViewModel: solo **estado + funciones composables**

## 📂 Estructura del proyecto

```
app/src/main/java/com/sergio/proyectobienvenida
├── MainActivity.kt        → decide QUÉ pantalla se ve (estado nombreUsuario)
├── composables
│   ├── LogoCircular.kt    → componente reutilizable (círculo + icono)
│   ├── LoginScreen.kt     → pantalla 1: login con validación
│   └── WelcomeScreen.kt   → pantalla 2: bienvenida + dibujo con Canvas
└── ui/theme
    ├── Color.kt           → paleta roja de Material 3
    ├── Theme.kt           → ColorScheme (sin color dinámico)
    └── Type.kt            → tipografía (Roboto)

app/src/main/res/drawable
└── ic_lock · ic_lock_open · ic_visibility · ic_visibility_off
```

## 🔁 Cómo funciona la navegación

En Compose no se "abren" pantallas: **se cambia un estado y Compose dibuja la pantalla que toca**.

```
MainActivity
└── App()  ← guarda UN estado: nombreUsuario
    ├── nombreUsuario == null  →  LoginScreen
    │       └── acierta → onLoginCorrecto(nombre) → nombreUsuario = nombre
    └── nombreUsuario != null  →  WelcomeScreen(nombre)
            └── Cerrar sesión → onCerrarSesion() → nombreUsuario = null
```

> **El estado baja como parámetro, los eventos suben como funciones.**

## 🎨 Diseño

- Paleta roja de Material 3 (`primary #C62828`, `surface #FFF8F7`…). Los mismos tokens están definidos como variables en el diseño.
- Todos los colores y textos se leen de `MaterialTheme.colorScheme` y `MaterialTheme.typography`; no hay valores sueltos en las pantallas.
- Como el color principal es rojo, el error lleva **símbolo y texto** para no confundirse con un campo normal (accesibilidad).
- Diseño en Figma: _[pega aquí el enlace de Figma]_

## ▶️ Cómo ejecutarlo

1. Clona el repositorio:
   ```bash
   git clone https://github.com/TU_USUARIO/Alvarez_Sergio_Login_Compose.git
   ```
2. Ábrelo con **Android Studio** y espera a que Gradle sincronice.
3. Elige un emulador (recomendado API 35) o un móvil real.
4. Pulsa **▶ Run 'app'**.

## 📸 Capturas

| Login | Error | Bienvenida |
|---|---|---|
| _(captura)_ | _(captura)_ | _(captura)_ |
