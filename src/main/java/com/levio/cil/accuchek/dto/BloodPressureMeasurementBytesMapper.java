package com.levio.cil.accuchek.dto;

import org.springframework.stereotype.Component;
import com.levio.cil.accuchek.rest.controllers.BloodPressureMeasurementDto;

@Component
public class BloodPressureMeasurementBytesMapper {

  public BloodPressureMeasurementBytesMapper() {
    
  }

  public BloodPressureMeasurementDto mapArrayOfBytesToReadableData(int[] dataDto) {
    BloodPressureMeasurementDto bloodPressureMeasurement = new BloodPressureMeasurementDto();
    
    //Todo : big mapping here (a lot of fields)
    //https://www.bluetooth.com/wp-content/uploads/Sitecore-Media-Library/Gatt/Xml/Characteristics/org.bluetooth.characteristic.blood_pressure_measurement.xml
    
    return bloodPressureMeasurement;
  }
}
