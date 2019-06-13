import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.levio.cil.accuchek.dto.BloodPressureFeatureDto;
import com.levio.cil.accuchek.mappers.BloodPressureBytesMapper;

public class BloodPressureBytesMapperTest {

  private byte[] bytes = {1,1};
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
  
}
