import org.junit.Assert;
import org.junit.Test;

/**
 * The test class for SanctuaryBuilder class implementation.
 */
public class SanctuaryBuilderTest {

  @Test
  public void setIsolationCount() {
    Assert.assertEquals(22, new SanctuaryBuilder().setIsolationCount(22).build()
            .isolationCount);
  }

  @Test
  public void setEnclosementCount() {
    Assert.assertEquals(22, new SanctuaryBuilder().setEnclosementCount(22).build()
            .enclosementCount);
  }

  @Test
  public void build() {
    Sanctuary sanctuary = new SanctuaryBuilder().build();
    Assert.assertEquals(Sanctuary.class, sanctuary.getClass());
  }
}