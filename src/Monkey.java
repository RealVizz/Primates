/**
 * The concrete implementation of a Monkey, what all it has and what all it does.
 */
public class Monkey extends AbstractAnimal {
  private final MonkeySpecies species;

  /**
   * The Constructor to the monkey class.
   *
   * @param size The size of the Monkey in cms.
   * @param age The age of the Monkey in years.
   * @param name The name of the Monkey.
   * @param sex The sex of the Monkey.
   * @param weight The weight of the Monkey.
   * @param favoriteFood The favourite food of the Monkey.
   * @param species The species of the Monkey.
   */
  public Monkey(double size, double age, String name, char sex, double weight,
                FavoriteFood favoriteFood, MonkeySpecies species) {
    if (size > 100) {
      throw new IllegalArgumentException("Size of an animal can not go beyond 100");
    }
    if (age < 0) {
      throw new IllegalArgumentException("Age of an animal can not be negative.");
    }
    if (weight < 0) {
      throw new IllegalArgumentException("Weight of an animal can not be negative.");
    }

    this.age = age;
    this.name = name;
    this.sex = sex;
    this.weight = weight;
    this.favoriteFood = favoriteFood;
    this.species = species;
    this.size = size;
    this.uuid = generateUUID();

    setAreaNeeded();
  }

  public MonkeySpecies getSpecies() {
    return this.species;
  }

  public double getAreaNeeded() {
    return this.areaNeeded;
  }

  void setAreaNeeded() {
    if (this.size < 10) {
      this.areaNeeded = 1;
    } else if (this.size >= 10 && this.size < 20) {
      this.areaNeeded = 5;
    } else {
      this.areaNeeded = 10;
    }
  }

  @Override
  String generateUUID() {
    return java.util.UUID.randomUUID().toString().replace("-", "");
  }

  @Override
  public String toString() {
    return "Monkey{" +
            "size=" + size +
            ", age=" + age +
            ", name='" + name + '\'' +
            ", sex=" + sex +
            ", weight=" + weight +
            ", favoriteFood=" + favoriteFood +
            ", contained_inside='" + containedInside + '\'' +
            ", areaNeeded=" + areaNeeded +
            ", species=" + species +
            ", UUID='" + uuid + '\'' +
            '}';
  }

}
