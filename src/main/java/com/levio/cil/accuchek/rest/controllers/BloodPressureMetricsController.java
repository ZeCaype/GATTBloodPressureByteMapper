package com.levio.cil.accuchek.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.levio.cil.accuchek.dto.BloodPressureFeatureDto;

@RestController
@RequestMapping(value = "/bloodpressure")
public class BloodPressureMetricsController {

  @Autowired
  public BloodPressureMetricsController() {

  }

  @PostMapping (value = "/feature")
  public BloodPressureFeatureDto mapX(@RequestBody int[] dataDto) {
    return null;
  }
}
