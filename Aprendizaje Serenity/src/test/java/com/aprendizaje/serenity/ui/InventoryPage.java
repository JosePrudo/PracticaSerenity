package com.aprendizaje.serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class InventoryPage extends PageObject {

    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By INVENTORY_ITEMS = By.cssSelector(".inventory_item");

    public String title() {
        return $(PAGE_TITLE).waitUntilVisible().getText();
    }

    public int numberOfProducts() {
        return findAll(INVENTORY_ITEMS).size();
    }
}
