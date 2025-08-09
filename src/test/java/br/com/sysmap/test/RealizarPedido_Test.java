package br.com.sysmap.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Features/Capta", 
glue = {"steps"},		
plugin = {"pretty","html:target/htmlreport.html"})

public class RealizarPedido_Test {

}