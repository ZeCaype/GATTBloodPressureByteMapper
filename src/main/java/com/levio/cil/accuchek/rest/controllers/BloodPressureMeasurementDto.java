package com.levio.cil.accuchek.rest.controllers;

import com.levio.cil.accuchek.dto.BloodPressureMeasurementFlagsDto;

public class BloodPressureMeasurementDto {

  private BloodPressureMeasurementFlagsDto flags;
  private float mmHgSystolicValue;
  private float mmHgDiastolicValue;
  private float mmHgMeanArterialPressureValue;
  private float kPaSystolicValue;
  private float kPaDiastolicValue;
  private float kPaMeanArterialPressureValue;
  private int year;
  private int month;
  private int day;
  private int hour;
  private int minute;
  private int second;
  private float pulseRate;
  private int userId;
  private MeasurementStatusDto measurementStatus;

  public BloodPressureMeasurementDto() {

  }

  public BloodPressureMeasurementFlagsDto getFlags() {
    return flags;
  }

  public void setFlags(BloodPressureMeasurementFlagsDto flags) {
    this.flags = flags;
  }

  public float getMmHgSystolicValue() {
    return mmHgSystolicValue;
  }

  public void setMmHgSystolicValue(float mmHgSystolicValue) {
    this.mmHgSystolicValue = mmHgSystolicValue;
  }

  public float getMmHgDiastolicValue() {
    return mmHgDiastolicValue;
  }

  public void setMmHgDiastolicValue(float mmHgDiastolicValue) {
    this.mmHgDiastolicValue = mmHgDiastolicValue;
  }

  public float getMmHgMeanArterialPressureValue() {
    return mmHgMeanArterialPressureValue;
  }

  public void setMmHgMeanArterialPressureValue(float mmHgMeanArterialPressureValue) {
    this.mmHgMeanArterialPressureValue = mmHgMeanArterialPressureValue;
  }

  public float getkPaSystolicValue() {
    return kPaSystolicValue;
  }

  public void setkPaSystolicValue(float kPaSystolicValue) {
    this.kPaSystolicValue = kPaSystolicValue;
  }

  public float getkPaDiastolicValue() {
    return kPaDiastolicValue;
  }

  public void setkPaDiastolicValue(float kPaDiastolicValue) {
    this.kPaDiastolicValue = kPaDiastolicValue;
  }

  public float getkPaMeanArterialPressureValue() {
    return kPaMeanArterialPressureValue;
  }

  public void setkPaMeanArterialPressureValue(float kPaMeanArterialPressureValue) {
    this.kPaMeanArterialPressureValue = kPaMeanArterialPressureValue;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
  }

  public float getPulseRate() {
    return pulseRate;
  }

  public void setPulseRate(float pulseRate) {
    this.pulseRate = pulseRate;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public MeasurementStatusDto getMeasurementStatus() {
    return measurementStatus;
  }

  public void setMeasurementStatus(MeasurementStatusDto measurementStatus) {
    this.measurementStatus = measurementStatus;
  }

}
