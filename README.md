# PracticaSerenity
Practica de Serenity BDD

## Proyecto de automatizacion

El proyecto Maven se encuentra en [Aprendizaje Serenity](Aprendizaje%20Serenity).
Sus dependencias, requisitos de Java y comandos estan documentados en el
[README del proyecto](Aprendizaje%20Serenity/README.md).

Desde esa carpeta, descargar dependencias y compilar las pruebas:

```powershell
mvn -B -ntp test-compile
```

Para las pruebas web, instalar ChromeDriver compatible con Chrome en
`Aprendizaje Serenity\drivers\chromedriver.exe`. El controlador, los reportes
y los archivos compilados no se guardan en Git.

## Guardar cambios en GitHub desde VS Code

1. Abrir [PracticaSerenity.code-workspace](PracticaSerenity.code-workspace)
   desde **Archivo > Abrir espacio de trabajo desde archivo**. Asi se trabaja
   con este repositorio y no con la copia original del proyecto.
2. Abrir **Control de codigo fuente** con `Ctrl+Shift+G`.
3. Revisar los cambios y usar **+** para preparar solo los archivos deseados.
4. Escribir un mensaje descriptivo y seleccionar **Commit**.
5. Seleccionar **Sincronizar cambios** o **Push** para enviarlos a GitHub.
   Tambien se puede usar **Commit y Push** en el menu del boton de commit.

El destino es `origin`, repositorio `JosePrudo/PracticaSerenity`, rama `main`.
Un commit por si solo guarda los cambios localmente; el push los sube a GitHub.
La primera vez en otro equipo, iniciar sesion en GitHub si VS Code lo solicita.
