import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * The concrete implementation of a Sanctuary, what all it has and what all it does.
 */
public class Sanctuary {

  List<Isolation> isolationList;
  List<Enclosement> enclosementList;
  int isolationCount;
  int enclosementCount;

  /**
   * The Constructor to the sanctuary class.
   *
   * @param isolationCount The number of Isolations in the sanctuary.
   * @param enclosementCount The number of Enclosement in the sanctuary.
   */
  public Sanctuary(int isolationCount, int enclosementCount) {
    this.isolationCount = isolationCount;
    this.enclosementCount = enclosementCount;
    isolationList = new ArrayList<>();
    enclosementList = new ArrayList<>();

    // Below code is defensive against the negative values of isolation/enclosement count so no
    // test case will be written.
    for (int i = 0; i < isolationCount; i++) {
      isolationList.add(new Isolation(100));
    }
    for (int i = 0; i < enclosementCount; i++) {
      enclosementList.add(new Enclosement(100));
    }
  }

  /**
   * The idea is to have an immediate report whether the animal was added in to sanctuary or not.
   *
   * @param theAnimal The animal to be added.
   * @return Gives a boolean value whether it is added to sanctuary or not.
   */
  public boolean addAnimal(AbstractAnimal theAnimal) {
    boolean added = false;

    for (int i = 0; i < isolationCount; i++) {
      if (isolationList.get(i).isEmpty()) {
        isolationList.get(i).setContainedAnimal(theAnimal);
        added = true;
        break;
      }
    }

    if (!added) {
      this.optimiseAndRelocate();
      for (int i = 0; i < isolationCount; i++) {
        if (isolationList.get(i).isEmpty()) {
          isolationList.get(i).setContainedAnimal(theAnimal);
          added = true;
          break;
        }
      }
    }

    return added;
  }

  public void addIsolation() {
    isolationList.add(new Isolation(100));
    isolationCount += 1;
  }

  public void addEnclosement(double size) {
    enclosementList.add(new Enclosement(size));
    enclosementCount += 1;
  }

  /**
   * The idea is to have an immediate report whether the animal was removed from sanctuary or not.
   *
   * @param uuid The unique identifier of the Monkey.
   * @return Gives a boolean value whether it is added to sanctuary or not.
   */
  public boolean removeAnimal(String uuid) {
    boolean isRemoved = false;
    for (int i = 0; i < isolationList.size(); i++) {
      Isolation isoObj = isolationList.get(i);
      if (!isoObj.isEmpty() && uuid.equals(isoObj.getContainedAnimal().getUuid())) {
        isolationList.get(i).removeAnimal();
        return true;
      }
    }

    for (int i = 0; i < enclosementList.size(); i++) {
      Enclosement encObj = enclosementList.get(i);
      isRemoved = encObj.removeAnimal(uuid);
      if (isRemoved) {
        break;
      }
    }

    return isRemoved;
  }

  /**
   * Removes the last Isolation in the list.
   */
  public void removeIsolation() {
    if (isolationList.size() >= 1) {
      isolationList.remove(isolationList.size() - 1);
      isolationCount -= 1;
    }
  }

  /**
   * Removes the last Enclosement in the list.
   */
  public void removeEnclosement() {
    if (enclosementList.size() >= 1) {
      enclosementList.remove(enclosementList.size() - 1);
      enclosementCount -= 1;
    }
  }


  private void optimiseAndRelocate() {
    for (int i = 0; i < enclosementCount; i++) {
      for (int j = 0; j < isolationCount; j++) {
        Enclosement enclosement = enclosementList.get(i);
        Isolation isolation = isolationList.get(j);
        if (!isolation.isEmpty()) {
          AbstractAnimal containedAnimal = isolation.getContainedAnimal();
          if (enclosement.getAreaLeft() >= containedAnimal.getAreaNeeded()) {
            if (enclosement.getSpecies() == isolation.getSpecies()
                    || enclosement.getSpecies() == MonkeySpecies.NULL) {
              enclosement.addAnimal(containedAnimal);
              isolation.removeAnimal();
            }
          }
        }
      }
    }
  }


