package com.levio.cil.accuchek.dto;

import org.springframework.stereotype.Component;
import com.levio.cil.accuchek.rest.controllers.BloodPressureMeasurementDto;
import com.levio.cil.accuchek.rest.utils.ByteUtils;

@Component
public class BloodPressureMeasurementBytesMapper {

  public BloodPressureMeasurementBytesMapper() {

  }

  public BloodPressureMeasurementDto mapArrayOfBytesToReadableData(byte[] dataDto) {
    BloodPressureMeasurementDto bloodPressureMeasurement = new BloodPressureMeasurementDto();

    BloodPressureMeasurementFlagsDto flags = new BloodPressureMeasurementFlagsDto();
    int position = 0;

    setFlagsFromRawData(dataDto, flags, position);
    bloodPressureMeasurement.setFlags(flags);
    position = setCompundValuesFromRawData(dataDto, bloodPressureMeasurement, flags, position);
    position = setYearFromRawData(dataDto, bloodPressureMeasurement, position);
    

    return bloodPressureMeasurement;
  }

  private int setYearFromRawData(byte[] bytes, BloodPressureMeasurementDto bloodPressure, int position) {
    String rawSequenceNumberBits = ByteUtils.byteToBinaryString(bytes, position + 1) + ByteUtils.byteToBinaryString(bytes, position);
    int year = Integer.parseInt(rawSequenceNumberBits, 2);
    bloodPressure.setYear(year);
    position = position + 2;
    
    return position;
  }
  
  private int setCompundValuesFromRawData(byte[] dataDto,
      BloodPressureMeasurementDto bloodPressureMeasurement, BloodPressureMeasurementFlagsDto flags,
      int position) {
    if (flags.isBloodPressureUnitInKpa()) {
      bloodPressureMeasurement
          .setMmHgSystolicValue(ByteUtils.SFLOAT16Parser(dataDto[position], dataDto[position + 1]));
      bloodPressureMeasurement.setMmHgDiastolicValue(
          ByteUtils.SFLOAT16Parser(dataDto[position + 2], dataDto[position + 3]));
      bloodPressureMeasurement.setMmHgMeanArterialPressureValue(
          ByteUtils.SFLOAT16Parser(dataDto[position + 4], dataDto[position + 5]));
      position = position + 6;

    } else {
      bloodPressureMeasurement
          .setkPaSystolicValue(ByteUtils.SFLOAT16Parser(dataDto[position], dataDto[position + 1]));
      bloodPressureMeasurement.setkPaDiastolicValue(
          ByteUtils.SFLOAT16Parser(dataDto[position + 2], dataDto[position + 3]));
      bloodPressureMeasurement.setkPaMeanArterialPressureValue(
          ByteUtils.SFLOAT16Parser(dataDto[position + 4], dataDto[position + 5]));
      position = position + 6;
    }
    return position;
  }

  private void setFlagsFromRawData(byte[] dataDto, BloodPressureMeasurementFlagsDto flags,
      int position) {
    String rawBits = ByteUtils.byteToBinaryString(dataDto, position);
    rawBits = new StringBuilder(rawBits).reverse().toString();

    int bitCount = 0;

    for (char bit : rawBits.toCharArray()) {
      switch (bitCount) {
        case 0:
          flags.setBloodPressureUnitInKpa(ByteUtils.binaryCharToBoolean(bit));
        case 1:
          flags.setTimeStampFlagPresent(ByteUtils.binaryCharToBoolean(bit));
        case 2:
          flags.setPulseRateFlagPresent(ByteUtils.binaryCharToBoolean(bit));
        case 3:
          flags.setUserIdFlagPresent(ByteUtils.binaryCharToBoolean(bit));
          break;
        case 4:
          flags.setMeasurementStatusFlagPresent(ByteUtils.binaryCharToBoolean(bit));
          break;
        default:
          break;
      }
      bitCount++;
    }
    position++;
  }
}
