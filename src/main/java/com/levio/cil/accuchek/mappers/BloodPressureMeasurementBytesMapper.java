package com.levio.cil.accuchek.mappers;

import org.springframework.stereotype.Component;
import com.levio.cil.accuchek.dto.BloodPressureMeasurementDto;
import com.levio.cil.accuchek.dto.BloodPressureMeasurementFlagsDto;
import com.levio.cil.accuchek.dto.BloodPressureMeasurementStatusDto;
import com.levio.cil.accuchek.rest.utils.ByteUtils;

@Component
public class BloodPressureMeasurementBytesMapper {

  public BloodPressureMeasurementBytesMapper() {

  }

  public BloodPressureMeasurementDto mapArrayOfBytesToReadableData(byte[] dataDto) {
    BloodPressureMeasurementDto bloodPressureMeasurement = new BloodPressureMeasurementDto();
    BloodPressureMeasurementStatusDto status = new BloodPressureMeasurementStatusDto();
    BloodPressureMeasurementFlagsDto flags = new BloodPressureMeasurementFlagsDto();
    int position = 0;

    setFlagsFromRawData(dataDto, flags, position);
    bloodPressureMeasurement.setFlags(flags);
    position = setCompundValuesFromRawData(dataDto, bloodPressureMeasurement, flags, position);

    if (flags.isTimeStampFlagPresent()) {
      position = setYearFromRawData(dataDto, bloodPressureMeasurement, position);
      position = setMonthFromRawData(dataDto, bloodPressureMeasurement, position);
      position = setDayFromRawData(dataDto, bloodPressureMeasurement, position);
      position = setHoursFromRawData(dataDto, bloodPressureMeasurement, position);
      position = setMinutesFromRawData(dataDto, bloodPressureMeasurement, position);
      position = setSecondsFromRawData(dataDto, bloodPressureMeasurement, position);
    }

    if (flags.isPulseRateFlagPresent()) {
      position = setPulseRate(dataDto, bloodPressureMeasurement, position);
    }

    if (flags.isUserIdFlagPresent()) {
      position = setUserIdFromRawData(dataDto, bloodPressureMeasurement, position);
    }

    setMeasurementStatusFromRawData(dataDto, bloodPressureMeasurement, status, flags, position);

    return bloodPressureMeasurement;
  }

  private void setMeasurementStatusFromRawData(byte[] dataDto,
      BloodPressureMeasurementDto bloodPressureMeasurement,
      BloodPressureMeasurementStatusDto status, BloodPressureMeasurementFlagsDto flags,
      int position) {
    
    if (flags.isMeasurementStatusFlagPresent()) {

      String rawFlagsBits1 = ByteUtils.byteToBinaryString(dataDto, position);
      String rawFlagsBits2 = ByteUtils.byteToBinaryString(dataDto, position + 1);
      String rawFlagsBits = new StringBuilder(rawFlagsBits2).reverse().toString() + new StringBuilder(rawFlagsBits1).reverse().toString();
      int bitCount = 0;
      String pulseRateRangeDetectionFlags = "";

      for (char bit : rawFlagsBits.toCharArray()) {
        switch (bitCount) {
          case 0:
            status.setHasBodyMovement(ByteUtils.binaryCharToBoolean(bit));
            break;
          case 1:
            status.setCuffToLoose(ByteUtils.binaryCharToBoolean(bit));
            break;
          case 2:
            status.setIrregularPulseDetected(ByteUtils.binaryCharToBoolean(bit));
            break;
          case 3:
            pulseRateRangeDetectionFlags = pulseRateRangeDetectionFlags + bit;
            break;
          case 4:
            pulseRateRangeDetectionFlags = pulseRateRangeDetectionFlags + bit;
            pulseRateRangeDetectionFlags = new StringBuilder(pulseRateRangeDetectionFlags).reverse().toString();
            int pulseRate = Integer.parseInt(pulseRateRangeDetectionFlags, 2);
            setPulseRateValue(status, pulseRate);
            break;
          case 5:
            status.setHasImproperMeasurementPosition(ByteUtils.binaryCharToBoolean(bit));
            break;
          default:
            break;
        }
        bitCount++;
      }
      position = position + 2;
      bloodPressureMeasurement.setMeasurementStatus(status);
    }
  }

