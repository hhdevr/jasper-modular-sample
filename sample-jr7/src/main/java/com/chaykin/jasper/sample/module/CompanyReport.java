package com.chaykin.jasper.sample.module;

import com.chaykin.jasper.core.annotation.JasperModularReport;
import com.chaykin.jasper.core.model.ModularReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JasperModularReport(templatePath = "/reports/company_report.jrxml")
public class CompanyReport extends ModularReport {

    private TitleSubModule title;

    private FinancialSubModule financial;

    private List<DepartmentSubModule> departments;

}
