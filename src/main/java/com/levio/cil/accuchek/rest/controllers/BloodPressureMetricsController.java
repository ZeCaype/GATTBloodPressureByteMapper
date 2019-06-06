package com.levio.cil.accuchek.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.levio.cil.accuchek.dto.BloodPressureFeatureBytesMapper;
import com.levio.cil.accuchek.dto.BloodPressureFeatureDto;

@RestController
@RequestMapping(value = "/bloodpressure")
public class BloodPressureMetricsController {
  
  private BloodPressureFeatureBytesMapper bloodPressureFeatureBytesMapper;

  @Autowired
  public BloodPressureMetricsController(BloodPressureFeatureBytesMapper bloodPressureFeatureBytesMapper) {
    this.bloodPressureFeatureBytesMapper = bloodPressureFeatureBytesMapper;
  }

  @PostMapping (value = "/feature")
  public BloodPressureFeatureDto mapX(@RequestBody int[] dataDto) {
    return bloodPressureFeatureBytesMapper.mapArrayOfBytesToReadableData(dataDto);
  }
}
