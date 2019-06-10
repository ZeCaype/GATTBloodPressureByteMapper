package com.levio.cil.accuchek.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.levio.cil.accuchek.dto.BloodPressureFeatureDto;
import com.levio.cil.accuchek.dto.BloodPressureMeasurementBytesMapper;
import com.levio.cil.accuchek.mappers.BloodPressureFeatureBytesMapper;

@RestController
@RequestMapping(value = "/bloodpressure")
public class BloodPressureMetricsController {
  
  private BloodPressureFeatureBytesMapper bloodPressureFeatureBytesMapper;
  private BloodPressureMeasurementBytesMapper bloodPressureMeasurementBytesMapper;

  @Autowired
  public BloodPressureMetricsController(
      BloodPressureFeatureBytesMapper bloodPressureFeatureBytesMapper,
      BloodPressureMeasurementBytesMapper bloodPressureMeasurementBytesMapper) {
    this.bloodPressureFeatureBytesMapper = bloodPressureFeatureBytesMapper;
    this.bloodPressureMeasurementBytesMapper = bloodPressureMeasurementBytesMapper;
  }

  @PostMapping (value = "/feature")
  public BloodPressureFeatureDto mapBloodPressureFeature(@RequestBody byte[] dataDto) {
    return bloodPressureFeatureBytesMapper.mapArrayOfBytesToReadableData(dataDto);
  }
  
  @PostMapping (value = "/measurement")
  public BloodPressureMeasurementDto mapBloodPressureMeasurement(@RequestBody byte[] dataDto) {
    return bloodPressureMeasurementBytesMapper.mapArrayOfBytesToReadableData(dataDto);
  }
}
