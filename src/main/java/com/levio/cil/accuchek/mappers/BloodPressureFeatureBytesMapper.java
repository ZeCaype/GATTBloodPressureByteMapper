package com.levio.cil.accuchek.mappers;

import com.levio.cil.accuchek.dto.BloodPressureFeatureDto;
import com.levio.cil.accuchek.rest.utils.ByteUtils;

class BloodPressureFeatureBytesMapper {

  static BloodPressureFeatureDto mapArrayOfBytesToReadableData(byte[] dataDto) {

    BloodPressureFeatureDto bloodFeature = new BloodPressureFeatureDto();

    String rawBloodPressureFeatureByte1 = ByteUtils.byteToBinaryString(dataDto, 0);
    String rawBloodPressureFeatureByte2 = ByteUtils.byteToBinaryString(dataDto, 1);
    rawBloodPressureFeatureByte1 = new StringBuilder(rawBloodPressureFeatureByte1).reverse().toString();
    rawBloodPressureFeatureByte2 = new StringBuilder(rawBloodPressureFeatureByte2).reverse().toString();
    int bitCount = 0;

    for (char bit : rawBloodPressureFeatureByte1.toCharArray()) {
      switch (bitCount) {
        case 0:
          bloodFeature.setBodyMovementDetectionSupported(ByteUtils.binaryCharToBoolean(bit));
          break;
        case 1:
          bloodFeature.setCuffFitDetectionSupported(ByteUtils.binaryCharToBoolean(bit));
          break;
        case 2:
          bloodFeature.setIrregularPulseDetectionSupported(ByteUtils.binaryCharToBoolean(bit));
          break;
        case 3:
          bloodFeature.setPulseRateRangeDetectionSupported(ByteUtils.binaryCharToBoolean(bit));
          break;
        case 4:
          bloodFeature.setMeasurementPositionDetectionSupported(ByteUtils.binaryCharToBoolean(bit));
          break;
        case 5:
          bloodFeature.setMultipleBondSupported(ByteUtils.binaryCharToBoolean(bit));
          break;
        default:
          break;
      }
      bitCount++;
    }
    bitCount = 0;

    return bloodFeature;
  }
}
