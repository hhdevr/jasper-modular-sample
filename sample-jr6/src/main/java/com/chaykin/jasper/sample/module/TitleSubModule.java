package com.chaykin.jasper.sample.module;

import com.chaykin.jasper.core.annotation.JasperSubreport;
import com.chaykin.jasper.core.model.SubreportModule;
import com.chaykin.jasper.sample.module.model.CompanyDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JasperSubreport(templatePath = "/reports/sub_title_report.jrxml")
public class TitleSubModule extends SubreportModule {

    private CompanyDetails companyDetails;

    private String period;

    private String currency;

    private Double totalRevenue;

    private Double totalExpenses;

    private Double netProfit;

    private List<String> highlights;

    @Override
    public boolean isEmpty() {
        return totalRevenue == null;
    }

}
