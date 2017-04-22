package br.edu.unicid.bean;

public class NivelDificuldade {
	int codNivel;
	String texto;
	String data;
	boolean estatus;
	
	public NivelDificuldade(int codNivel, String texto, String data, boolean estatus) {
		super();
		this.codNivel = codNivel;
		this.texto = texto;
		this.data = data;
		this.estatus = estatus;
	}
	public NivelDificuldade(int codNivel, String texto, String data) {
		super();
		this.codNivel = codNivel;
		this.texto = texto;
		this.data = data;
	}
	public NivelDificuldade(int codNivel, String texto) {
		super();
		this.codNivel = codNivel;
		this.texto = texto;
	}
	public NivelDificuldade(String texto) {
		super();
		this.texto = texto;
		
	}
	
	public int setCodNivel2(int cod){
		return cod;
	}
	
	public int getcodNivel() {
		return codNivel;
	}
	public void setNivelDificuldade(int codNivel) {
		this.codNivel = codNivel;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
	
	

}
