# GeoNotesTeaching (Java 21)

Proyecto docente para practicar Java «clásico + moderno» (records, sealed classes, text blocks, switch expression, pattern matching con record patterns) con una pequeña app de notas geolocalizadas en consola.

Incluye Gradle Wrapper para facilitar la ejecución sin instalar Gradle.

## Descripción general
- Aplicación CLI: crea, lista, filtra y exporta notas con ubicación (lat/lon).
- Demuestra características de Java 11→21: records, sealed, text blocks, switch moderno, pattern matching y record patterns.
- Exportación de ejemplo a JSON usando Text Blocks.

## Pila técnica
- Lenguaje: Java 21 (toolchain de Gradle)
- Build: Gradle con plugins `java` y `application`
- Gestor de dependencias: Gradle (repositorio Maven Central)
- Punto de entrada: `com.example.geonotesteaching.GeoNotes` (configurado en `application.mainClass`)

## Requisitos
- JDK 21 (o superior con toolchain de Gradle)
- Conexión a internet para resolver dependencias desde Maven Central
- SO: Linux, macOS o Windows

## Configuración y ejecución
- Clonar o descargar el repositorio.
- Terminal (Unix/macOS):
  - Dar permisos si hace falta: `chmod +x ./gradlew`
  - Ejecutar en modo interactivo (CLI):
    - `./gradlew run`
  - Ejecutar el flujo de ejemplos (siembra datos y exporta JSON):
    - `./gradlew examples`
  - Alternativa con argumentos a `run`:
    - `./gradlew run --args="examples"`
- Windows (PowerShell):
  - `./gradlew.bat run`
  - `./gradlew.bat examples`

## Scripts y tareas Gradle
- `run`: ejecuta la aplicación principal (`GeoNotes`).
- `examples`: tarea personalizada que lanza `GeoNotes` con el argumento `examples` para pre-cargar datos y exportar.
- `build`: compila y genera artefactos (incluye `jar`).
- `clean`: limpia artefactos de compilación.

## Variables de entorno
- No se requieren variables de entorno obligatorias.
- Opcionales:
  - `JAVA_HOME`: ruta a JDK 21 si tu entorno lo necesita.
  - `GRADLE_OPTS`: ajustes de memoria o proxy si fuese necesario.

## Pruebas
Actualmente no hay un módulo de tests en el repositorio.
- TODO: añadir pruebas unitarias (por ejemplo, para `GeoPoint`, `Match.isInArea(…)`, y `Timeline`).
- Cuando existan, se ejecutarán con: `./gradlew test`.

## Estructura del proyecto (resumen)
- `build.gradle`: configuración de Gradle (Java 21, plugin application, tarea `examples`).
- `settings.gradle`: nombre del proyecto.
- `gradlew`, `gradlew.bat`, `gradle/wrapper/*`: wrapper de Gradle.
- `src/main/java/com/example/geonotesteaching/`:
  - `GeoNotes.java`: clase principal y CLI.
  - `GeoPoint.java`, `GeoArea.java`: tipos de dominio (records); utilidades de geolocalización en `Match.java`.
  - `Note.java`, `Timeline.java`: modelo de notas y timeline (incluye render a JSON con Text Blocks).
  - `Attachment` (sealed) y subtipos: `Photo`, `Audio`, `Link`.
  - Exportadores: `Exporter`, `AbstractExporter`, `JsonExporter`.

## Licencia
No se ha encontrado un archivo de licencia en el repositorio.
- TODO: añadir `LICENSE` (por ejemplo, MIT, Apache-2.0 o la que corresponda).

## Créditos y estado
- Proyecto educativo para uso en clase. Si detectas errores o quieres mejorar el material, abre un issue o PR.