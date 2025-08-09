package br.com.sysmap.qa.utils;


import java.io.IOException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class Utils {

	public static String formataData(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(data);
		return dataFormatada;
	}
	
	public static java.sql.Date converterStringDate(String date)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new java.sql.Date(sdf.parse(date).getTime());
	}
	
	// Método para formatar um valor
	public static String formatarMoeda(double vlr) {
		java.text.DecimalFormat df = new java.text.DecimalFormat(
				"###,###,##0.00");
		return df.format(vlr);
	}
	
	public static String removerAcentos(String valorAcentuado){
		   return Normalizer
		          .normalize(valorAcentuado, Normalizer.Form.NFD)
		          .replaceAll("[^\\p{ASCII}]", "");
		}
	
	public static long subtrairDatasEmSegundos(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		
		Duration diferenca = Duration.between(dataInicial, dataFinal);
		//LocalTime localTimeDiferenca = LocalTime.ofNanoOfDay(diferenca.getSeconds());
		return diferenca.getSeconds();
	}
	
	public static String getConfiguracao(String chave)  {
		// TODO Auto-generated method stub
		Properties arquivoConfiguracoes = new Properties();
		try {
			arquivoConfiguracoes.load(Utils.class.getClassLoader().getResourceAsStream("config_testes.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arquivoConfiguracoes.getProperty(chave);
	}
	
	
	public static LocalDateTime convertDateToLocalDateTime(String data) {
		if (Objects.isNull(data)) {
			return null;
		}
        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(data);
        	
            return date.toInstant()
                       .atZone(ZoneId.systemDefault())
                       .toLocalDateTime();
        } catch (UnsupportedOperationException e) {
            System.err.println("Conversão não suportada: " + e.getMessage());
            return null;
        } catch (ParseException e) {
        	System.err.println("Conversão não suportada: " + e.getMessage());
            return null;
		}
    }
	
}
