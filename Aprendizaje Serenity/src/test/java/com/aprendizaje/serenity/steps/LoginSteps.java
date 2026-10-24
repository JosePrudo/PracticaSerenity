package com.aprendizaje.serenity.steps;

import com.aprendizaje.serenity.ui.InventoryPage;
import com.aprendizaje.serenity.ui.LoginPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Step("Abre la página de login")
    public void openLoginPage() {
        loginPage.open();
    }

    @Step("Inicia sesión como {0}")
    public void loginAs(String username, String password) {
        loginPage.loginAs(username, password);
    }

    @Step("Verifica que se muestra el catálogo de productos")
    public void shouldSeeProductCatalog() {
        assertThat(inventoryPage.title()).isEqualTo("Products");
        assertThat(inventoryPage.numberOfProducts()).isPositive();
    }

    @Step("Verifica el mensaje de error: {0}")
    public void shouldSeeErrorMessage(String expectedMessage) {
        assertThat(loginPage.errorMessage()).contains(expectedMessage);
    }
}
