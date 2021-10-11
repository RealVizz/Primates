/**
 * Gives a basic template of what all containers must and should have.
 */
public abstract class AbstractContainer {
  double area;

  public double getArea() {
    return this.area;
  }


  abstract boolean isEmpty();
}
