package br.com.sysmap.qa.pages;

import org.openqa.selenium.By;

import br.com.sysmap.qa.selenium.BasePage;

public class Pedidos_ProdutosPage  extends BasePage {
	
	//Locators
    private By _codigo = By.xpath("//*[@id='BuscaProduto0_textBoxCodigo']");
    private By _quantidade = By.xpath("//*[@id='BuscaProduto0_inputQuantidade']/input");
    private By _adicionar = By.xpath("//*[@id='BuscaProduto0_buttonAdicionar']");
    private By _totalPontos = By.xpath("//*[@id='main_pontuacaoEloCombinadoTotalPontosValor']");  
    
    public void PreencherCodidoProduto(String codigoProduto) {    
    	escrever(_codigo, codigoProduto);
    }
    
    public void PreencherQuantidadeProduto(String quantidadeProduto) {    
    	escrever(_quantidade, quantidadeProduto);
    }
    
    public void AdicionarProduto() {    
    	clicar(_adicionar);
    }
    
    public String VerificarProdutoAdicionado(String nomeProduto) {    
    	return  obterTexto(By.xpath("//*[contains(text(),'"+nomeProduto+"')]"));
    }
    
    public int VerificarPontuacaoAtual() {    
    	return  Integer.parseInt(obterTexto(_totalPontos));
    }
}
