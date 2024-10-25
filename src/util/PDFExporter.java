package util;

import ModeloDAO.DetalleBoletaDAO;
import ModeloDTO.BoletaDTO;
import ModeloDTO.DetalleBoletaDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PDFExporter {

    static DetalleBoletaDAO dbd = new DetalleBoletaDAO();

    public static boolean exportarBoletaPDF(BoletaDTO boleta, String ruta) {
        Document document = new Document(PageSize.A4, 36, 36, 54, 36); // Márgenes más profesionales
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("hh:mm a");
        String estado = boleta.getStatus() == 0 ? "Pendiente" : "Pagado";

        try {
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            // Estilos de fuente
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.RED);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
            Font smallFont = FontFactory.getFont(FontFactory.HELVETICA, 8, BaseColor.DARK_GRAY);

            // Encabezado con logo y título
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setSpacingAfter(20);

            // Columna izquierda: Información de la empresa
            PdfPCell leftCell = new PdfPCell();
            leftCell.setBorder(Rectangle.NO_BORDER);
            Paragraph title = new Paragraph("Rositas Jabones", titleFont);
            leftCell.addElement(title);
            leftCell.addElement(new Paragraph("RUC: 10036545785", smallFont));
            leftCell.addElement(new Paragraph("Jirón Ucayali 768", smallFont));
            leftCell.addElement(new Paragraph("Galería Ton Pho Tienda 212", smallFont));
            leftCell.addElement(new Paragraph("Barrio Chino - Lima", smallFont));
            headerTable.addCell(leftCell);

            // Columna derecha: Información de la boleta
            PdfPCell rightCell = new PdfPCell();
            rightCell.setBorder(Rectangle.BOX);
            rightCell.setPadding(10);
            rightCell.setBackgroundColor(new BaseColor(240, 240, 240));
            Paragraph boletaInfo = new Paragraph();
            boletaInfo.add(new Chunk("BOLETA DE VENTA\n", headerFont));
            boletaInfo.add(new Chunk("N° " + boleta.getCodigo() + "\n\n", headerFont));
            boletaInfo.add(new Chunk("Fecha: " + boleta.getFecha().format(formatter) + "\n", normalFont));
            boletaInfo.add(new Chunk("Hora: " + boleta.getFecha().format(formatterHour) + "\n", normalFont));
            boletaInfo.add(new Chunk("Estado: " + estado, normalFont));
            rightCell.addElement(boletaInfo);
            headerTable.addCell(rightCell);

            document.add(headerTable);

            // Información del cliente y vendedor
            PdfPTable infoTable = new PdfPTable(2);
            infoTable.setWidthPercentage(100);
            infoTable.setSpacingAfter(20);

            // Cliente
            PdfPCell clienteCell = new PdfPCell();
            clienteCell.setBorder(Rectangle.BOX);
            clienteCell.setPadding(10);
            Paragraph clienteInfo = new Paragraph();
            clienteInfo.add(new Chunk("CLIENTE\n", headerFont));
            clienteInfo.add(new Chunk(boleta.getCliente().getNombre() + "\n", normalFont));
            clienteCell.addElement(clienteInfo);
            infoTable.addCell(clienteCell);

            // Vendedor
            PdfPCell vendedorCell = new PdfPCell();
            vendedorCell.setBorder(Rectangle.BOX);
            vendedorCell.setPadding(10);
            Paragraph vendedorInfo = new Paragraph();
            vendedorInfo.add(new Chunk("VENDEDOR\n", headerFont));
            vendedorInfo.add(new Chunk(boleta.getUsuario().getNombre(), normalFont));
            vendedorCell.addElement(vendedorInfo);
            infoTable.addCell(vendedorCell);

            document.add(infoTable);

            // Tabla de productos
            PdfPTable productTable = new PdfPTable(new float[]{2.5f, 1, 1, 1}); // Proporciones de columnas
            productTable.setWidthPercentage(100);
            productTable.setSpacingAfter(20);

            // Estilo para encabezados de tabla
            BaseColor headerBgColor = new BaseColor(50, 50, 50);
            Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE);

            // Encabezados de tabla
            String[] headers = {"Producto", "Cantidad", "Precio Unit.", "Subtotal"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, tableHeaderFont));
                cell.setBackgroundColor(headerBgColor);
                cell.setPadding(8);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                productTable.addCell(cell);
            }

            // Datos de productos
            ArrayList<DetalleBoletaDTO> listaDetalles = dbd.listarPorBoleta(boleta.getCodigo());
            for (DetalleBoletaDTO detalle : listaDetalles) {
                PdfPCell cell;

                // Nombre del producto
                cell = new PdfPCell(new Phrase(detalle.getProducto().getNombre(), normalFont));
                cell.setPadding(6);
                productTable.addCell(cell);

                // Cantidad
                cell = new PdfPCell(new Phrase(String.valueOf(detalle.getCantidad()), normalFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(6);
                productTable.addCell(cell);

                // Precio unitario
                cell = new PdfPCell(new Phrase(String.format("S/ %.2f", detalle.getProducto().getPrecio()), normalFont));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPadding(6);
                productTable.addCell(cell);

                // Subtotal
                cell = new PdfPCell(new Phrase(String.format("S/ %.2f", detalle.getSubtotal()), normalFont));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPadding(6);
                productTable.addCell(cell);
            }

            document.add(productTable);

            // Total
            PdfPTable totalTable = new PdfPTable(2);
            totalTable.setWidthPercentage(40);
            totalTable.setHorizontalAlignment(Element.ALIGN_RIGHT);

            PdfPCell totalLabelCell = new PdfPCell(new Phrase("TOTAL:", headerFont));
            totalLabelCell.setBackgroundColor(new BaseColor(240, 240, 240));
            totalLabelCell.setBorder(Rectangle.BOX);
            totalLabelCell.setPadding(8);
            totalLabelCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalTable.addCell(totalLabelCell);

            PdfPCell totalValueCell = new PdfPCell(new Phrase(String.format("S/ %.2f", boleta.getTotal()), headerFont));
            totalValueCell.setBorder(Rectangle.BOX);
            totalValueCell.setPadding(8);
            totalValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalTable.addCell(totalValueCell);

            document.add(totalTable);

            // Pie de página
            Paragraph footer = new Paragraph("¡Gracias por su preferencia!", smallFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setSpacingBefore(30);
            document.add(footer);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            document.close();
        }
    }
}
