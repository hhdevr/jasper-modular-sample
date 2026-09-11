package com.chaykin.jasper.sample.module;

import com.chaykin.jasper.core.annotation.CollectionComponentType;
import com.chaykin.jasper.core.annotation.JasperCollection;
import com.chaykin.jasper.core.annotation.JasperSubreport;
import com.chaykin.jasper.core.model.SubreportModule;
import com.chaykin.jasper.sample.module.model.ProfitBreakdown;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JasperSubreport(templatePath = "/reports/sub_profit_report.jrxml")
public class ProfitSubModule extends SubreportModule {

    private Double grossProfit;

    private Double operatingProfit;

    private Double netProfit;

    private Double margin;

    @JasperCollection(type = CollectionComponentType.LIST, columnWidth = 125)
    private List<ProfitBreakdown> breakdown;

    @Override
    public boolean isEmpty() {
        return netProfit == null;
    }

}
