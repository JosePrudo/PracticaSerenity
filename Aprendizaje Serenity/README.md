# Aprendizaje Serenity

## Java runtime

Use **Java 25 LTS** to run Maven and the test JVM. The runtime pinned in
`.java-version` is **Oracle JDK 25.0.5.0.2**, verified on 2026-10-24 as
`25.0.5.0.2+1-LTS-2` using `java -version`.

Authoritative sources:

- [Oracle Java support roadmap](https://www.oracle.com/java/technologies/java-se-support-roadmap.html):
  Java 25 is the latest LTS release.
- [Oracle JDK downloads](https://www.oracle.com/java/technologies/downloads/):
  the Windows x64 Java 25 archive supplies this runtime.
- [Java 25.0.5 release notes](https://www.oracle.com/java/technologies/javase/25-0-5-relnotes.html):
  the October 2026 Java 25 update.

`.java-version` is a version-manager hint; Maven does not read it automatically.
Select the JDK explicitly in your shell or IDE. For the user-local installation
used during this upgrade, run the following from this project directory:

```powershell
$env:JAVA_HOME = "$env:USERPROFILE\.jdks\jdk-25.0.5.0.2"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
java -version
mvn -version
mvn -q clean test-compile
mvn -q clean test
```

If Maven is not on `PATH`, use an installed Maven 3.9.x executable. Validation
used Maven 3.9.16 bundled with IntelliJ IDEA. No project Maven wrapper exists.
Set the IDE project SDK and Maven runner JDK to the same Java 25 installation.
These shell settings affect only the current session.

The compiler release remains **21** deliberately: the runtime upgrade does not
change the source language or bytecode baseline.

## Dependencias de automatizacion

Las dependencias se declaran con alcance `test` en [pom.xml](pom.xml).
Maven descarga los JAR a su repositorio local.

| Libreria | Version | Uso |
|----------|---------|-----|
| Serenity BDD y Serenity REST Assured | 4.2.34 | Pruebas web, API y reportes |
| Selenium | 4.33.0 | Automatizacion del navegador |
| Cucumber | 7.22.2 | Escenarios BDD |
| JUnit Jupiter | 5.13.0 | Pruebas con JUnit Platform |
| AssertJ | 3.26.3 | Aserciones |
| SLF4J Simple | 2.0.16 | Registro de eventos |
| Mockito y extension JUnit Jupiter | 5.24.0 | Mocks |
| Apache POI | 6.0.0 | Lectura y escritura de Excel |
| Datafaker | 2.7.0 | Datos ficticios |
| Awaitility | 4.3.0 | Esperas asincronas |

El bloqueo anterior de `serenity-bom:4.2.34` se corrige usando versiones
explicitas de Serenity y los BOM publicados de Selenium, Cucumber y JUnit.
Estas familias usan las versiones de referencia de Serenity 4.2.34.
Mockito se alinea mediante su BOM y ambos modulos de Byte Buddy comparten
una version explicita. Commons IO y
Commons Compress se gestionan con las versiones requeridas por POI para evitar
que las versiones transitivas de Serenity las reemplacen.

Descargar las dependencias y plugins y compilar las pruebas sin ejecutarlas:

```powershell
mvn -B -ntp test-compile dependency:resolve dependency:resolve-plugins
```

La suite se ejecuta mediante Failsafe. Para ejecutar los escenarios web y
generar los reportes, usar:

```powershell
mvn -B -ntp verify -Dheadless.mode=true
```

`mvn test` no ejecuta la suite `CucumberTestSuite` configurada en Failsafe.
Las pruebas web requieren acceso al sitio configurado en
[serenity.conf](src/test/resources/serenity.conf), Chrome y el controlador
local `drivers\chromedriver.exe` compatible con la compilacion del navegador.
