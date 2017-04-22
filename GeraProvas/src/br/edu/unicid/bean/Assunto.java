package br.edu.unicid.bean;

public class Assunto {

	int codAssunt;
	String texto;
	String data;
	boolean estatus;
	
	public Assunto( String texto, String data) {
		this.texto = texto;
		this.data = data;
	}

		public Assunto( String texto) {
			this.texto = texto;
		}
	
	public Assunto(int codAssunto, String texto, String data) {
		this.codAssunt = codAssunto;
		this.texto = texto;
		this.data = data;
	}
	
	public Assunto(int codAssunt, String texto) {
		super();
		this.codAssunt = codAssunt;
		this.texto = texto;
	}


	public Assunto(int codAssunt, String texto, String data, boolean estatus) {
		super();
		this.codAssunt = codAssunt;
		this.texto = texto;
		this.data = data;
		this.estatus = estatus;
	}

	public int setCod2(int cod){
		return cod;
	}
	
	public int getCodAssunt() {
		return codAssunt;
	}
	public void setCodAssunt(int codAssunt) {
		this.codAssunt = codAssunt;
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
	
	@Override
	public String toString() {
		return "{ " + String.valueOf(getCodAssunt()) + ", " + getTexto() + ", " + getData()+ "}";
	}
	
	
}
