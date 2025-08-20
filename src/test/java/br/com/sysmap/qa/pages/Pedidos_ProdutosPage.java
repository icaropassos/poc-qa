package br.com.sysmap.qa.pages;

import org.openqa.selenium.By;
br.com.sysmap.qa.selenium.BasePage;

public class Pedidos_ProdutosPage extends BasePage {

 // TODO: substituir por seletores est���veis (id, data-test-id)
 private final By codigoInput = By.id("TODO");
 private final By quantidadeInput = By.id("TODO");
 private final By adicionarButton = By.id("TODO");
 private final By cdAlocadoLabel = By.id("TODO");

 public void preencherCodigoProduto(String codigo) {
 escrever(codigoInput, codigo);
 }

 public void preencherQuantidadeProduto(String quantidade) {
 escrever(quantidadeInput, quantidade);
 }

 public void adicionarProduto() {
 clicar(adicionarButton);
 }

 public String obterCdAlocado() {
 // TODO: retornar o CD alocado exibido na UI
 return obterTexto(cdAlocadoLabel);
 }
}