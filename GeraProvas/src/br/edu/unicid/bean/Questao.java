package br.edu.unicid.bean;

import java.io.IOException;

import javax.swing.ImageIcon;

public class Questao {
	int cod;
	String pergunta;
	String tipo;
	String altA;
	String altB;
	String altC;
	String altD;
	String altE;
	String altCorreta;
	String assunto;
	String nivelDific;
	String data;
	int qtdUtilizada;
	int pontuacao;
	String ultimaData;
	String respEsperada;
	
	String stringImgEnun;
	String stringImgAltA;
	String stringImgAltB;
	String stringImgAltC;
	String stringImgAltD;
	String stringImgAltE;
	String stringImgRespEsp;
	
	
	boolean estatus;
	String[] alternativas;

	
	byte[] imgEnunciado;
	byte[] imgAltA;
	byte[] imgAltB;
	byte[] imgAltC;
	byte[] imgAltD;
	byte[] imgAltE;
	byte[] imgRespostaEsperada;
	
	
	public Questao(){}
	

	public Questao(String pergunta, String tipo, String respEsp, String altA,String altB, String altC, String altD, String altE, 
			String altCorreta, byte[] imgPergunta, byte[] imgAltA, byte[] imgAltB, byte[] imgAltC, byte[] imgAltD, 
			byte[] imgAltE, byte[] imgResp ){
		
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.respEsperada = respEsp;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.altE = altE;
		this.altCorreta = altCorreta;
		this.imgAltA = imgAltA;
		this.imgAltB = imgAltB;
		this.imgAltC = imgAltC;
		this.imgAltD = imgAltD;
		this.imgAltE = imgAltE;
		this.imgRespostaEsperada = imgResp;
		
	}
	
	
	
	//CONSTRUTOR PARA SALVAR PERGUNTA DISSERTATIVA COM IMAGEM
	public Questao(int cod, String tipo, String pergunta, String imgEnunciado, String respostaImg, String resposta, String assunto, String nv){
		this.cod = cod;
		this.tipo = tipo;
		this.pergunta = pergunta;
		this.respEsperada = resposta;
		this.assunto = assunto;
		this.nivelDific = nv;
		this.stringImgEnun = imgEnunciado;
		this.stringImgRespEsp = respostaImg;
	}
	
	
	//CONSTRUTOR PARA SALVAR PERGUNTA OPTATIVA COM IMAGEM
	public Questao(int cod, String tipo, String pergunta, String imgPergunta, String imgAltA, String imgAltB, String imgAltC, String imgAltD, String imgAltE, 
			String altCorreta, String assunto, String nv){
		
		this.cod = cod;
		this.tipo = tipo;
		this.pergunta = pergunta;
		this.stringImgEnun= imgPergunta;
		this.stringImgAltA = imgAltA;
		this.stringImgAltB = imgAltB;
		this.stringImgAltC = imgAltC;
		this.stringImgAltD = imgAltD;
		this.stringImgAltE = imgAltE;
		this.altCorreta = altCorreta;
		this.assunto = assunto;
		this.nivelDific = nv;
		
	}
	
	public String getStringImgEnun() {
		return stringImgEnun;
	}




	public void setStringImgEnun(String stringImgEnun) {
		this.stringImgEnun = stringImgEnun;
	}




	public String getStringImgAltA() {
		return stringImgAltA;
	}




	public void setStringImgAltA(String stringImgAltA) {
		this.stringImgAltA = stringImgAltA;
	}




	public String getStringImgAltB() {
		return stringImgAltB;
	}




	public void setStringImgAltB(String stringImgAltB) {
		this.stringImgAltB = stringImgAltB;
	}




	public String getStringImgAltC() {
		return stringImgAltC;
	}




	public void setStringImgAltC(String stringImgAltC) {
		this.stringImgAltC = stringImgAltC;
	}




	public String getStringImgAltD() {
		return stringImgAltD;
	}




	public void setStringImgAltD(String stringImgAltD) {
		this.stringImgAltD = stringImgAltD;
	}




	public String getStringImgAltE() {
		return stringImgAltE;
	}




	public void setStringImgAltE(String stringImgAltE) {
		this.stringImgAltE = stringImgAltE;
	}




	public String getStringImgRespEsp() {
		return stringImgRespEsp;
	}




	public void setStringImgRespEsp(String stringImgRespEsp) {
		this.stringImgRespEsp = stringImgRespEsp;
	}

	
	public byte[] getImgEnunciado() throws IOException {

		return imgEnunciado;
	}
	



	public void setImgEnunciado(byte[] imgEnunciado) {
		this.imgEnunciado = imgEnunciado;
	}


	public byte[] getImgAltA() {
		return imgAltA;
	}


	public void setImgAltA(byte[] imgAltA) {
		this.imgAltA = imgAltA;
	}


	public byte[] getImgAltB() {
		return imgAltB;
	}