  private void setPulseRateValue(BloodPressureMeasurementStatusDto status, int pulseRate) {
    switch (pulseRate) {
      case 0:
        status.setPulseRateRangeDetectionFlag("Pulse rate is within the range.");
        break;
      case 1:
        status.setPulseRateRangeDetectionFlag("Pulse rate exceeds upper limit.");
        break;
      case 2:
        status.setPulseRateRangeDetectionFlag("Pulse rate is less than lower limit.");
        break;
      default:
        break;
    }
  }

  private int setUserIdFromRawData(byte[] dataDto,
      BloodPressureMeasurementDto bloodPressureMeasurement, int position) {
    String rawSequenceNumberBits = ByteUtils.byteToBinaryString(dataDto, position);
    int userId = Integer.parseInt(rawSequenceNumberBits, 2);
    bloodPressureMeasurement.setUserId(userId);
    position++;

    return position;
  }

  private int setPulseRate(byte[] dataDto, BloodPressureMeasurementDto bloodPressureMeasurement,
      int position) {
    bloodPressureMeasurement
        .setPulseRate(ByteUtils.SFLOAT16Parser(dataDto[position], dataDto[position + 1]));
    position = position + 2;
    return position;
  }

  private int setSecondsFromRawData(byte[] dataDto,
      BloodPressureMeasurementDto bloodPressureMeasurement, int position) {
    String rawSequenceNumberBits = ByteUtils.byteToBinaryString(dataDto, position);
    int seconds = Integer.parseInt(rawSequenceNumberBits, 2);
    bloodPressureMeasurement.setSecond(seconds);
    position++;

    return position;
  }

  private int setMinutesFromRawData(byte[] dataDto,
      BloodPressureMeasurementDto bloodPressureMeasurement, int position) {
    String rawSequenceNumberBits = ByteUtils.byteToBinaryString(dataDto, position);
    int minutes = Integer.parseInt(rawSequenceNumberBits, 2);
    bloodPressureMeasurement.setMinute(minutes);
    position++;

    return position;
  }

  private int setHoursFromRawData(byte[] dataDto,
      BloodPressureMeasurementDto bloodPressureMeasurement, int position) {
    String rawSequenceNumberBits = ByteUtils.byteToBinaryString(dataDto, position);
    int hours = Integer.parseInt(rawSequenceNumberBits, 2);
    bloodPressureMeasurement.setHour(hours);
    position++;

    return position;
  }

  private int setDayFromRawData(byte[] dataDto,
      BloodPressureMeasurementDto bloodPressureMeasurement, int position) {
    String rawSequenceNumberBits = ByteUtils.byteToBinaryString(dataDto, position);
    int day = Integer.parseInt(rawSequenceNumberBits, 2);
    bloodPressureMeasurement.setDay(day);
    position++;

    return position;
  }

  private int setMonthFromRawData(byte[] dataDto,
      BloodPressureMeasurementDto bloodPressureMeasurement, int position) {
    String rawSequenceNumberBits = ByteUtils.byteToBinaryString(dataDto, position);
    int month = Integer.parseInt(rawSequenceNumberBits, 2);
    bloodPressureMeasurement.setMonth(month);
    position++;

    return position;
  }

  private int setYearFromRawData(byte[] bytes, BloodPressureMeasurementDto bloodPressure,
      int position) {
    String rawSequenceNumberBits = ByteUtils.byteToBinaryString(bytes, position + 1)
        + ByteUtils.byteToBinaryString(bytes, position);
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
