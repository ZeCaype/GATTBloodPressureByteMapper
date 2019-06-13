package com.levio.cil.accuchek.mappers;

import com.levio.cil.accuchek.dto.BloodPressureFeatureDto;
import com.levio.cil.accuchek.dto.BloodPressureMeasurementDto;

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
