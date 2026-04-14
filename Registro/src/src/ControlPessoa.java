package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControlPessoa {
	//variavel global
	Scanner entrada;
	Pessoa person;
	
	public ControlPessoa() {
		this.entrada = new Scanner(System.in);
		this.person = new Pessoa();
	}// fim do metodo construtor
	
	public String entradaCodigo() {
		//variavel local
		String codigo = JOptionPane.showInputDialog(null, "informe o codigo: ", "Código", JOptionPane.QUESTION_MESSAGE);
		
		return codigo;
		
	}//fim do entrada codigo
	public String entradaNome() {	
		String nome   = JOptionPane.showInputDialog(null, "Informe o nome:", "Nome", JOptionPane.QUESTION_MESSAGE);
		
		return nome;
		
	}// fim do entrada nome
	public String entradaData() {
		String data   = JOptionPane.showInputDialog(null, "Informe a data de nascimento: ", "Data", JOptionPane.QUESTION_MESSAGE);
		
		return data;
	}//fim do entrada de data
	
	public void cadastrar() {
		int codigo = Integer.parseInt(entradaCodigo());
		String nome = entradaNome();
		String data = entradaData();
		try {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dtNascimento	  = LocalDate.parse(data, formato);
			
			//metodo para inserir o dado no banco de dados
			this.person= new Pessoa(codigo, nome, dtNascimento);
		}catch(Exception erro) {
			JOptionPane.showConfirmDialog(null, erro, "Resultado", JOptionPane.ERROR_MESSAGE);
		}//fim do catch
	}

}//fim da controlpessoa
