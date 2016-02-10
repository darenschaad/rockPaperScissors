import java.util.HashMap;
import java.util.Random;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String playerOneThrow = request.queryParams("optionsRadios");
      String winner = defineWinner(playerOneThrow, computerChooses());
      model.put("winner", winner);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }




  public static Boolean checkWinner(String input1, String input2) {
    String rock = "Rock";
    String paper = "Paper";
    String scissors = "Scissors";
    if (input1 .equals(rock) && input2 .equals(scissors)){
      return true;
    }
    else if (input1 .equals(scissors) && input2 .equals(paper)){
      return true;
    }
    else if (input1 .equals(paper) && input2 .equals(rock)){
      return true;
    }
    else {
      return false;
    }

  }

  public static String defineWinner(String playerOneThrow, String playerTwoThrow) {
    if (checkWinner(playerOneThrow, playerTwoThrow) == true) {
      return "You picked " + playerOneThrow + ", the computer picked " + playerTwoThrow + ". You win!";
    }
    else if (checkWinner(playerTwoThrow, playerOneThrow) == true) {
      return "You picked " + playerOneThrow + ", the computer picked " + playerTwoThrow + ". The computer wins :(";
    }
    else {
      return "You picked " + playerOneThrow + ", the computer picked " + playerTwoThrow + ". It's a tie game.";
    }
  }
  public static String computerChooses() {
    HashMap<Integer, String> rpsHash = new HashMap<Integer, String>();
        rpsHash.put(0, "Rock");
        rpsHash.put(1, "Paper");
        rpsHash.put(2, "Scissors");

    Random computerRandomPick = new Random();
    Integer randomPick = computerRandomPick.nextInt(3);
    String computerPick = rpsHash.get(randomPick);
    return computerPick;

  }
}
