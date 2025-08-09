package br.com.sysmap.qa.selenium;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.sysmap.qa.enums.StatusEsperas;

import static br.com.sysmap.qa.selenium.DriverFactory.getDriver;


public class BasePage {

private final int timeout = 20;
	
	/**** Interação com elementos *******/

	protected boolean elementoExiste(By by) {
		esperar(by, StatusEsperas.PRESENCA, timeout);
		Boolean existe = getDriver().findElements(by).size() > 0;
		return existe;
	}

	protected List<WebElement> obterElementos(By by) {
		esperar(by, StatusEsperas.PRESENCA, timeout);
		return getDriver().findElements(by);
	}

	protected List<WebElement> obterElementos(By by, StatusEsperas status) {
		esperar(by, status, timeout);
		return getDriver().findElements(by);
	}
	
	protected List<WebElement> obterElementosVisiveis(By by) {
		esperar(by, StatusEsperas.PRESENCA, timeout);
		List<WebElement> elementosVisiveis = getDriver().findElements(by).stream().filter(we -> we.isDisplayed())
				.collect(Collectors.toList());
		return elementosVisiveis;
	}
	
	protected List<WebElement> obterElementosVisiveis(By by, StatusEsperas status) {
		esperar(by, status);
		List<WebElement> elementosVisiveis = getDriver().findElements(by).stream().filter(we -> we.isDisplayed())
				.collect(Collectors.toList());
		return elementosVisiveis;
	}

	protected WebElement obterElemento(By by) {
		esperar(by, StatusEsperas.VISIBILIDADE);
		return getDriver().findElement(by);
	}
	

	protected WebElement obterElemento(By by, int indice) {
		return getDriver().findElements(by).get(indice);
	}
	
	protected WebElement obterElemento(By by, int indice, StatusEsperas status) {
		esperar(by, status, indice);
		return getDriver().findElements(by).get(indice);
	}

	protected WebElement obterElemento(By by, StatusEsperas status) {
		esperar(by, status);
		return getDriver().findElement(by);
	}

	/********* Interações campos text *******///

	protected void escrever(By by, String texto) {
		limparTexto(by);
		getDriver().findElement(by).sendKeys(texto);
	}
	
	protected void escreverWithAction(By by, String texto) {
		limparTexto(by);
		getDriver().findElement(by).sendKeys(texto + Keys.ENTER);
		
	}

	protected void moverMouse(By by) {
		Actions acao = new Actions(getDriver());
		acao.moveToElement(getDriver().findElement(by)).build().perform();
	}

	protected void clicaBotaoDireito(By by) {
		Actions acao = new Actions(getDriver()); 
		acao.contextClick().build().perform();
	}

	protected void clicar(By by) {
		esperar(by, StatusEsperas.CLICK);
		getDriver().findElement(by).click(); 
	}

	protected void clicar(By by, int indice) {
		esperar(by, StatusEsperas.CLICK, indice);
		getDriver().findElements(by).get(indice).click();
	}

