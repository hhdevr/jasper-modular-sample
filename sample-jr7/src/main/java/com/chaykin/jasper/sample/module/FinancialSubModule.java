package com.chaykin.jasper.sample.module;

import com.chaykin.jasper.core.annotation.JasperSubreport;
import com.chaykin.jasper.core.model.SubreportModule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JasperSubreport(templatePath = "/reports/sub_financial_report.jrxml")
public class FinancialSubModule extends SubreportModule {

    private RevenueSubModule revenue;

    private ExpenseSubModule expense;

    private ProfitSubModule profit;

    @Override
    public boolean isEmpty() {
        return revenue == null;
    }

}