	public void setImgAltB(byte[] imgAltB) {
		this.imgAltB = imgAltB;
	}


	public byte[] getImgAltC() {
		return imgAltC;
	}


	public void setImgAltC(byte[] imgAltC) {
		this.imgAltC = imgAltC;
	}


	public byte[] getImgAltD() {
		return imgAltD;
	}


	public void setImgAltD(byte[] imgAltD) {
		this.imgAltD = imgAltD;
	}


	public byte[] getImgAltE() {
		return imgAltE;
	}


	public void setImgAltE(byte[] imgAltE) {
		this.imgAltE = imgAltE;
	}





	public void setImgRespostaEsperada(byte[] imgRespostaEsperada) {
		this.imgRespostaEsperada = imgRespostaEsperada;
	}

	public byte[] getImgRespEsp(){
		return imgRespostaEsperada;
	}
	


	public Questao(int cod, String tipo, String pergunta, byte[] imgEnunciado, byte[] imgAltA, byte[] imgAltB, byte[] imgAltC, byte[] imgAltD, byte[] imgAltE, String altCorreta, String assunto, String nivelDific){
		this.imgEnunciado = imgEnunciado;
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.imgAltA = imgAltA;
		this.imgAltB = imgAltB;
		this.imgAltC = imgAltC;
		this.imgAltD = imgAltD;
		this.imgAltE = imgAltE;
		this.assunto = assunto;
		this.altCorreta = altCorreta;
		this.nivelDific = nivelDific;
		this.cod = cod;
	}
	
	
	public Questao(int cod, String tipo, String pergunta, byte[] imgEnunciado, byte[] imgAltA, byte[] imgAltB, byte[] imgAltC, byte[] imgAltD, byte[] imgAltE, String altCorreta){
		this.imgEnunciado = imgEnunciado;
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.imgAltA = imgAltA;
		this.imgAltB = imgAltB;
		this.imgAltC = imgAltC;
		this.imgAltD = imgAltD;
		this.imgAltE = imgAltE;
		this.altCorreta = altCorreta;
		this.cod = cod;
	}
	//CONSTRUTOR USADO PARA RETORNAR QUESTAO OPTATIVA SEM IMAGEM DO BD
	public Questao(int cod, String tipo, String pergunta,  String imgAltA, String imgAltB, String imgAltC, String imgAltD, String imgAltE, String altCorreta){
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.altA = imgAltA;
		this.altB = imgAltB;
		this.altC = imgAltC;
		this.altD = imgAltD;
		this.altE = imgAltE;
		this.altCorreta = altCorreta;
		this.cod = cod;
	}
	
	public Questao(int cod,String pergunta,  String imgAltA, String imgAltB, String imgAltC, String imgAltD, String imgAltE, String altCorreta, String assunto, String nv){
		this.pergunta = pergunta;
		this.altA = imgAltA;
		this.altB = imgAltB;
		this.altC = imgAltC;
		this.altD = imgAltD;
		this.altE = imgAltE;
		this.altCorreta = altCorreta;
		this.cod = cod;
		this.assunto = assunto;
		this.nivelDific = nv;
	}
	
	//CONSTRUTOR USADO PARA RETORNAR QUESTAO DISSERTATIVA COM IMAGEM DO BD
	public Questao(int cod, String tipo, String pergunta,  byte[] imgEnunciado,  byte[] imgResp, String assunto, String nv){
		this.cod = cod;
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.assunto = assunto;
		this.nivelDific = nv;
		this.imgEnunciado = imgEnunciado;
		this.imgRespostaEsperada = imgResp;
	}
	
	public Questao(int cod, String tipo, String pergunta,  byte[] imgEnunciado,  byte[] imgResp){
		this.cod = cod;
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.imgEnunciado = imgEnunciado;
		this.imgRespostaEsperada = imgResp;
	}
	
	//CONSTRUTOR USADO PARA RETORNAR QUESTAO DISSERTATIVA SEM IMAGEM DO BD
		public Questao(int cod, String tipo, String pergunta, String resp){
			this.cod = cod;
			this.pergunta = pergunta;
			this.tipo = tipo;
			this.respEsperada = resp;
		}
	
	public String[] getAlternativas(){
		return this.alternativas;
	}
	
	
	public Questao(int cod, String pergunta, String assunto, String nivel, String data, int qtd){
		this.cod = cod;
		this.pergunta = pergunta;
		this.assunto = assunto;
		this.nivelDific = nivel;
		this.data = data;
		this.qtdUtilizada = qtd;
	}
	public void setAlternativas(){
		alternativas[0] = altA;
		alternativas[1] = altB;
		alternativas[2] = altC;
		alternativas[3] = altD;
		alternativas[4] = altE;
		alternativas[5] = altCorreta;
	}
	
	public boolean isEstatus() {
		return estatus;
	}

