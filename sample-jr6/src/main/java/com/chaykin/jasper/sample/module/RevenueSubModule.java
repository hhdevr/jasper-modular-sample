package com.chaykin.jasper.sample.module;

import com.chaykin.jasper.core.annotation.JasperSubreport;
import com.chaykin.jasper.core.model.SubreportModule;
import com.chaykin.jasper.sample.module.model.RevenueItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JasperSubreport(templatePath = "/reports/sub_revenue_report.jrxml")
public class RevenueSubModule extends SubreportModule {

    private Double totalRevenue;

    private Double growthPercent;

    private List<RevenueItem> items;

    @Override
    public boolean isEmpty() {
        return items == null || items.isEmpty();
    }

}
