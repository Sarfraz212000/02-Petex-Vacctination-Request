package com.petex.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.petex.entity.VaccinationEntity;

@Component
public class PdfGenerator {

	public void generate( VaccinationEntity vaccination, File f)
			throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph = new Paragraph("Vaccination Details", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		document.add(new Paragraph("Name: " + vaccination.getCustomerName()));
		document.add(new Paragraph("Description: " + vaccination.getDescription()));
		document.add(new Paragraph("Email: " + vaccination.getCustomerEmail()));
		document.add(new Paragraph("Date: " + vaccination.getDate()));
		document.add(new Paragraph("Time: " + vaccination.getTime()));
		document.add(new Paragraph("Mobile: " + vaccination.getCustomerPhno()));
		
		document.close();
		writer.close();

	}

}
