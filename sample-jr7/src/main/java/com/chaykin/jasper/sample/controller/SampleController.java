package com.chaykin.jasper.sample.controller;

import com.chaykin.jasper.core.exception.JasperModularException;
import com.chaykin.jasper.core.renderer.JasperModularRenderer;
import com.chaykin.jasper.sample.data.CompanyReportData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<Resource> printPdf() throws JasperModularException, JRException {
        JasperPrint print = new JasperModularRenderer().render(CompanyReportData.buildModule());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        JasperExportManager.exportReportToPdfStream(print, outputStream);

        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION,
                                     "attachment; filename=financial_report.pdf")
                             .body(new ByteArrayResource(outputStream.toByteArray()));
    }

    @GetMapping(value = "/xlsx")
    public ResponseEntity<Resource> printXlsx() throws JasperModularException, JRException {
        JasperPrint print = new JasperModularRenderer().render(CompanyReportData.buildModule());

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
        exporter.exportReport();

        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION,
                                     "attachment; filename=financial_report.xlsx")
                             .contentType(MediaType.parseMediaType(
                                     "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                             .body(new ByteArrayResource(out.toByteArray()));
    }

}