	public boolean setEstatus2(boolean estatus) {
		return estatus;
		
	}
	
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;;
	}

	public Questao(int cod, String pergunta, String tipo, String respEsperada, String assunto, String nivelDific, int data, boolean status){
		
		this.pergunta = pergunta;
		this.respEsperada = respEsperada;
		this.assunto = assunto;
		this.nivelDific = nivelDific;

		
	}
	public Questao(String pergunta, String tipo, String respEsperada, String altA, String altB, String altC, String altD, String altE, String altCorreta){
		
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.respEsperada = respEsperada;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.altE = altE;
		this.altCorreta = altCorreta;

		
	}
	
	public Questao(int cod, String pergunta, String respEsperada, String assunto, String nivelDific, 
			String data, boolean estatus) {
		super();
		this.cod = cod;
		this.pergunta = pergunta;
		this.respEsperada = respEsperada;
		this.assunto = assunto;
		this.nivelDific = nivelDific;
		this.data = data;
		this.estatus = estatus;
		
	}
	
	public Questao(int cod, String pergunta, String tipo, String assunto, String nivelDific, 
			String data, int qtdUtilizada) {
		super();
		this.cod = cod;
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.assunto = assunto;
		this.nivelDific = nivelDific;
		this.data = data;
		this.qtdUtilizada = qtdUtilizada;
		
	}


	
	public Questao(int cod, String pergunta, String assunto, String nivelDific, int qtdUtilizada) {
		super();
		this.cod = cod;
		this.pergunta = pergunta;
		
		this.assunto = assunto;
		this.nivelDific = nivelDific;
		this.qtdUtilizada = qtdUtilizada;
	}
	
	public Questao(int cod, String pergunta, String altA, String altB, String altC, String altD, String altE,
			String altCorreta, String assunto, String nivelDific, String data, boolean estatus) {
		super();
		this.cod = cod;
		this.pergunta = pergunta;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.altE = altE;
		this.altCorreta = altCorreta;
		this.assunto = assunto;
		this.nivelDific = nivelDific;
		this.data = data;
		this.estatus = estatus;
		
	}
	
		public Questao(int cod, String pergunta, String tipo, String altA, String altB, String altC, String altD, String altE,
			String altCorreta, String assunto, String nivelDific, String data, boolean estatus, int qtdUtilizada) {
		super();
		this.cod = cod;
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.altE = altE;
		this.altCorreta = altCorreta;
		this.assunto = assunto;
		this.nivelDific = nivelDific;
		this.data = data;
		this.estatus = estatus;
		this.qtdUtilizada = qtdUtilizada;
	}

		public Questao(int cod, String pergunta, String respEsperada,  String assunto, String nv){
			this.cod = cod;
			this.pergunta = pergunta;
			this.respEsperada = respEsperada;
			this.assunto = assunto;
			this.nivelDific = nv;
			
		}


	public String getData() {
			return data;
		}

	public void setData(String data) {
			this.data = data;
		}

	public Questao(ImageIcon enunciado, ImageIcon altA2, ImageIcon altB2, ImageIcon altC2, ImageIcon altD2, ImageIcon altE2, String altCorreta2, String assunto2, String nivel) {
			
		}
		
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public int setCod2(int cod){
		return cod;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getAltA() {
		return altA;
	}
	public void setAltA(String altA) {
		this.altA = altA;
	}
	public String getAltB() {
		return altB;
	}
	public void setAltB(String altB) {
		this.altB = altB;
	}
	public String getAltC() {
		return altC;
	}
	public void setAltC(String altC) {
		this.altC = altC;
	}
	public String getAltD() {
		return altD;
	}
	public void setAltD(String altD) {
		this.altD = altD;
	}
	public String getAltE() {
		return altE;
	}
	public void setAltE(String altE) {
		this.altE = altE;
	}
	
	public String getAltCorreta() {
		return altCorreta;
	}

	public void setAltCorreta(String altCorreta) {
		this.altCorreta = altCorreta;
	}

	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getNivelDific() {
		return nivelDific;
	}
	public void setNivelDific(String nivelDific) {
		this.nivelDific = nivelDific;
	}

	public int getQtdUtilidzada() {
		return qtdUtilizada;
	}

	public void setQtdUtilidzada(int qtdUtilidzada) {
		this.qtdUtilizada = qtdUtilidzada;
	}
	
	public String getRespEsperada() {
		return respEsperada;
	}

	public void setRespEsperada(String respEsperada) {
		this.respEsperada = respEsperada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean checaCampos(){
		this.setAlternativas();
		for(String alternativa : this.getAlternativas()){
			if(alternativa.equals(null))
				return false;
		}		
		return true; 
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ " + pergunta + ", " + altA + ", "+ ", " + altB + ", "+ ", " + altC + ", "+ ", " + altD + ", "+ ", " + altE + ", "+  altCorreta+"}";
	}
	
}
