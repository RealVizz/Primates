import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * The test class for Enclosement class implementation.
 */
public class EnclosementTest {

  Enclosement enclosement = new Enclosement(100);

  @Test
  public void getAreaLeft() {
    Assert.assertEquals(100, enclosement.getAreaLeft(), 0.001);
  }

  @Test
  public void getSpecies() {
    Assert.assertEquals(MonkeySpecies.NULL, enclosement.getSpecies());
  }

  @Test
  public void getContainedAnimalList() {
    Assert.assertEquals(new ArrayList<>(), enclosement.getContainedAnimalList());
  }

  @Test
  public void addAnimal() {
    AbstractAnimal abc = new MonkeyBuilder().build(MonkeySpecies.GUEREZA);
    enclosement.addAnimal(abc);
    Assert.assertEquals(abc, enclosement.getContainedAnimalList().get(0));
  }

  @Test
  public void removeAnimal() {
    AbstractAnimal abc = new MonkeyBuilder().build(MonkeySpecies.GUEREZA);
    enclosement.addAnimal(abc);
    enclosement.removeAnimal(abc.getUuid());
    assertTrue(enclosement.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertTrue(enclosement.isEmpty());
  }

  @Test
  public void yieldSignatureForAll() {
    AbstractAnimal abc = new MonkeyBuilder().build(MonkeySpecies.GUEREZA);
    enclosement.addAnimal(abc);
    String signature = enclosement.yieldSignatureForAll();

    Assert.assertEquals(signature, abc.toString());
  }
}