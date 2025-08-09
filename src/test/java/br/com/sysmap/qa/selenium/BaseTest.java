package br.com.sysmap.qa.selenium;

import static br.com.sysmap.qa.utils.Utils.removerAcentos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.Scenario;

public class BaseTest {

	protected static Scenario cenarioObjeto;
	protected static String cenario = "";
	protected static String feature = "";
	public static String urlAplicacao="";

	private static int seq = 0;

	public void gerarScreenShot() {
		gerarScreenShot(feature, cenario);
		this.seq++; 
	}

	public void gerarScreenShot(String feature, String cenario) {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
	
			if (seq > 0) 
			{
				FileUtils.copyFile(imagem, new File("target/evidencias/" + removerAcentos(feature) + "/"
						+ removerAcentos(cenario) + "_" + seq + ".png"));
				cenarioObjeto.attach(urlAplicacao, "text/plain", "URL Utilizada no Teste");
				cenarioObjeto.attach(redimensionarImagem(imagem, 1), "image/png", removerAcentos(feature) + " - " + removerAcentos(cenario) + "_" + seq);
				
			} else {
				FileUtils.copyFile(imagem, new File(
						"target/evidencias/" + removerAcentos(feature) + "/" + removerAcentos(cenario) + ".png"));
				cenarioObjeto.attach(urlAplicacao, "text/plain", "URL Utilizada no Teste");
				cenarioObjeto.attach(redimensionarImagem(imagem, 1), "image/png", removerAcentos(feature) + " - " + removerAcentos(cenario));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static byte[] redimensionarImagem(File imagem, double escala) throws IOException {
		InputStream is = new ByteArrayInputStream(Files.readAllBytes(imagem.toPath()));
		BufferedImage imagemOriginal = ImageIO.read(is);

		int altura = (int) (imagemOriginal.getHeight() * escala);
		int largura = (int) (imagemOriginal.getWidth() * escala);

		BufferedImage imagemRedimensionada = new BufferedImage(largura, altura, imagemOriginal.getType());
		imagemRedimensionada.createGraphics().drawImage(imagemOriginal, 0, 0, largura, altura, null);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(imagemRedimensionada, "PNG", baos);

		return baos.toByteArray();
	}
}
