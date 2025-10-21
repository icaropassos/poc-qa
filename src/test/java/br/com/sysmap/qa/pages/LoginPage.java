package br.com.sysmap.qa.pages;

import org.openqa.selenium.By;
import br.com.sysmap.qa.selenium.BasePage;

public class LoginPage extends BasePage {

    // TODO: substituir por seletores estáveis (id, data-test-id)
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    public void logarUsuario(String usuario, String senha) {
        escrever(usernameInput, usuario);
        escrever(passwordInput, senha);
        clicar(loginButton);
    }
}
