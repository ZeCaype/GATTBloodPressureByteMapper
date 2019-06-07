package com.levio.cil.accuchek.rest.controllers;

public class MeasurementStatusDto {

  private boolean hasBodyMovement;
  private boolean isCuffTooLoose;
  private boolean irregularPulseDetected;
  private String pulseRateDetection;
  private boolean hasImproperMeasurementPosition;
  
  public MeasurementStatusDto() {
    
  }

  public boolean isHasBodyMovement() {
    return hasBodyMovement;
  }

  public void setHasBodyMovement(boolean hasBodyMovement) {
    this.hasBodyMovement = hasBodyMovement;
  }

  public boolean isCuffTooLoose() {
    return isCuffTooLoose;
  }

  public void setCuffTooLoose(boolean isCuffTooLoose) {
    this.isCuffTooLoose = isCuffTooLoose;
  }

  public boolean isIrregularPulseDetected() {
    return irregularPulseDetected;
  }

  public void setIrregularPulseDetected(boolean irregularPulseDetected) {
    this.irregularPulseDetected = irregularPulseDetected;
  }

  public String getPulseRateDetection() {
    return pulseRateDetection;
  }

  public void setPulseRateDetection(String pulseRateDetection) {
    this.pulseRateDetection = pulseRateDetection;
  }

  public boolean isHasImproperMeasurementPosition() {
    return hasImproperMeasurementPosition;
  }

  public void setHasImproperMeasurementPosition(boolean hasImproperMeasurementPosition) {
    this.hasImproperMeasurementPosition = hasImproperMeasurementPosition;
  }
  
}
