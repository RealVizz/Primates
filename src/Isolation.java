/**
 * The concrete implementation of an Isolation, what all it has and what all it does.
 */
public class Isolation extends AbstractContainer {
  private MonkeySpecies species = MonkeySpecies.NULL;
  private AbstractAnimal containedAnimal;
  private boolean isEmpty = true;

  public Isolation(double area) {
    this.area = area;
  }

  public MonkeySpecies getSpecies() {
    return species;
  }

  private void setSpecies(MonkeySpecies species) {
    this.species = species;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  private void setEmpty() {
    isEmpty = true;
  }

  public AbstractAnimal getContainedAnimal() {
    return this.containedAnimal;
  }

  boolean setContainedAnimal(AbstractAnimal newAnimal) throws IllegalStateException {

    if (newAnimal instanceof Monkey) {
      Monkey theAnimal = (Monkey) newAnimal;
      this.setSpecies(theAnimal.getSpecies());
      newAnimal.setContainedInside("Isolation");
      this.containedAnimal = newAnimal;
      this.isEmpty = false;
      this.assignSignature(theAnimal);
      return true;
    } else {
      throw new IllegalStateException("We right now support only Monkey class");
    }

  }

  void removeAnimal() {
    this.containedAnimal.setContainedInside("");
    this.setSpecies(MonkeySpecies.NULL);
    this.containedAnimal = null;

    setEmpty();
  }

  private void assignSignature(AbstractAnimal theAnimal) {
    if (theAnimal.getFavoriteFood() == FavoriteFood.NULL) {
      theAnimal.setFavoriteFood(FavoriteFood.FRUIT);
    }
    if (theAnimal.getSize() == 0.0) {
      theAnimal.setSize(20.0);
    }
    if (theAnimal.getAge() == 0.0) {
      theAnimal.setAge(1.0);
    }
    if (theAnimal.getSex() == '\u0000') {
      theAnimal.setSex('M');
    }
    if (theAnimal.getWeight() == 0.0) {
      theAnimal.setWeight(10.0);
    }
    if (theAnimal.getName() == null) {
      theAnimal.setName("Lovely Animal");
    }
  }
}
