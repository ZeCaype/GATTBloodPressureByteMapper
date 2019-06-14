package com.levio.lab.bt.services.bloodpressure.measurement;

public class BloodPressureMeasurementFlagsDto {

  private boolean isBloodPressureUnitInKpa;
  private boolean isTimeStampFlagPresent;
  private boolean isPulseRateFlagPresent;
  private boolean isUserIdFlagPresent;
  private boolean isMeasurementStatusFlagPresent;

  public BloodPressureMeasurementFlagsDto() {

  }

  public boolean isBloodPressureUnitInKpa() {
    return isBloodPressureUnitInKpa;
  }

  public void setBloodPressureUnitInKpa(boolean isBloodPressureUnitInKpa) {
    this.isBloodPressureUnitInKpa = isBloodPressureUnitInKpa;
  }

  public boolean isTimeStampFlagPresent() {
    return isTimeStampFlagPresent;
  }

  public void setTimeStampFlagPresent(boolean isTimeStampFlagPresent) {
    this.isTimeStampFlagPresent = isTimeStampFlagPresent;
  }

  public boolean isPulseRateFlagPresent() {
    return isPulseRateFlagPresent;
  }

  public void setPulseRateFlagPresent(boolean isPulseRateFlagPresent) {
    this.isPulseRateFlagPresent = isPulseRateFlagPresent;
  }

  public boolean isUserIdFlagPresent() {
    return isUserIdFlagPresent;
  }

  public void setUserIdFlagPresent(boolean isUserIdFlagPresent) {
    this.isUserIdFlagPresent = isUserIdFlagPresent;
  }

  public boolean isMeasurementStatusFlagPresent() {
    return isMeasurementStatusFlagPresent;
  }

  public void setMeasurementStatusFlagPresent(boolean isMeasurementStatusFlagPresent) {
    this.isMeasurementStatusFlagPresent = isMeasurementStatusFlagPresent;
  }

}
