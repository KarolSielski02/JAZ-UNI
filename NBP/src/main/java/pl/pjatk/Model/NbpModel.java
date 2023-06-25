package pl.pjatk.Model;

import jakarta.persistence.*;

@Entity
public class NbpModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "query_time")
    private String queryTime;
    @Column(name = "currency")
    private String currency;
    @Column(name = "average")
    private double average;

    public NbpModel(int id, String startDate, String endDate, String queryTime, String currency, double average) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.queryTime = queryTime;
        this.currency = currency;
        this.average = average;
    }

    public NbpModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "NbpModel{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", queryTime='" + queryTime + '\'' +
                ", currency='" + currency + '\'' +
                ", average=" + average +
                '}';
    }
}
