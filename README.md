# CooperachApp (Dividir la cuenta) - Proyecto Android

Este proyecto es una aplicación android desarrollada usando Kotlin y Jetpack compose, tiene el propósito simple de dividir una cuenta de restaurante. Puedes descargarla [aqui](https://play.google.com/store/apps/details?id=me.kristianconk.cooperachapp)

## Overview

La aplicación :

*   Muestra un formulario simple para el total de la cuenta, cantidad de personas y propina.
*   Permite compartir el resultado del calculo a cualquier otra aplicación de mensajería.
*   Permite guardar el cálculo en un historial.

## Technologias Usadas

*   **Kotlin:** Lenguaje de programación principal.
*   **Jetpack Compose:** Para la interfaz gráfica.
*   **AndroidX Libraries:** Para componentes escenciales.
*   **Room**: Para persistencia de datos.
*   **Koin** Para inyeccion de dependencias.

## Getting Started

1.  **Prerequisitos:**
    *   Android Studio instalado.
    *   Android SDK instalado.
    *   Dispositivo físico o emulador.

2.  **Clonar el repositorio:**

   ```bash
   git clone https://github.com/newkristian/cooperachapp.git
   ```

4.  **Construir el pproyecto:**
    *   En Android Studio, ve a "Build" -> "Make Project" o usa el botón "Build" de la barra de herramientas.
    *   Alternativamente, puedes construir el proyecto desde la linea de comandos:
    ```bash
    ./gradlew build
    ```

5. **Ejecutar el proyecto:**
    * Click en el botón "run" de Android Studio.
    * Elige el dispositivo donde quieres ejecutar el proyecto.

## Problemas conocidos

* Los campos de texto no están valiados al 100% puede fallar si se intrducen datos no numéricos.
* No hay un diseño para tabletas, el contenido se va a estirar.

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras algún error o tienes sugerencias de mejoras, sientete libre de abrir un issue o enviar un pull request.

## Licencia

[MIT License]
