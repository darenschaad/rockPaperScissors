import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";


  }

  public static Boolean checkWinner(String input1, String input2) {
    String rock = "Rock";
    String paper = "Paper";
    String scissors = "Scissors";
    // String playerOnePick = "";
    // String playerTwoPick = "";
    if (input1 == rock && input2 == scissors){
      return true;
    }
    else if (input1 == scissors && input2 == paper){
      return true;
    }
    else if (input1 == paper && input2 == rock){
      return true;
    }
    else {
      return false;
    }

  }
}

  // HashMap<Character, Integer> scoreHash = new HashMap<Character, Integer>();
  //     scoreHash.put('a', 1);
  //
