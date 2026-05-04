package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControlPessoa {
	//variavel global
	Scanner entrada;
	Pessoa person;
	DAO dao;
	
	public ControlPessoa() {
		this.entrada = new Scanner(System.in);
		this.person = new Pessoa();
		this.dao = new DAO();
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

	public void cadastrarTela() {
		String codigo =JOptionPane.showInputDialog(null, "Informe o codigo: ", "Codigo", JOptionPane.INFORMATION_MESSAGE);
		String nome =JOptionPane.showInputDialog(null, "Informe o nome: ", "Nome", JOptionPane.INFORMATION_MESSAGE);
		String dtNascimento =JOptionPane.showInputDialog(null, "Informe a data de nascimento: ", "Data nascimento", JOptionPane.INFORMATION_MESSAGE);
		
		this.person = new Pessoa(codigo, nome, dtNascimento);
		
		String msg = this.dao.inserir(this.person);
		JOptionPane.showMessageDialog(null, msg, "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		
		try {
			String mensagem = "" +JOptionPane.showConfirmDialog(null, "Confirma o cadastro?", "Não", JOptionPane.NO_OPTION);
			if(mensagem.equals("0")) {
				JOptionPane.showMessageDialog(null, "Codigo: " + "Cadastrado com sucesso!", "confirmação Cadastro", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Não cadastrado", "ERRO", JOptionPane.WARNING_MESSAGE);
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void ConsultarBanco() {
		JOptionPane.showMessageDialog(null, this.dao.listar(), "consultar" ,
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void AtualizarBanco(String codigo, String nome, String dtNascimento) {
		this.person = new Pessoa(codigo, nome, dtNascimento);
		JOptionPane.showMessageDialog(null, this.dao.atualizar(this.person), "Atualizar",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void ExcluirBanco(int codigo) {
		JOptionPane.showMessageDialog(null,this.dao.excluir(codigo), "Excluir",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	
	
}//fim da controlpessoa


