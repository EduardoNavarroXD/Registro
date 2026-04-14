package src;

import java.time.LocalDate;

public class Pessoa {
	private int codigo;
	private String nome;
	private LocalDate dtNascimento;
	
	public Pessoa() {
		setCodigo(0);
		setNome("");
		setDataNascimento(LocalDate.now());
	}
	
	public Pessoa(int codigo, String nome, LocalDate dtNascimento) {
		setCodigo(codigo);
		setNome(nome);
		setDataNascimento(dtNascimento);
	}
	
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public int getcodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public LocalDate getDataNascimento() {
		return this.dtNascimento;
	}
}
