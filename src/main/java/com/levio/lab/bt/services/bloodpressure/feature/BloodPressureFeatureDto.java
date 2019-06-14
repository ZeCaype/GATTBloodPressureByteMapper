package com.levio.lab.bt.services.bloodpressure.feature;

public class BloodPressureFeatureDto {

  private boolean isBodyMovementDetectionSupported;
  private boolean isCuffFitDetectionSupported;
  private boolean isIrregularPulseDetectionSupported;
  private boolean isPulseRateRangeDetectionSupported;
  private boolean isMeasurementPositionDetectionSupported;
  private boolean isMultipleBondSupported;

  public BloodPressureFeatureDto() {

  }

  public boolean isBodyMovementDetectionSupported() {
    return isBodyMovementDetectionSupported;
  }

  public void setBodyMovementDetectionSupported(boolean isBodyMovementDetectionSupported) {
    this.isBodyMovementDetectionSupported = isBodyMovementDetectionSupported;
  }

  public boolean isCuffFitDetectionSupported() {
    return isCuffFitDetectionSupported;
  }

  public void setCuffFitDetectionSupported(boolean isCuffFitDetectionSupported) {
    this.isCuffFitDetectionSupported = isCuffFitDetectionSupported;
  }

  public boolean isIrregularPulseDetectionSupported() {
    return isIrregularPulseDetectionSupported;
  }

  public void setIrregularPulseDetectionSupported(boolean isIrregularPulseDetectionSupported) {
    this.isIrregularPulseDetectionSupported = isIrregularPulseDetectionSupported;
  }

  public boolean isPulseRateRangeDetectionSupported() {
    return isPulseRateRangeDetectionSupported;
  }

  public void setPulseRateRangeDetectionSupported(boolean isPulseRateRangeDetectionSupported) {
    this.isPulseRateRangeDetectionSupported = isPulseRateRangeDetectionSupported;
  }

  public boolean isMeasurementPositionDetectionSupported() {
    return isMeasurementPositionDetectionSupported;
  }

  public void setMeasurementPositionDetectionSupported(
      boolean isMeasurementPositionDetectionSupported) {
    this.isMeasurementPositionDetectionSupported = isMeasurementPositionDetectionSupported;
  }

  public boolean isMultipleBondSupported() {
    return isMultipleBondSupported;
  }

  public void setMultipleBondSupported(boolean isMultipleBondSupported) {
    this.isMultipleBondSupported = isMultipleBondSupported;
  }

}
