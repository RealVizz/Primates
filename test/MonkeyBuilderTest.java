import org.junit.Assert;
import org.junit.Test;


/**
 * The test class for MonkeyBuilder class implementation.
 */
public class MonkeyBuilderTest {

  MonkeyBuilder monkeyBuilder = new MonkeyBuilder();

  @Test
  public void setSize() {
    double size = monkeyBuilder.setSize(7).build(MonkeySpecies.GUEREZA).getSize();
    Assert.assertEquals(7, size, 0.001);
  }

  @Test
  public void setAge() {
    double age = monkeyBuilder.setAge(7).build(MonkeySpecies.GUEREZA).getAge();
    Assert.assertEquals(7, age, 0.001);
  }

  @Test
  public void setName() {
    String name = monkeyBuilder.setName("Bo").build(MonkeySpecies.GUEREZA).getName();
    Assert.assertEquals("Bo", name);
  }

  @Test
  public void setSex() {
    char sex = monkeyBuilder.setSex('M').build(MonkeySpecies.GUEREZA).getSex();
    Assert.assertEquals('M', sex);
  }

  @Test
  public void setWeight() {
    double weight = monkeyBuilder.setWeight(7).build(MonkeySpecies.GUEREZA).getWeight();
    Assert.assertEquals(7, weight, 0.001);
  }

  @Test
  public void setFavoriteFood() {
    FavoriteFood favFood = monkeyBuilder.setFavoriteFood(FavoriteFood.FRUIT)
            .build(MonkeySpecies.GUEREZA).getFavoriteFood();
    Assert.assertEquals(FavoriteFood.FRUIT, favFood);
  }

  @Test
  public void build() {
    Monkey monkey = monkeyBuilder.setAge(7).build(MonkeySpecies.GUEREZA);
    Assert.assertEquals(Monkey.class, monkey.getClass());
  }
}