  /**
   * Provides functionality to see what all species are there in the sanctuary.
   *
   * @return The list of species present in the sanctuary.
   */
  public String reportAllSpecies() {
    TreeSet<MonkeySpecies> listOfSpecies = new TreeSet<>();
    for (int i = 0; i < isolationList.size(); i++) {
      if (isolationList.get(i).getSpecies() != MonkeySpecies.NULL) {
        listOfSpecies.add(isolationList.get(i).getSpecies());
      }
    }
    for (int i = 0; i < enclosementList.size(); i++) {
      if (enclosementList.get(i).getSpecies() != MonkeySpecies.NULL) {
        listOfSpecies.add(enclosementList.get(i).getSpecies());
      }
    }

    if (listOfSpecies.isEmpty()) {
      return "No species are in here";
    } else {
      return listOfSpecies.toString();
    }
  }


  /**
   * Provides functionality to see if a species is there in the sanctuary.
   * If yes where is it.
   *
   * @param species  The species to be looked up on.
   * @return The place where the given species is in the sanctuary, an empty string if it isn't
   *     there.
   */
  public String isSpeciesPresent(MonkeySpecies species) {
    TreeSet<String> listOfContainers = new TreeSet<>();
    for (int i = 0; i < isolationList.size(); i++) {
      if (isolationList.get(i).getSpecies().equals(species)) {
        listOfContainers.add("ISOLATION");
      }

    }
    for (int i = 0; i < enclosementList.size(); i++) {
      if (enclosementList.get(i).getSpecies().equals(species)) {
        listOfContainers.add("ENCLOSEMENT");
      }
    }

    if (listOfContainers.isEmpty()) {
      return "Species \"" + species + "\" is not present in the sanctuary";
    }

    return listOfContainers.toString();
  }


  /**
   * Provides functionality to see all the Monkeys in the sanctuary.
   *
   * @return The formatted string with the details of all the Monkeys in the sanctuary.
   */
  public String reportAllMonkeys() {
    TreeSet<String> listOfMonkeys = new TreeSet<>();

    for (int i = 0; i < isolationList.size(); i++) {
      if (!isolationList.get(i).isEmpty()) {
        listOfMonkeys.add(isolationList.get(i).getContainedAnimal().toString());
      }
    }
    for (int i = 0; i < enclosementList.size(); i++) {
      for (int j = 0; j < enclosementList.get(i).containedAnimalList.size(); j++) {
        listOfMonkeys.add(enclosementList.get(i).containedAnimalList.get(j).toString());
      }
    }

    if (listOfMonkeys.isEmpty()) {
      return "No Monkeys Found";
    } else {
      StringBuilder presentableStr = new StringBuilder();
      for (int i = 0; i < listOfMonkeys.size(); i++) {
        presentableStr.append(listOfMonkeys.toArray()[i].toString()).append("\n");
      }
      return presentableStr.toString();
    }

  }


  /**
   * Provides functionality to see what all food items are needed to be bought for the animals
   * in the sanctuary.
   *
   * @return A formatted string with specifics of what food is to be bought along with quantity.
   */
  public String getShoppingList() {
    ArrayList<AbstractAnimal> listOfMonkeys = new ArrayList<>();
    Map<FavoriteFood, Double> shopItemMap = new HashMap<>();

    for (int i = 0; i < isolationList.size(); i++) {
      if (!isolationList.get(i).isEmpty()) {
        listOfMonkeys.add(isolationList.get(i).getContainedAnimal());
      }
    }
    for (int i = 0; i < enclosementList.size(); i++) {
      for (int j = 0; j < enclosementList.get(i).containedAnimalList.size(); j++) {
        listOfMonkeys.add(enclosementList.get(i).containedAnimalList.get(j));
      }
    }

    for (int k = 0; k < listOfMonkeys.size(); k++) {
      FavoriteFood favFood = listOfMonkeys.get(k).getFavoriteFood();
      double sizeOfAnimal = listOfMonkeys.get(k).getSize();

      if (sizeOfAnimal < 10) {
        if (shopItemMap.get(favFood) != null) {
          shopItemMap.put(favFood, shopItemMap.get(favFood) + 100.0);
        } else {
          shopItemMap.put(favFood, 100.0);
        }
      } else if (sizeOfAnimal < 20) {
        if (shopItemMap.get(favFood) != null) {
          shopItemMap.put(favFood, shopItemMap.get(favFood) + 250.0);
        } else {
          shopItemMap.put(favFood, 250.0);
        }
      } else {
        if (shopItemMap.get(favFood) != null) {
          shopItemMap.put(favFood, shopItemMap.get(favFood) + 500.0);
        } else {
          shopItemMap.put(favFood, 500.0);
        }
      }
    }

    return shopItemMap.toString();
  }

}
