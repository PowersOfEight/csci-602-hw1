package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class HourlyEmployee extends Employee {

  private double wageRate;
  private double hoursWorked;

  public HourlyEmployee(String name,
      LocalDate hireDate,
      double wageRate,
      double hoursWorked) {
    super(name, hireDate);
    this.wageRate = wageRate;
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double getMonthlyPay() {
    return (this.wageRate * this.hoursWorked);
  }

  public double getWageRate() {
    return wageRate;
  }

  public double getHoursWorked() {
    return hoursWorked;
  }

  @Override
  public String toString() {
    return String.format(
        "HourlyEmployee[name=%s, hireDate=%s, wageRate=%0.1f, hoursWorked=%0.1f]",
        this.getName(),
        this.getHireDate(),
        this.wageRate,
        this.hoursWorked);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(wageRate);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(hoursWorked);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    // TODO: get feedback for functional equals implementation
    return Optional.ofNullable(obj)
        .filter(o -> o.getClass().equals(this.getClass()))
        .map(o -> (HourlyEmployee) o)
        .filter(other -> other.getName().equals(this.getName()))
        .filter(other -> other.getHireDate().equals(this.getHireDate()))
        .filter(other -> Double.compare(
            other.getWageRate(), this.getWageRate()) == 0)
        .filter(other -> Double.compare(
            other.getHoursWorked(), this.getHoursWorked()) == 0)
        .map(same -> true)
        .orElse(false);
  }

}
