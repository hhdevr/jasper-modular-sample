package com.chaykin.jasper.sample.data;

import com.chaykin.jasper.sample.module.CompanyReport;
import com.chaykin.jasper.sample.module.DepartmentSubModule;
import com.chaykin.jasper.sample.module.ExpenseSubModule;
import com.chaykin.jasper.sample.module.FinancialSubModule;
import com.chaykin.jasper.sample.module.ProfitSubModule;
import com.chaykin.jasper.sample.module.RevenueSubModule;
import com.chaykin.jasper.sample.module.TitleSubModule;
import com.chaykin.jasper.sample.module.model.CompanyDetails;
import com.chaykin.jasper.sample.module.model.EmployeeItem;
import com.chaykin.jasper.sample.module.model.ExpenseItem;
import com.chaykin.jasper.sample.module.model.ProfitBreakdown;
import com.chaykin.jasper.sample.module.model.RevenueItem;

import java.util.List;

public class CompanyReportData {

    public static CompanyReport buildModule() {

        CompanyDetails company = new CompanyDetails();
        company.setName("Hairurg");
        company.setManager("Dmitry Chaykin");
        company.setEmail("hhdevr@google.com");
        company.setAddress("123 Main St, New York");
        company.setLogo(CompanyReportData.class.getResourceAsStream("/hairurg.png"));

        List<RevenueItem> revenueItems = List.of(
                new RevenueItem("Software Products", 520_000.0, 21.7),
                new RevenueItem("Hardware Products", 280_000.0, 11.7),
                new RevenueItem("Cloud Services", 310_000.0, 12.9),
                new RevenueItem("Consulting Services", 195_000.0, 8.1),
                new RevenueItem("Support & Maintenance", 145_000.0, 6.0),
                new RevenueItem("Training Programs", 90_000.0, 3.8),
                new RevenueItem("Licensing - Enterprise", 175_000.0, 7.3),
                new RevenueItem("Licensing - SMB", 85_000.0, 3.5),
                new RevenueItem("Marketplace Fees", 70_000.0, 2.9),
                new RevenueItem("Partner Commissions", 55_000.0, 2.3),
                new RevenueItem("Data Analytics", 240_000.0, 10.0),
                new RevenueItem("Advertising Revenue", 235_000.0, 9.8));
        double totalRevenue = revenueItems.stream().mapToDouble(RevenueItem::getAmount).sum();

        RevenueSubModule revenue = new RevenueSubModule(totalRevenue,
                                                        18.4,
                                                        revenueItems);

        List<ExpenseItem> expenseItems = List.of(
                new ExpenseItem("Engineering Salaries", 380_000.0, 22.8),
                new ExpenseItem("Sales Salaries", 210_000.0, 12.6),
                new ExpenseItem("Operations Salaries", 160_000.0, 9.6),
                new ExpenseItem("Executive Compensation", 95_000.0, 5.7),
                new ExpenseItem("Cloud Infrastructure", 130_000.0, 7.8),
                new ExpenseItem("Office & Facilities", 75_000.0, 4.5),
                new ExpenseItem("Marketing & Ads", 120_000.0, 7.2),
                new ExpenseItem("Events & Conferences", 45_000.0, 2.7),
                new ExpenseItem("R&D", 105_000.0, 6.3),
                new ExpenseItem("Legal & Compliance", 60_000.0, 3.6),
                new ExpenseItem("Finance & Accounting", 50_000.0, 3.0),
                new ExpenseItem("HR & Recruiting", 55_000.0, 3.3),
                new ExpenseItem("Software Licenses", 80_000.0, 4.8),
                new ExpenseItem("Miscellaneous", 60_000.0, 3.6));

        double totalExpenses = expenseItems.stream().mapToDouble(ExpenseItem::getAmount).sum();

        ExpenseSubModule expense = new ExpenseSubModule(totalExpenses,
                                                        11.7,
                                                        expenseItems);

        List<ProfitBreakdown> breakdownItems = List.of(
                new ProfitBreakdown("January", 580_000.0, 445_000.0, 135_000.0),
                new ProfitBreakdown("February", 610_000.0, 460_000.0, 150_000.0),
                new ProfitBreakdown("March", 650_000.0, 470_000.0, 180_000.0),
                new ProfitBreakdown("April", 620_000.0, 455_000.0, 165_000.0),
                new ProfitBreakdown("May", 670_000.0, 480_000.0, 190_000.0),
                new ProfitBreakdown("June", 700_000.0, 495_000.0, 205_000.0),
                new ProfitBreakdown("July", 680_000.0, 490_000.0, 190_000.0),
                new ProfitBreakdown("August", 710_000.0, 500_000.0, 210_000.0),
                new ProfitBreakdown("September", 730_000.0, 510_000.0, 220_000.0),
                new ProfitBreakdown("October", 760_000.0, 525_000.0, 235_000.0),
                new ProfitBreakdown("November", 790_000.0, 540_000.0, 250_000.0),
                new ProfitBreakdown("December", 900_000.0, 600_000.0, 300_000.0));

        double grossProfit = totalRevenue - totalExpenses;
        double operatingProfit = grossProfit * 0.91;
        double netProfit = grossProfit * 0.82;
        double margin = netProfit / totalRevenue * 100;

        ProfitSubModule profit = new ProfitSubModule(grossProfit,
                                                     operatingProfit,
                                                     netProfit,
                                                     margin,
                                                     breakdownItems);

        FinancialSubModule financial = new FinancialSubModule(revenue,
                                                              expense,
                                                              profit);

        TitleSubModule title = new TitleSubModule(company,
                                                  "FY 2025",
                                                  "USD",
                                                  totalRevenue,
                                                  totalExpenses,
                                                  netProfit,
                                                  List.of("Revenue grew 18.4% year over year",
                                                          "Software Products remain the largest revenue stream",
                                                          "115 employees across 5 departments"));

        List<DepartmentSubModule> departments = List.of(
                new DepartmentSubModule("Engineering", 48, 1_150_000.0, List.of(
                        new EmployeeItem("Alice Nguyen", "Staff Engineer", 165_000.0),
                        new EmployeeItem("Boris Ivanov", "Backend Engineer", 130_000.0),
                        new EmployeeItem("Chen Wei", "QA Lead", 115_000.0))),
                new DepartmentSubModule("Sales", 23, 610_000.0, List.of(
                        new EmployeeItem("Diana Lopez", "Account Executive", 95_000.0),
                        new EmployeeItem("Erik Larsen", "SDR", 60_000.0))),
                new DepartmentSubModule("Operations", 17, 430_000.0, List.of(
                        new EmployeeItem("Fatima Khan", "Ops Manager", 105_000.0),
                        new EmployeeItem("Georg Weber", "Logistics", 78_000.0))),
                new DepartmentSubModule("Marketing", 12, 320_000.0, List.of(
                        new EmployeeItem("Hana Sato", "Brand Lead", 98_000.0),
                        new EmployeeItem("Igor Petrov", "Content", 72_000.0))),
                new DepartmentSubModule("R&D", 15, 540_000.0, List.of(
                        new EmployeeItem("Julia Costa", "Research Lead", 140_000.0),
                        new EmployeeItem("Kenji Mori", "ML Engineer", 125_000.0))));

        return new CompanyReport(title, financial, departments);
    }

}
