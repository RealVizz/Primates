import org.junit.Assert;
import org.junit.Test;


/**
 * The test class for Monkey class implementation.
 */
public class MonkeyTest {
  Monkey monkey = new Monkey(10, 11, "Bo", 'M', 22, FavoriteFood.FRUIT, MonkeySpecies.SPIDER);

  @Test
  public void getSpecies() {
    Assert.assertEquals(MonkeySpecies.SPIDER, monkey.getSpecies());
  }

  @Test
  public void getAreaNeeded() {
    Assert.assertEquals(5, monkey.getAreaNeeded(), 0.001);
  }

  @Test
  public void testToString() {
    String str = "Monkey{size=10.0, age=11.0, name='Bo', sex=M, weight=22.0, favoriteFood=FRUIT,"
            + " contained_inside='', areaNeeded=5.0, species=SPIDER,";
    Assert.assertEquals(str, monkey.toString().split("UUID")[0].strip());
  }
}