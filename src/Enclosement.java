import java.util.ArrayList;


/**
 * The concrete implementation of an Enclosement, what all it has and what all it does.
 */
public class Enclosement extends AbstractContainer {
  MonkeySpecies species = MonkeySpecies.NULL;
  ArrayList<AbstractAnimal> containedAnimalList = new ArrayList<>();
  boolean isEmpty = true;
  double areaLeft;

  public Enclosement(double area) {
    this.area = area;
    this.areaLeft = area;
  }

  public double getAreaLeft() {
    this.setAreaLeft();
    return areaLeft;
  }

  private void setAreaLeft() {
    double usedArea = 0;
    for (int i = 0; i < containedAnimalList.size(); i++) {
      usedArea += containedAnimalList.get(i).getAreaNeeded();
    }
    this.areaLeft = this.area - usedArea;
  }

  public MonkeySpecies getSpecies() {
    return species;
  }

  private void setSpecies(MonkeySpecies species) {
    this.species = species;
  }

  ArrayList<AbstractAnimal> getContainedAnimalList() {
    return this.containedAnimalList;
  }

  void addAnimal(AbstractAnimal theAnimal) {
    if (this.species == MonkeySpecies.NULL || this.species == theAnimal.getSpecies()) {
      theAnimal.setContainedInside("Enclosement");
      this.containedAnimalList.add(theAnimal);
      this.setSpecies(theAnimal.getSpecies());
      this.isEmpty = false;
    }

  }

  boolean removeAnimal(String uuid) {
    boolean isRemoved = false;
    if (!this.isEmpty()) {
      for (int j = 0; j < containedAnimalList.size(); j++) {
        AbstractAnimal anAnimal = containedAnimalList.get(j);
        if (uuid.equals(anAnimal.getUuid())) {
          anAnimal.setContainedInside("");
          containedAnimalList.remove(anAnimal);
          isRemoved = true;
          this.setAreaLeft();
          if (this.getAreaLeft() == this.getArea()) {
            setEmpty();
          }
          break;
        }
      }
    }
    return isRemoved;
  }

  boolean isEmpty() {
    return isEmpty;
  }

  private void setEmpty() {
    isEmpty = true;
  }

  String yieldSignatureForAll() {
    StringBuilder presentableStr = new StringBuilder();
    for (int i = 0; i < containedAnimalList.size(); i++) {
      presentableStr.append(containedAnimalList.get(i).toString());
    }
    return presentableStr.toString();
  }

}
