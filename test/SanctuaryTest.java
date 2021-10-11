import org.junit.Assert;
import org.junit.Test;


/**
 * The test class for Sanctuary class implementation.
 */
public class SanctuaryTest {
  AbstractAnimal animal = new MonkeyBuilder().build(MonkeySpecies.SPIDER);
  Sanctuary sanctuary = new Sanctuary(1, 1);

  @Test
  public void addAnimal() {
    Assert.assertTrue(sanctuary.addAnimal(animal));
  }

  @Test
  public void addIsolation() {
    sanctuary.addIsolation();
    Assert.assertEquals(2, sanctuary.isolationCount);
  }

  @Test
  public void addEnclosement() {
    sanctuary.addEnclosement(50);
    Assert.assertEquals(2, sanctuary.enclosementCount);
  }

  @Test
  public void removeAnimal() {
    sanctuary.addAnimal(animal);
    Assert.assertTrue(sanctuary.removeAnimal(animal.getUuid()));
  }

  @Test
  public void removeIsolation() {
    sanctuary.removeIsolation();
    Assert.assertEquals(0, sanctuary.isolationCount);
  }

  @Test
  public void removeEnclosement() {
    sanctuary.removeEnclosement();
    Assert.assertEquals(0, sanctuary.enclosementCount);
  }

  @Test
  public void reportAllSpecies() {
    sanctuary.addAnimal(animal);
    String signature = sanctuary.reportAllSpecies().strip();
    Assert.assertEquals("[SPIDER]", signature);
  }

  @Test
  public void isSpeciesPresent() {
    Assert.assertEquals("Species \"GUEREZA\" is not present in the sanctuary",
            sanctuary.isSpeciesPresent(MonkeySpecies.GUEREZA));
  }

  @Test
  public void reportAllMonkeys() {
    sanctuary.addAnimal(animal);
    String signature = sanctuary.reportAllMonkeys().strip();
    Assert.assertEquals(signature, animal.toString());
  }

  @Test
  public void getShoppingList() {
    sanctuary.addAnimal(animal);
    Assert.assertEquals("{FRUIT=500.0}", sanctuary.getShoppingList());
  }
}