package Accenture;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

// Class implementing IExchangeRateData
class ExchangeRateData implements IExchangeRateData {
    private String currencyPair;
    private double rate;
    private LocalDate date;

    // Constructor
    public ExchangeRateData(String currencyPair, double rate, LocalDate date) {
        this.currencyPair = currencyPair;
        this.rate = rate;
        this.date = date;
    }

    // Getters
    public String getCurrencyPair() {
        return currencyPair;
    }

    public double getRate() {
        return rate;
    }

    public LocalDate getDate() {
        return date;
    }
}

// Class implementing IExchangeRateAnalyzer
class ExchangeRateAnalyzer implements IExchangeRateAnalyzer {
    @Override
    public Double filterExchangeRates(List<IExchangeRateData> exchangeRates,
                                      String currencyPair,
                                      LocalDate startDate,
                                      LocalDate endDate) {
        double sum = 0.0;
        int count = 0;

        for (IExchangeRateData data : exchangeRates) {
            if (data.getCurrencyPair().equals(currencyPair)) {
                LocalDate date = data.getDate();
                if ((date.isEqual(startDate) || date.isAfter(startDate)) &&
                        (date.isEqual(endDate) || date.isBefore(endDate))) {
                    sum += data.getRate();
                    count++;
                }
            }
        }

        if (count == 0) return null; // no data found for given filter

        double avg = sum / count;
        return Math.round(avg * 100.0) / 100.0; // round to 2 decimal places
    }
}

// Main class handling input/output
public class CurrencyExchangeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<IExchangeRateData> exchangeRates = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Read n exchange rate entries
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String pair = parts[0];
            double rate = Double.parseDouble(parts[1]);
            LocalDate date = LocalDate.parse(parts[2], formatter);
            exchangeRates.add(new ExchangeRateData(pair, rate, date));
        }

        String currencyPair = sc.nextLine().trim();
        LocalDate startDate = LocalDate.parse(sc.nextLine().trim(), formatter);
        LocalDate endDate = LocalDate.parse(sc.nextLine().trim(), formatter);

        IExchangeRateAnalyzer analyzer = new ExchangeRateAnalyzer();
        Double avgRate = analyzer.filterExchangeRates(exchangeRates, currencyPair, startDate, endDate);

        if (avgRate == null)
            System.out.println("0.00");
        else
            System.out.printf("%.2f\n", avgRate);
    }
}

// ---- Interfaces ----
interface IExchangeRateData {
    String getCurrencyPair();
    double getRate();
    LocalDate getDate();
}

interface IExchangeRateAnalyzer {
    Double filterExchangeRates(List<IExchangeRateData> exchangeRates,
                               String currencyPair,
                               LocalDate startDate,
                               LocalDate endDate);
}
