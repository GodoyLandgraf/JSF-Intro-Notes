package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;


//@ApplicationScoped       //TODOS OS USUÁRIOS compartilham os mesmos dados
//@SessionScoped 	      Dados mantidos na sessão do usuário
@ViewScoped         //Lista Morre quando redireciona a tela
//@RequestScoped      Como quer adicionar em uma lista, o request que é de vida curta não serve
@ManagedBean(name = "pessoaBean")  //referencia o nome e não a classe java
public class PessoaBean {

		private String nome;
		
		private String senha;
		
		private String texto;
		
		private HtmlCommandButton commandButton;
	
		private List<String> nomes = new ArrayList<String>();
		
		
		public String addNome() {
			nomes.add(nome);
			
			if (nomes.size()> 3) {
				commandButton.setDisabled(true);
				return "paginanavegada?faces-redirect=true";  // condição para navegação dinâmica
			//?faces-redirect=true REDIRECIONA A URL para a url certa
			}
			
			return ""; //retorno na mesma tela null ou ""  ----> outcome
		}
			
		
		public void setCommandButton(HtmlCommandButton commandButton) {
			this.commandButton = commandButton;
		}
		
		public HtmlCommandButton getCommandButton() {
			return commandButton;
		}
		
		public void setNomes(List<String> nomes) {
			this.nomes = nomes;
		}
		
		public List<String> getNomes() {
			return nomes;
		}
		
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getSenha() {
			return senha;
		}


		public void setSenha(String senha) {
			this.senha = senha;
		}


		public String getTexto() {
			return texto;
		}


		public void setTexto(String texto) {
			this.texto = texto;
		}
		
		
			
	
}
