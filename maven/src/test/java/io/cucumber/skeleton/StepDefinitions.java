package io.cucumber.skeleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IsItFriday {
    // alternative code under development:
//    static Object isItFriday(String today) {
//                if (today == "Friday") {
//                    return "TGIF";
//                }
//                else if (today == "Sunday") {
//                    return "Nope";
//                else {
//                    return "Nope";
//                }
         static String isItFriday(String today) {
    return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}
public class StepDefinitions {
    private String today;
    private String actualAnswer;

    //the actual code for this step is:
    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;

    }
    /*Deprecated code
    *@Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    } */
    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = (String) IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
