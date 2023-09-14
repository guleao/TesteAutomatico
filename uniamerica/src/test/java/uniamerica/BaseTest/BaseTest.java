package uniamerica.BaseTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import uniamerica.PO.GooglePO;
import uniamerica.Test.Rota;

public class BaseTest extends Rota {

	public static GooglePO googlePage;

	@BeforeClass
	public static void inicializaPagina() {
		googlePage = new GooglePO(chrome);
	}

	@Test
	public void testeSemNada() {
		googlePage.inputEmail.sendKeys(""+Keys.ENTER);
		googlePage.inputSenha.sendKeys(""+Keys.ENTER);
		String msg = googlePage.mensagemErro.getText();
		Assert.assertTrue(msg.contains("Informe usuário e senha, os campos não podem ser brancos."));
		googlePage.inputEmail.clear();
		googlePage.inputSenha.clear();
	}

	@Test
	public void testeSemLoginComSenha() {
		googlePage.inputEmail.sendKeys(""+Keys.ENTER);
		googlePage.inputSenha.sendKeys("admin@123"+Keys.ENTER);
		String msg = googlePage.mensagemErro.getText();
		Assert.assertTrue(msg.contains("Informe usuário e senha, os campos não podem ser brancos."));
		googlePage.inputEmail.clear();
		googlePage.inputSenha.clear();
	}

	@Test
	public void testeComLoginSemSenha() {
		googlePage.inputEmail.sendKeys("admin@admin.com"+Keys.ENTER);
		googlePage.inputSenha.sendKeys(""+Keys.ENTER);
		String msg = googlePage.mensagemErro.getText();
		Assert.assertTrue(msg.contains("Informe usuário e senha, os campos não podem ser brancos."));
		googlePage.inputEmail.clear();
		googlePage.inputSenha.clear();
	}

	@Test
	public void testeComLoginCertoComSenhaErrada() {
		googlePage.inputEmail.sendKeys("admin@admin.com"+Keys.ENTER);
		googlePage.inputSenha.sendKeys("admin@124"+Keys.ENTER);
		String msg = googlePage.mensagemErro.getText();
		Assert.assertTrue(msg.contains("E-mail ou senha inválidos"));
		googlePage.inputEmail.clear();
		googlePage.inputSenha.clear();
	}

	@Test
	public void testeComLoginErradoComSenhaCerta() {
		googlePage.inputEmail.sendKeys("admin@admin"+Keys.ENTER);
		googlePage.inputSenha.sendKeys("admin@123"+Keys.ENTER);
		String msg = googlePage.mensagemErro.getText();
		Assert.assertTrue(msg.contains("E-mail ou senha inválidos"));
		googlePage.inputEmail.clear();
		googlePage.inputSenha.clear();
	}

	@Test
	public void testeComLoginErradoComSenhaErrada() {
		googlePage.inputEmail.sendKeys("admin@admin.cs"+Keys.ENTER);
		googlePage.inputSenha.sendKeys("admin@124"+Keys.ENTER);
		String msg = googlePage.mensagemErro.getText();
		Assert.assertTrue(msg.contains("E-mail ou senha inválidos"));
		googlePage.inputEmail.clear();
		googlePage.inputSenha.clear();
	}

}










