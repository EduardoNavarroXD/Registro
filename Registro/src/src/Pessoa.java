package src;

import java.time.LocalDate;

public class Pessoa {
	private int codigo;
	private String nome;
	private LocalDate dtNascimento;
	private String cod;
	private String data;
	
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
	
	public Pessoa(String codigo, String nome, String dtNascimento) {
		this.cod = codigo;
		this.nome = nome;
		this.data = dtNascimento;
	}
	
	public String getCod() {
		return this.cod;
	}
	
	public void setCod(String codigo) {
		this.cod = codigo;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
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
