package Stepdef;

import com.factory.Base_driver;

import Pages.logpage;
import Utility.configur;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class logstepdef {

	logpage log = new logpage(Base_driver.getDriver());
	Base_driver basedriver = new Base_driver();
	configur confi = new configur();

	@Given("I open the calculator app")
	public void i_open_the_calculator_app() {
		log.i_open_the_calculator_app();
	}

	@When("write something and click button")
	public void write_something_and_click_button() throws InterruptedException { 
		log.write_something_and_click_button();
	}	

}
