/**
 * This class should be able to demonstrate as much as possible functionality of the system can
 * offer.
 */
public class DriverClass {
  /**
   * The idea to have this is to have it to let the JAVA run a case, it has a MAIN method.
   * @param args No arguments required as such, if given, they will be ignored.
   */
  public static void main(String[] args) {
    Sanctuary a = new SanctuaryBuilder().build();
    System.out.println("World starts with creating a sanctuary so we create a sanctuary");
    System.out.println("Sanctuary has no Isolation and Enclosures, so no animal must be added");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.GUEREZA)));
    System.out.println("Let us add an Enclosure with size = 50");
    a.addEnclosement(50);
    System.out.println("Monkey should not be added as they first go to Isolations");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.GUEREZA)));
    System.out.println("Let us add an Isolation");
    a.addIsolation();
    System.out.println("Lets try to add an monkey to sanctuary");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.HOWLER)));
    System.out.println("Let us try adding 1 more");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.HOWLER)));
    System.out.println("A new monkey could be added because enclosure had space to accommodate it");
    System.out.println("Let us check the state of all the monkeys in the sanctuary");
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("As report Suggest, 1 monkey is in Isolation & 1 in Enclosement/Enclosure");
    System.out.println("Let us check whether the sanctuary manages to have GUEREZA monkey");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.GUEREZA)));
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("Hmm, we see it handled it well, the new species added was GUEREZA, "
            + "it tried to accommodate the new species logically well, it shifted the HOWLER into"
            + " an enclosement \nand added the GUEREZA into Isolation");
    System.out.println("Lets check whether the Enclosement manages to have an HOWLER monkey");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.HOWLER)));
    System.out.println("Seems reasonable as Isolation was not empty and Enclosure was "
            + "accommodating HOWLER species, which is different from GUEREZA");
    System.out.println("Lets add an Isolation");
    a.addIsolation();
    System.out.println("Lets check again, adding a HOWLER into isolation");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.HOWLER)));
    System.out.println("Lets check the current report of the sanctuary");
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("Makes sense, the new HOWLER got into an isolation");
    System.out.println("So far all of the monkeys are of size 20, you can check there details "
            + "in the report as well");
    System.out.println("Lets try adding more of HOWLER & lets see how many an enclosure can store");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.HOWLER)));
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("Makes sense, new HOWLER got into isolation and older one into enclosement");
    System.out.println("Let us push it");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.HOWLER)));
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("So far 4 monkeys are added, lets check the space left in enclosure");
    System.out.println("Enclosement Area Left : " + a.enclosementList.get(0).getAreaLeft());
    System.out.println("Adding 1 more HOWLER");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.HOWLER)));
    System.out.println("Enclosement Area Left : " + a.enclosementList.get(0).getAreaLeft());
    System.out.println("Oh, we are now at a critical moment, lets try to add 1 more");
    System.out.println("Monkey Added : "
            + a.addAnimal(new MonkeyBuilder().setSize(20).build(MonkeySpecies.HOWLER)));
    System.out.println("Oh, the system denied to add the monkey");
    System.out.println("So, far the the system was handling the monkeys default value");
    System.out.println("As the names you can see are like Lovely Animal");
    System.out.println("Let us try giving explicit names to the animal");
    System.out.println("Before that let us add another ISOLATION");
    a.addIsolation();
    System.out.println("Lets create a monkey HOWLER with known name as TOCAMEI");
    System.out.println("Monkey Added : " + a.addAnimal(new MonkeyBuilder().setSize(20)
            .setName("TOCAMEI").setFavoriteFood(FavoriteFood.NUTS).build(MonkeySpecies.HOWLER)));
    System.out.println("Lets check");
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("It worked, Lets just try to get the shopping list");
    System.out.println(a.getShoppingList().strip());
    System.out.println("So you get your list of item and quantity in grams as well");
    System.out.println("Let see do we have any SPIDER kind of monkey ?");
    System.out.println(a.isSpeciesPresent(MonkeySpecies.SPIDER));
    System.out.println("Let see do we have any GUEREZA kind of monkey ?");
    System.out.println("GUEREZA are found in : " + a.isSpeciesPresent(MonkeySpecies.GUEREZA));
    System.out.println("Let see do we have any SPIDER kind of monkey ?");
    System.out.println("Seems correct");
    System.out.println("Lets just dump the Enclosement");
    a.removeEnclosement();
    System.out.println("Lets check the current report of the SANCTUARY");
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("Lets just dump an Isolation");
    a.removeIsolation();
    System.out.println("Lets check the current report of the SANCTUARY");
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("Lets check the current species found in the SANCTUARY");
    System.out.println("Species found in sanctuary : " + a.reportAllSpecies().strip());
    System.out.println("Seems correct");
    System.out.println("Lets check whether the animal can tell where it is");
    System.out.println("Lets create a new animal and ask it where it is contained");
    AbstractAnimal animal = new MonkeyBuilder().build(MonkeySpecies.GUEREZA);
    System.out.println("Animal contained in : " + "\"" + animal.getContainedInside() + "\"");
    System.out.println("Oh that seems reasonable, the animal is not put up anywhere yet");
    System.out.println("Lets create an Isolation and add animal to it and then check");
    a.addIsolation();
    System.out.println("Monkey Added : " + a.addAnimal(animal));
    System.out.println("Animal contained in : " + "\"" + animal.getContainedInside() + "\"");
    System.out.println("That is right, as every new animal is contained in Isolation first");
    System.out.println("Lets say at some day, it good time for an animal to let loose in wild or " +
            "it may get transferred to some other home, So we need to remove it");
    System.out.println("So, the UUID for the animal is : " + animal.getUuid());
    System.out.println("Lets remove this animal......Dont worry it for the good");
    System.out.println("Is animal removed : " + a.removeAnimal(animal.getUuid()));
    System.out.println("Lets have a all monkey sanctuary report ");
    System.out.println(a.reportAllMonkeys().strip());
    System.out.println("Let us also check where the animal is contained in ");
    System.out.println("Animal contained in : " + "\"" + animal.getContainedInside() + "\"");
    System.out.println("Yeah, it is not contained any where inside this sanctuary");


    System.out.println("\n\n\nThanks for reading the demo run of the project.");
    System.out.println("HAVE A NICE DAY !!!");

  }
}
