package com.levio.lab.bt.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.levio.lab.bt.mappers.BloodPressureBytesMapper;
import com.levio.lab.bt.services.bloodpressure.feature.BloodPressureFeatureDto;
import com.levio.lab.bt.services.bloodpressure.measurement.BloodPressureMeasurementDto;

public class BloodPressureBytesMapperTest {

  private byte[] bytes = {1, 1};
  private byte[] bytes_second = {63, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
  private BloodPressureBytesMapper underTest;

  @Before
  public void setup() {
    underTest = new BloodPressureBytesMapper();
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingBodyMovementDetection_thenCorrectValueIsMapped() {
    BloodPressureFeatureDto result = underTest.mapBloodPressureFeature(bytes);

    assertTrue(result.isBodyMovementDetectionSupported());
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingCuffFitDetection_thenCorrectValueIsMapped() {
    BloodPressureFeatureDto result = underTest.mapBloodPressureFeature(bytes);

    assertFalse(result.isCuffFitDetectionSupported());
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingIrregularPulseDetection_thenCorrectValueIsMapped() {
    BloodPressureFeatureDto result = underTest.mapBloodPressureFeature(bytes);

    assertFalse(result.isIrregularPulseDetectionSupported());
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingPulseRateRangeDetection_thenCorrectValueIsMapped() {
    BloodPressureFeatureDto result = underTest.mapBloodPressureFeature(bytes);

    assertFalse(result.isPulseRateRangeDetectionSupported());
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingMeasurementPositionDetection_thenCorrectValueIsMapped() {
    BloodPressureFeatureDto result = underTest.mapBloodPressureFeature(bytes);

    assertFalse(result.isMeasurementPositionDetectionSupported());
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingMultipleBond_thenCorrectValueIsMapped() {
    BloodPressureFeatureDto result = underTest.mapBloodPressureFeature(bytes);

    assertFalse(result.isMultipleBondSupported());
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingFlags_thenCorrectValueIsMapped() {
    BloodPressureMeasurementDto result = underTest.mapBloodPressureMeasurement(bytes_second);

    assertTrue(result.getFlags().isBloodPressureUnitInKpa());
    assertTrue(result.getFlags().isMeasurementStatusFlagPresent());
    assertTrue(result.getFlags().isPulseRateFlagPresent());
    assertTrue(result.getFlags().isTimeStampFlagPresent());
    assertTrue(result.getFlags().isUserIdFlagPresent());
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingCompundValues_thenCorrectValueIsMapped() {
    BloodPressureMeasurementDto result = underTest.mapBloodPressureMeasurement(bytes_second);

    assertNotNull(result.getkPaDiastolicValue());
    assertNotNull(result.getkPaSystolicValue());
    assertNotNull(result.getkPaMeanArterialPressureValue());
    assertTrue(result.getMmHgDiastolicValue() == 0.00f);
    assertTrue(result.getMmHgSystolicValue() == 0.00f);
    assertTrue(result.getMmHgMeanArterialPressureValue() == 0.00f);
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingTimestamp_thenCorrectValueIsMapped() {
    BloodPressureMeasurementDto result = underTest.mapBloodPressureMeasurement(bytes_second);

    assertEquals(result.getYear(), 257);
    assertEquals(result.getMonth(), 1);
    assertEquals(result.getDay(), 1);
    assertEquals(result.getHour(), 1);
    assertEquals(result.getMinute(), 1);
    assertEquals(result.getSecond(), 1);
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingPulseRate_thenCorrectValueIsMapped() {
    BloodPressureMeasurementDto result = underTest.mapBloodPressureMeasurement(bytes_second);

    assertTrue(result.getPulseRate() == 257.00f);
  }

  @Test
  public void givenValidArrayOfBytes_whenMappingUserId_thenCorrectValueIsMapped() {
    BloodPressureMeasurementDto result = underTest.mapBloodPressureMeasurement(bytes_second);

    assertTrue(result.getUserId() == 1.00f);
  }

  @Test
  public void givenValidArrayOfBytes_whenMeasurementStatus_thenCorrectValueIsMapped() {
    BloodPressureMeasurementDto result = underTest.mapBloodPressureMeasurement(bytes_second);

    assertTrue(result.getMeasurementStatus().isHasBodyMovement());
    assertFalse(result.getMeasurementStatus().isCuffToLoose());
    assertTrue(result.getMeasurementStatus().getPulseRateRangeDetectionFlag()
        .equals("Pulse rate is within the range."));
    assertFalse(result.getMeasurementStatus().isIrregularPulseDetected());
    assertFalse(result.getMeasurementStatus().isHasImproperMeasurementPosition());
  }

}
