package br.com.sysmap.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import static org.junit.Assert.assertEquals;
import br.com.sysmap.qa.pages.LoginPage;
import br.com.sysmap.qa.pages.CarrinhoPage;

public class AdicaoProdutoCarrinhoSteps {

    private final LoginPage loginPage = new LoginPage();
    private final CarrinhoPage carrinhoPage = new CarrinhoPage();

    @Dado("que estou autenticado no sistema")
    public void queEstouAutenticadoNoSistema() {
        // TODO: autenticar via LoginPage usando massa do ambiente
        // loginPage.logarUsuario(usuario, senha);
    }

    @Dado("que a consultora está na interface principal do carrinho de compras")
    public void queAConsultoraEstaNaInterfacePrincipalDoCarrinhoDeCompras() {
        // TODO: preparar estado (ex.: iniciar pedido)
        // carrinhoPage.iniciarPedido();
    }

    @Quando("ela insere o código do produto {string} no campo designado")
    public void elaInsereOCodigoDoProdutoNoCampoDesignado(String codigo) {
        // TODO: interações no carrinho
        // carrinhoPage.preencherCodigoProduto(codigo);
    }

    @Quando("insere a quantidade {int} no campo correspondente")
    public void insereAQuantidadeNoCampoCorrespondente(int quantidade) {
        // TODO: interações no carrinho
        // carrinhoPage.preencherQuantidadeProduto(String.valueOf(quantidade));
    }

    @Quando("clica no botão {string}")
    public void clicaNoBotao(String botao) {
        // TODO: interações no carrinho
        // carrinhoPage.clicarNoBotao(buscarBotaoByTexto(botao));
    }

    @Então("o sistema deve atualizar a lista do carrinho para exibir o novo item inserido")
    public void oSistemaDeveAtualizarAListaDoCarrinho_paraExibirONovoItemInserido() {
        // TODO: assertivas de negócio
        // assertEquals("Produto adicionado", carrinhoPage.obterMensagemDeSucesso());
    }
}
