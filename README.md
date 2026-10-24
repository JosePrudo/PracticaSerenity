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
