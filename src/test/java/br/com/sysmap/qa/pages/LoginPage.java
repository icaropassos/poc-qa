package br.com.sysmap.qa.pages;

import org.openqa.selenium.By;

import br.com.sysmap.qa.enums.StatusEsperas;
import br.com.sysmap.qa.selenium.BasePage;

public class LoginPage extends BasePage {

	
	private By _avancadas = By.xpath("//*[@id='details-button']");	
	
	//Locators
    private By _cpfEmailouCodigoDeConsultora = By.xpath("//*[@id='username']");
    private By _senha = By.xpath("//*[@id='password']");
    private By _entrar = By.xpath("//*[@id='myForm']/button");
    private By _primeiroAcesso = By.xpath("//*[@id='root']/main/div/div/button");
    private By _lembrarMe = By.xpath("//*[@id='myForm']/div[3]/div/label");
    private By _esqueciMinhaSenha = By.xpath("//*[@id='myForm']/div[3]/a");
    private By _queroSerConsultoraDeBeleza = By.xpath("//*[@id='root']/main/div/div/a");
    
    
    public void LogarUsuario( String usuario,String senha) {
    clicar(_avancadas);
    clicarPorLinkTexto("Ir para pedidosqxx.natura.net (não seguro)");    
    escrever(_cpfEmailouCodigoDeConsultora, usuario);
    escrever(_senha, senha);
    clicar(_entrar);
   }    
    
}
