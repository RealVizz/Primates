/**
 * The Idea to have this class is to give customise ability to the user to create a Monkey.
 */
public class MonkeyBuilder {
  private double size;
  private double age;
  private String name;
  private char sex;
  private double weight;
  private FavoriteFood favoriteFood = FavoriteFood.NULL;

  public MonkeyBuilder setSize(double size) {
    this.size = size;
    return this;
  }

  public MonkeyBuilder setAge(double age) {
    this.age = age;
    return this;
  }

  public MonkeyBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public MonkeyBuilder setSex(char sex) {
    this.sex = sex;
    return this;
  }

  public MonkeyBuilder setWeight(double weight) {
    this.weight = weight;
    return this;
  }

  public MonkeyBuilder setFavoriteFood(FavoriteFood favoriteFood) {
    this.favoriteFood = favoriteFood;
    return this;
  }

  public Monkey build(MonkeySpecies species) {
    return new Monkey(size, age, name, sex, weight, favoriteFood, species);
  }
}
