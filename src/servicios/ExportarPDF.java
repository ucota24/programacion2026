package servicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import models.Usuario;

public class ExportarPDF {
	
	public void exportarUsuarios(List<Usuario> usuarios, File archivo) throws IOException {
        try (PdfDocument pdfDoc = new PdfDocument(new PdfWriter(archivo));
             Document doc = new Document(pdfDoc, PageSize.LETTER.rotate())) {
            InputStream is = getClass().getResourceAsStream("/image/logoventana1.png");
            
            if (is != null) {
                ImageData data = ImageDataFactory.create(is.readAllBytes());
                Image img = new Image(data).scaleAbsolute(50, 50);
                
                float altoPagina = PageSize.LETTER.rotate().getHeight();
                
                float margen = 40;
                
                img.setFixedPosition(margen, altoPagina - margen - 50);
                
                doc.add(img);
            }

            doc.add(new Paragraph("Reporte de Usuarios").setBold().setFontSize(12).setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("").setMarginTop(30));

            float[] columnsWidth = { 0.5f, 2, 2, 3, 3, 3, 3, 3 };
            
            Table table = new Table(UnitValue.createPercentArray(columnsWidth)).useAllAvailableWidth();

            PdfFont font = PdfFontFactory.createFont();

            Cell cell = new Cell(1, 8).add(new Paragraph("Usuarios del sistema")).setFont(font).setFontSize(14)
            		.setFontColor(DeviceGray.WHITE).setBackgroundColor(new DeviceRgb(44, 111, 80))
            		.setTextAlignment(TextAlignment.CENTER);
            
            table.addHeaderCell(cell);

            for (int i = 0; i < 2; i++) {
            	
                Cell[] headerFooter = new Cell[] {
                    new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(1f))
                        .setBackgroundColor(new DeviceGray(0.80f)).add(new Paragraph("#")),
                        
                    new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(1f))
                        .setBackgroundColor(new DeviceGray(0.80f)).add(new Paragraph("Nombre")),
                        
                    new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(1f))
                        .setBackgroundColor(new DeviceGray(0.80f)).add(new Paragraph("Apellido")),
                        
                    new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(1f))
                        .setBackgroundColor(new DeviceGray(0.80f)).add(new Paragraph("Correo")),
                        
                    new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(1f))
                        .setBackgroundColor(new DeviceGray(0.80f)).add(new Paragraph("Telefono")),
                        
                    new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(1f))
                        .setBackgroundColor(new DeviceGray(0.80f)).add(new Paragraph("Ciudad/Estado")),
                        
                    new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(1f))
                        .setBackgroundColor(new DeviceGray(0.80f)).add(new Paragraph("Direccion")),
                        
                    new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(1f))
                        .setBackgroundColor(new DeviceGray(0.80f)).add(new Paragraph("Fecha de Nacimiento")),
                };

                for (Cell celda : headerFooter) {
                    if (i == 0) {
                        table.addHeaderCell(celda);
                    } else {
                        table.addFooterCell(celda);
                    }
                }
            }

            int indice = 1;
            for (Usuario u : usuarios) {
                table.addCell(new Cell()
                        .setTextAlignment(TextAlignment.CENTER)
                        .add(new Paragraph(String.valueOf(indice))));
                table.addCell(new Cell()
                        .setTextAlignment(TextAlignment.LEFT)
                        .add(new Paragraph(u.getNombre())));
                table.addCell(new Cell()
                        .setTextAlignment(TextAlignment.LEFT)
                        .add(new Paragraph(u.getApellido())));
                table.addCell(new Cell()
                        .setTextAlignment(TextAlignment.LEFT)
                        .add(new Paragraph(u.getCorreo())));
                table.addCell(new Cell()
                        .setTextAlignment(TextAlignment.CENTER)
                        .add(new Paragraph(u.getTelefono())));
                table.addCell(new Cell()
                        .setTextAlignment(TextAlignment.LEFT)
                        .add(new Paragraph(u.getCiudadEstado())));
                table.addCell(new Cell()
                        .setTextAlignment(TextAlignment.LEFT)
                        .add(new Paragraph(u.getDireccion())));
                table.addCell(new Cell()
                        .setTextAlignment(TextAlignment.CENTER)
                        .add(new Paragraph(u.getFecha_Nacimiento())));
                indice++;
            }

            doc.add(table);
        }
	}
	

}
