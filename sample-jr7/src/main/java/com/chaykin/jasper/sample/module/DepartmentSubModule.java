package com.chaykin.jasper.sample.module;

import com.chaykin.jasper.core.annotation.JasperCollection;
import com.chaykin.jasper.core.annotation.JasperSubreport;
import com.chaykin.jasper.core.model.SubreportModule;
import com.chaykin.jasper.sample.module.model.EmployeeItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JasperSubreport(templatePath = "/reports/sub_department_report.jrxml")
public class DepartmentSubModule extends SubreportModule {

    private String name;

    private Integer headcount;

    private Double budget;

    @JasperCollection(columnWidth = 170)
    private List<EmployeeItem> employees;

    @Override
    public boolean isEmpty() {
        return name == null;
    }

}
