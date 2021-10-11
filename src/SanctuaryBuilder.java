/**
 * The Idea to have this class is to give customise ability to the user to create a Sanctuary.
 */
public class SanctuaryBuilder {
  private int isolationCount = 0;
  private int enclosementCount = 0;

  public SanctuaryBuilder setIsolationCount(int isolationCount) {
    this.isolationCount = isolationCount;
    return this;
  }

  public SanctuaryBuilder setEnclosementCount(int enclosementCount) {
    this.enclosementCount = enclosementCount;
    return this;
  }

  public Sanctuary build() {
    return new Sanctuary(isolationCount, enclosementCount);
  }
}
