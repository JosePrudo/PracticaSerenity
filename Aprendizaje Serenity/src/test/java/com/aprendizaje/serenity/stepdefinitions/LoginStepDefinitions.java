package com.aprendizaje.serenity.stepdefinitions;

import com.aprendizaje.serenity.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class LoginStepDefinitions {

    @Steps
    LoginSteps login;

    private String username;

    @Dado("que {word} está en la página de login")
    public void estaEnLaPaginaDeLogin(String username) {
        this.username = username;
        login.openLoginPage();
    }

    @Cuando("inicia sesión con la contraseña {string}")
    public void iniciaSesionConLaContrasena(String password) {
        login.loginAs(username, password);
    }

    @Entonces("debería ver el catálogo de productos")
    public void deberiaVerElCatalogoDeProductos() {
        login.shouldSeeProductCatalog();
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String mensaje) {
        login.shouldSeeErrorMessage(mensaje);
    }
}
