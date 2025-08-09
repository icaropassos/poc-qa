package br.com.sysmap.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import br.com.sysmap.qa.pages.AvisosImportantesPage;
import br.com.sysmap.qa.pages.LoginPage;
import br.com.sysmap.qa.pages.Pedidos_ProdutosPage;
import br.com.sysmap.qa.selenium.DriverFactory;
import br.com.sysmap.qa.utils.Utils;

public class AdicionarProdutoCarrinho_Step {

	
    LoginPage login = new LoginPage();
    AvisosImportantesPage avisos = new AvisosImportantesPage();
    Pedidos_ProdutosPage pedidosProdutos = new Pedidos_ProdutosPage();
    
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {           
            System.out.println("Scenario failed: " + scenario.getName());
        }
        if (DriverFactory.getDriver()!= null) {
        	DriverFactory.killDriver();
            System.out.println("WebDriver quit after scenario: " + scenario.getName());
        }
    }	
			 
	@Dado("que estou no Capta")
	public void que_estou_no_capta() {
		assertTrue(true);
	}

	@Dado("acesso com uma consultora válida")
	public void acesso_com_uma_consultora_válida() {
		login.LogarUsuario(Utils.getConfiguracao("usuario.consultoraValida"),Utils.getConfiguracao("usuario.senhaconsultoraValida"));
	}

	@Quando("estou na tela do carrinho do capta")
	public void estou_na_tela_do_carrinho_do_capta() {
		avisos.IniciarPedido();
	}

	@Quando("insiro o código do produto {string}")
	public void insiro_o_código_do_produto(String string) {
		pedidosProdutos.PreencherCodidoProduto(string);
	}

	@Quando("insiro a quantidade {string} para o produto")
	public void insiro_a_quantidade_para_o_produto(String string) {
		pedidosProdutos.PreencherQuantidadeProduto(string);
	}

	@Quando("clico no botão adicionar")
	public void clico_no_botão_adicionar() {
		pedidosProdutos.AdicionarProduto();
	}

	@Então("devo visualizar que o produto foi adicionado no carrinho com sucesso")
	public void devo_visualizar_que_o_produto_foi_adicionado_no_carrinho_com_sucesso() {
		String produtoAdicionado="ESSENCIAL DEO PARFUM FEM 100ML 2020";
		assertEquals(produtoAdicionado, pedidosProdutos.VerificarProdutoAdicionado(produtoAdicionado));		
	}

	@Então("que a pontuação da marca é > {int}")
	public void que_a_pontuação_da_marca_é(Integer int1) {				
         if(pedidosProdutos.VerificarPontuacaoAtual() > 0)
        	 assertTrue(true);
         else
        	 assertTrue(false);
	}

}
