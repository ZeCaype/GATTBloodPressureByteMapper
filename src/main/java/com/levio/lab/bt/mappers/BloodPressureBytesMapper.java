package com.levio.lab.bt.mappers;

import com.levio.lab.bt.services.bloodpressure.feature.BloodPressureFeatureDto;
import com.levio.lab.bt.services.bloodpressure.measurement.BloodPressureMeasurementDto;

public class BloodPressureBytesMapper {

  public BloodPressureBytesMapper() {

  }

  public BloodPressureFeatureDto mapBloodPressureFeature(byte[] bytes) {
    return BloodPressureFeatureBytesMapper.mapArrayOfBytesToReadableData(bytes);
  }

  public BloodPressureMeasurementDto mapBloodPressureMeasurement(byte[] bytes) {
    return BloodPressureMeasurementBytesMapper.mapArrayOfBytesToReadableData(bytes);
  }

}
