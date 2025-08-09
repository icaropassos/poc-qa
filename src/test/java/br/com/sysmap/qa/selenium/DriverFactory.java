package br.com.sysmap.qa.selenium;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.sysmap.qa.utils.Utils;

public class DriverFactory {

	static WebDriver driver;
	private static String url;
	private static String browser;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {

			String urlSistema = Utils.getConfiguracao("url.sistema");

			url = "https://" + urlSistema;	

			browser = Utils.getConfiguracao("execucao.browser");

			if (Boolean.valueOf(Utils.getConfiguracao("execucao.seleniumgrid")))
				createDriverRemoto(browser);
			else
				createDriver(browser);
		}
		return driver;
	}

	private static void createDriver(String strBrowser) {

		if (strBrowser.equals("Chrome")) {	       
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\erik.francisco\\eclipse-workspace\\AutomacaoIA\\drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (strBrowser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}

		if (Boolean.valueOf(Utils.getConfiguracao("execucao.browser.maximizado")))
			driver.manage().window().maximize();
		else
			driver.manage().window().setSize(new Dimension(Integer.valueOf(Utils.getConfiguracao("execucao.browser.x")),
					Integer.valueOf(Utils.getConfiguracao("execucao.browser.y"))));

		driver.get(url);
		System.out.println("URL do Teste : " + driver.getCurrentUrl());
		BaseTest.urlAplicacao = driver.getCurrentUrl();
	}

	private static void createDriverRemoto(String strBrowser) {

		MutableCapabilities opt = null;

		if (strBrowser.equals("Chrome")) {
			opt = new ChromeOptions();
		} else if (strBrowser.equals("Firefox")) {
			opt = new FirefoxOptions();
		}

		opt.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		try {			
			driver = new RemoteWebDriver(new URL(Utils.getConfiguracao("execucao.seleniumgrid.url")), opt);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get(url);
		
		System.out.println("URL do Teste : " + driver.getCurrentUrl());
		BaseTest.urlAplicacao = driver.getCurrentUrl();

		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static <T> T Na(Class<T> classe) {
		return PageFactory.initElements(driver, classe);
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
