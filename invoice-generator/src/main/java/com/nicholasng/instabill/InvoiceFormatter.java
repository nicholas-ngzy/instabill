package com.nicholasng.instabill;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

class InvoiceFormatter {

    Item item1 = Item.builder()
            .name("Steel plate")
            .price(50)
            .quantity(2)
            .build();
    Item item2 = Item.builder()
            .name("Steel hinge")
            .price(25)
            .quantity(23)
            .build();
    List<Item> itemList = List.of(item1, item2);

    void generatePdf() throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, Files.newOutputStream(Paths.get("invoice-" + 1 + ".pdf")));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello world", font);
        document.add(chunk);
        PdfPTable table = new PdfPTable(4);
        addTableHeader(table);
        for (Item item: itemList) {
            addRows(table, item);
        }
        document.add(table);
        document.close();
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Item", "Quantity", "Price per unit", "Total")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, Item item) {
        table.addCell(item.name);
        table.addCell(String.valueOf(item.quantity));
        table.addCell(String.valueOf(item.price));
        table.addCell(String.valueOf(item.quantity * item.price));
    }
}