# language: es
@login
Característica: Inicio de sesión en SauceDemo
  Como usuario registrado
  Quiero iniciar sesión en la tienda
  Para poder consultar el catálogo de productos

  Esquema del escenario: Inicio de sesión con credenciales válidas
    Dado que <usuario> está en la página de login
    Cuando inicia sesión con la contraseña "<password>"
    Entonces debería ver el catálogo de productos

    Ejemplos:
      | usuario            | password     |
      | standard_user      | secret_sauce |
      | problem_user       | secret_sauce |

  Escenario: Inicio de sesión con credenciales inválidas
    Dado que usuario_invalido está en la página de login
    Cuando inicia sesión con la contraseña "clave_erronea"
    Entonces debería ver el mensaje de error "Username and password do not match any user in this service"
