package br.com.sysmap.qa.pages;

import org.openqa.selenium.By;

import br.com.sysmap.qa.selenium.BasePage;

public class AvisosImportantesPage extends BasePage  {

	//Locators
    private By _iniciarPedido = By.xpath("//*[@id='pedidoRecuperado_iniciarPedidoButton']");
    private By _pendenciasIniciarPedido = By.xpath("//*[@id='pendenciaNatura_iniciarPedidoButton']");
    private By _confirmaIniciarNovoPedidoExcluirPedidoRecuperado_sim = By.xpath("/html/body/div[6]/div/div/div[2]/div/nav/button[2]");
    private By _confirmaIniciarNovoPedidoExcluirPedidoRecuperado_nao = By.xpath("/html/body/div[6]/div/div/div[2]/div/nav/button[1]");
    
    
    public void IniciarPedido() {
        clicar(_iniciarPedido); 
        clicar(_confirmaIniciarNovoPedidoExcluirPedidoRecuperado_sim);
        clicar(_pendenciasIniciarPedido);
    }
}
