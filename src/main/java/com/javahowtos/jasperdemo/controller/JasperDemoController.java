package com.javahowtos.jasperdemo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javahowtos.jasperdemo.beans.SampleBean;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Controller()
public class JasperDemoController {
	  SampleBean sampleBeanResponse;
//    @GetMapping()
//    public void getDocument(HttpServletResponse response) throws IOException, JRException {
//
//        String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "SampleJasperReport.jasper")
//            .getAbsolutePath();
//        List<SampleBean> dataList = new ArrayList<SampleBean>();
//        SampleBean sampleBean = new SampleBean();
//        sampleBean.setName("Bà ú địt thúi");
//        sampleBean.setColor("green");
//        dataList.add(sampleBean);
//        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
//        Map<String, Object> parameters = new HashMap();
//        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
//        JRDocxExporter exporter = new JRDocxExporter();
//        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
//        response.setHeader("Content-Disposition", "attachment;filename=jasperfile.docx");
//        response.setContentType("application/octet-stream");
//        exporter.exportReport();
//    }
	@PostMapping("/api/document") 
    public void getDocument(HttpServletResponse response,@RequestBody SampleBean sampleBeanResponse) throws IOException, JRException {
		  this.sampleBeanResponse = new SampleBean();
		  this.sampleBeanResponse.setFullname(sampleBeanResponse.getFullname());
		  this.sampleBeanResponse.setSex(sampleBeanResponse.getSex());
	        
    }
	@GetMapping("/api/document") 
    public void getDocument2(HttpServletResponse response) throws IOException, JRException {
		
        String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "donxinvaoktxcomay.jasper")
            .getAbsolutePath();
        List<SampleBean> dataList = new ArrayList<SampleBean>();
        SampleBean sampleBean = new SampleBean();
        sampleBean.setFullname(this.sampleBeanResponse.getFullname());
        sampleBean.setSex(this.sampleBeanResponse.getSex());
        dataList.add(sampleBean);
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        Map<String, Object> parameters = new HashMap();
        parameters.put("billingAddress", "What is Lorem Ipsum?\n"
        		+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
        		+ " when an unknown printer took a galley of type and scrambled it to make a type "
        		+ "specimen book. It has survived not only five centuries, but also the leap into electronic typesetting,"
        		+ "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets "
        		+ "containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker"
        		+ " including versions of Lorem Ipsum.");
        parameters.put("shippingAddress", "What is Lorem Ipsum?\n"
        		+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
        		+ " when an unknown printer took a galley of type and scrambled it to make a type "
        		+ "specimen book. It has survived not only five centuries, but also the leap into electronic typesetting,"
        		+ "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets "
        		+ "containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker"
        		+ " including versions of Lorem Ipsum.");
        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        response.setHeader("Content-Disposition", "attachment;filename=infomation.docx");
        response.setContentType("application/octet-stream");
        exporter.exportReport();
        System.out.println("Get ok");
       
        
    }
}
