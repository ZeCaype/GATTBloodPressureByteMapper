package com.levio.lab.bt.services.bloodpressure.measurement;

public class BloodPressureMeasurementStatusDto {

  private boolean hasBodyMovement;
  private boolean isCuffToLoose;
  private boolean irregularPulseDetected;
  private String pulseRateRangeDetectionFlag;
  private boolean hasImproperMeasurementPosition;

  public BloodPressureMeasurementStatusDto() {

  }

  public boolean isHasBodyMovement() {
    return hasBodyMovement;
  }

  public void setHasBodyMovement(boolean hasBodyMovement) {
    this.hasBodyMovement = hasBodyMovement;
  }

  public boolean isCuffToLoose() {
    return isCuffToLoose;
  }

  public void setCuffToLoose(boolean isCuffToLoose) {
    this.isCuffToLoose = isCuffToLoose;
  }

  public boolean isIrregularPulseDetected() {
    return irregularPulseDetected;
  }

  public void setIrregularPulseDetected(boolean irregularPulseDetected) {
    this.irregularPulseDetected = irregularPulseDetected;
  }

  public String getPulseRateRangeDetectionFlag() {
    return pulseRateRangeDetectionFlag;
  }

  public void setPulseRateRangeDetectionFlag(String pulseRateRangeDetectionFlag) {
    this.pulseRateRangeDetectionFlag = pulseRateRangeDetectionFlag;
  }

  public boolean isHasImproperMeasurementPosition() {
    return hasImproperMeasurementPosition;
  }

  public void setHasImproperMeasurementPosition(boolean hasImproperMeasurementPosition) {
    this.hasImproperMeasurementPosition = hasImproperMeasurementPosition;
  }

}
