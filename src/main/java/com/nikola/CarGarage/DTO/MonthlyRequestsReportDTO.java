package com.nikola.CarGarage.DTO;

public class MonthlyRequestsReportDTO {
    private String yearMonth;
    private int requests;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public int getRequests() {
        return requests;
    }

    public void setRequests(int requests) {
        this.requests = requests;
    }
}