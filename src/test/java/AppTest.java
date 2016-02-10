import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("Leap year detector");
  // }
  @Test
  public void checkWinner_rockBeatsScissors_true() {
    App testApp = new App();
    assertEquals(true, testApp.checkWinner("Rock", "Scissors"));
  }
  @Test
  public void checkWinner_scissorsBeatsPaper_true() {
    App testApp = new App();
    assertEquals(true, testApp.checkWinner("Scissors", "Paper"));
  }
  @Test
  public void checkWinner_paperBeatsRock_true() {
    App testApp = new App();
    assertEquals(true, testApp.checkWinner("Paper", "Rock"));
  }
}
