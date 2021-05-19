package com.javahowtos.jasperdemo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.lowagie.text.pdf.codec.Base64.OutputStream;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class JasperReportTextFieldExample {

	    public static void main(String[] args) {
	        try {
	            /* User home directory location */
	            String userHomeDirectory = System.getProperty("user.home");
	            /* Output file location */
	            String outputFile = userHomeDirectory + File.separatorChar + "JasperReportTextFieldExample.pdf";

	            /* Map to hold Jasper report Parameters */
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("billingAddress", "Google LLC,\n1600 Amphitheatre Parkway Mountain View,\nCA 94043 USA");
	            parameters.put("shippingAddress", "Google LLC,\n1600 Amphitheatre Parkway Mountain View,\nCA 94043 USA");

	            /* Using compiled version(.jasper) of Jasper report to generate PDF */
	            JasperPrint jasperPrint = JasperFillManager.fillReport("resources/com/javaquery/jasper/templates/template_jasper_text_field.jasper", parameters, new JREmptyDataSource());

	            /* outputStream to create PDF */
	            java.io.OutputStream outputStream = new FileOutputStream(new File(outputFile));
	            /* Write content to PDF file */
	            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

	            System.out.println("File Generated: " + outputFile);
	        } catch (JRException ex) {
	            ex.printStackTrace();
	        } catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	        }
	}
}
