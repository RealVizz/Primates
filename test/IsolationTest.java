import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * The test class for Isolation class implementation.
 */
public class IsolationTest {

  Isolation isolation = new Isolation(100);

  @Test
  public void getSpecies() {
    Assert.assertEquals(MonkeySpecies.NULL, isolation.getSpecies());
  }

  @Test
  public void isEmpty() {
    assertTrue(isolation.isEmpty());
  }

  @Test
  public void getContainedAnimal() {
    AbstractAnimal abc = new MonkeyBuilder().build(MonkeySpecies.GUEREZA);
    isolation.setContainedAnimal(abc);
    Assert.assertEquals(abc, isolation.getContainedAnimal());
  }

  @Test
  public void setContainedAnimal() {
    AbstractAnimal abc = new MonkeyBuilder().build(MonkeySpecies.GUEREZA);
    isolation.setContainedAnimal(abc);
    assertTrue(isolation.setContainedAnimal(abc));
  }

  @Test
  public void removeAnimal() {
    AbstractAnimal abc = new MonkeyBuilder().build(MonkeySpecies.GUEREZA);
    isolation.setContainedAnimal(abc);
    isolation.removeAnimal();
    assertTrue(isolation.isEmpty());
  }
}