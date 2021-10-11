/**
 * Gives a basic template of what all animals must and should have.
 */
public abstract class AbstractAnimal {
  double size;
  double age;
  String name;
  char sex;
  double weight;
  FavoriteFood favoriteFood = FavoriteFood.NULL;
  String containedInside = "";
  double areaNeeded;
  String uuid;


  protected double getSize() {
    return size;
  }

  protected void setSize(double size) {
    this.size = size;
  }

  protected double getAge() {
    return age;
  }

  protected void setAge(double age) {
    this.age = age;
  }

  protected String getName() {
    return name;
  }

  protected void setName(String name) {
    this.name = name;
  }

  protected char getSex() {
    return sex;
  }

  protected void setSex(char sex) {
    this.sex = sex;
  }

  protected double getWeight() {
    return weight;
  }

  protected void setWeight(double weight) {
    this.weight = weight;
  }

  protected FavoriteFood getFavoriteFood() {
    return this.favoriteFood;
  }

  protected void setFavoriteFood(FavoriteFood favoriteFood) {
    this.favoriteFood = favoriteFood;
  }

  protected String getContainedInside() {
    return containedInside;
  }

  protected void setContainedInside(String containedInside) {
    this.containedInside = containedInside;
  }

  public String getUuid() {
    return uuid;
  }

  public abstract MonkeySpecies getSpecies();

  public abstract double getAreaNeeded();

  abstract void setAreaNeeded();

  /**
   * The idea is to have an unique identifier if in case an animal is typically same to other in all
   * manners, but is still different entity wise.
   *
   * @return Universally Unique Identification Identity
   */
  abstract String generateUUID();

}
