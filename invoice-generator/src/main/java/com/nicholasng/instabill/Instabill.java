package com.nicholasng.instabill;

import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class Instabill {
    public static void main(String[] args) throws DocumentException, IOException {
        System.out.println("Instabill");
        System.out.println("Select operation\n1: Generate invoice\n0: Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                InvoiceFormatter invoiceFormatter = new InvoiceFormatter();
                invoiceFormatter.generatePdf();
                break;
            case 0:
                System.out.println("Exited");
        }
    }
}