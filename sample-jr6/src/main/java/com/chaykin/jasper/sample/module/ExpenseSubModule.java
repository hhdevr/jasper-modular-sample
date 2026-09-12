package com.chaykin.jasper.sample.module;

import com.chaykin.jasper.core.annotation.JasperSubreport;
import com.chaykin.jasper.core.model.SubreportModule;
import com.chaykin.jasper.sample.module.model.ExpenseItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JasperSubreport(templatePath = "/reports/sub_expense_report.jrxml")
public class ExpenseSubModule extends SubreportModule {

    private Double totalExpenses;

    private Double growthPercent;

    private List<ExpenseItem> items;

    @Override
    public boolean isEmpty() {
        return items == null || items.isEmpty();
    }

}
