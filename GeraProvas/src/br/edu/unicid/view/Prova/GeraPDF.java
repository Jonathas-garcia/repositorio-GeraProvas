package br.edu.unicid.view.Prova;

import java.awt.FileDialog;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.unicid.bean.Questao;

public class GeraPDF {
	String arquivo;
	FileDialog salvar;
	Document doc = null;
	FileOutputStream os = null;
	JFrame f;

	public GeraPDF(JFrame f) {
		this.f=f;
	}

	public void gerarPDF(ArrayList<Questao> questoes) throws Exception {
		salvar = new FileDialog(f, "Salvar", FileDialog.SAVE);
		salvar.setVisible(true);

		if (salvar.getFile() == null) {
			return;
		}
		arquivo = salvar.getDirectory() + salvar.getFile();

		try {
			doc = new Document(PageSize.A4);
			os = new FileOutputStream(arquivo);

			PdfWriter.getInstance(doc, os);
			doc.open();

			doc.add(new Paragraph("NOME:___________________________________________________ TURMA:__________"));
			doc.add(new Paragraph("CURSO:___________________________________________________ DATA::__________"));

			for (Questao questao : questoes) {

			}

		} finally {
			if (doc != null) {
				// fechamento do documento
				doc.close();
			}
			if (os != null) {
				// fechamento da stream de saída
				os.close();
			}
		}
	}

}