	protected void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[contains(text(), '" + texto + "')]"));
	}

	protected void clicarPorTexto(String texto, int indice) {
		clicar(By.xpath("//*[contains(text(), '" + texto + "')]"), indice);
	}
	
	protected void clicarPorLinkTexto(String texto) {
			
		 WebElement link = getDriver().findElement(By.linkText(texto));
		 link.click();
	}
	

	/****** COMBOBOX ***************/

	protected void selecionarCombo(By byCombo, String valor) {
		esperar(byCombo, StatusEsperas.CLICK);
		Select selectBox = new Select(getDriver().findElement(byCombo));
		selectBox.selectByVisibleText(valor);
	}

	protected boolean isCheckSwitchMarcado(By by) {
		esperar(by, StatusEsperas.VISIBILIDADE);
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	protected String obterTexto(By by, int indice) {
		esperar(by, StatusEsperas.PRESENCA);
		return getDriver().findElements(by).get(indice).getText();
	}

	protected String obterTexto(By by) {
		esperar(by, StatusEsperas.PRESENCA);
		return getDriver().findElement(by).getText();
	}

	protected void limparTexto(By by) {
		esperar(by, StatusEsperas.VISIBILIDADE);
		// getDriver().findElement(by).click();
		getDriver().findElement(by).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	}

	/*******************
	 * Operações com Tabelas
	 *********************/

	protected int tabelaObterQuantidadeLinhas(By by) {
		WebElement WebElement = obterElemento(by, StatusEsperas.PRESENCA);
		List<WebElement> rows = WebElement.findElements(By.tagName("tr"));
		return rows.size();
	}

	protected String[] tabelaObterLinha(By by, int linha) {
		List<WebElement> rows = tabelaObterLinhas(by);
		List<WebElement> valoresColunas = rows.get(linha).findElements(By.tagName("td"));
		String retorno[] = new String[valoresColunas.size()];
		int i = 0;
		for (WebElement webElement : valoresColunas) {
			retorno[i++] = webElement.getText();
		}
		return retorno;
	}

	protected String[] tabelaObterCabecalho(By by) {
		List<WebElement> head = tabelaObterLinhas(by);
		List<WebElement> valoresColunas = head.get(0).findElements(By.tagName("th"));
		String retorno[] = new String[valoresColunas.size()];
		int i = 0;
		for (WebElement webElement : valoresColunas) {
			retorno[i++] = webElement.getText();
		}
		return retorno;
	}

	protected List<WebElement> tabelaObterLinhas(By by) {
		WebElement WebElement = obterElemento(by, StatusEsperas.VISIBILIDADE);
		List<WebElement> rows = WebElement.findElements(By.tagName("tr"));
		return rows;
	}

	protected void tabelaClicarBotao(By by, int linha, int coluna) {
		WebElement WebElement = obterElemento(by, StatusEsperas.PRESENCA);
		List<WebElement> rows = WebElement.findElements(By.tagName("tr"));
		List<WebElement> valoresColunas = rows.get(linha).findElements(By.tagName("td"));
		WebElement element = valoresColunas.get(coluna).findElement(By.tagName("button"));
		element.click();
	}

	protected void tabelaClicarLink(By by, int linha, int coluna) {
		WebElement WebElement = obterElemento(by, StatusEsperas.PRESENCA);
		List<WebElement> rows = WebElement.findElements(By.tagName("tr"));
		List<WebElement> valoresColunas = rows.get(linha).findElements(By.tagName("td"));
		WebElement element = valoresColunas.get(coluna).findElement(By.tagName("a"));
		element.click();
	}
	

	/***************
	 * Interação com alertas
	 ****************/
	
	protected Alert mudarParaAlerta() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void alterarParaAlerta() {
		getDriver().switchTo().alert();
	}

	protected void aceitarAlerta() {
		mudarParaAlerta().accept();
	}
	
	protected String obterTextoAlerta() {
		return mudarParaAlerta().getText();
	}

	protected void sairAlerta() {
		getDriver().switchTo().defaultContent();
	}

	/***************
	 * ESPERAS
	 ****************/

	private void esperar(By by, StatusEsperas tipoEspera, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
		try {
			switch (tipoEspera) {
			case PRESENCA:
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
				break;
			case CLICK:
				wait.until(ExpectedConditions.elementToBeClickable(by));
				break;
			default:
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				break;
			}
		} catch (NoSuchElementException e) {
			throw e;
		}
	}
	
	protected void esperar(By by, StatusEsperas tipoEspera) {
		esperar(by, tipoEspera, this.timeout);
	}
	
	
	private void esperar(By by, StatusEsperas tipoEspera, int indice, int timeout) {
		WebElement elemen =  obterElemento(by, indice);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
		try {
			switch (tipoEspera) {
			case CLICK:
				wait.until(ExpectedConditions.elementToBeClickable(elemen));
				break;
			default:
				wait.until(ExpectedConditions.visibilityOf(elemen));
				break;
			}
		} catch (NoSuchElementException e) {
			throw e;
		}
	}
	

	protected void esperar(int tempoEmMilissegundos) {
		try {
			Thread.sleep(tempoEmMilissegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*******************
	 * JAVA SCRIPT
	 ******************/

	protected void executarJavaScriptPorId(String codigoJavascript, String id) {
		executarJavaScript(codigoJavascript, obterElemento(By.id(id), StatusEsperas.PRESENCA));
	}

	protected Object executarJavaScript(String script, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(script, param);
	}

	private void executarJavaScript(String codigoJavascript) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(codigoJavascript);
	}

	private void executarJavaScript(String codigoJavascript, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(codigoJavascript, element);
	}

	/*******************
	 * SCROLL
	 ******************/

	protected void scrollTelaPonto(int x, int y) {
		executarJavaScript("window.scrollTo(" + x + "," + y + ")");
	}

	protected void scrollTelaInicio() {
		scrollTelaPonto(0, 0);
	}

	protected void scrollTelaFim() {
		executarJavaScript("window.scrollBy(0, document.body.scrollHeight || document.documentElement.scrollHeight)");
	}

	protected void ScrollAteElemento(By by) {
		executarJavaScript("window.scrollBy(0, arguments[0])", getDriver().findElement(by).getLocation().y);
	}

	protected void scrollAteElementoPorId(String id) {
		executarJavaScriptPorId("arguments[0].scrollIntoView();", id);
	}
	
}
