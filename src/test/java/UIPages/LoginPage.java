package UIPages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://practice.automationtesting.in/my-account/")
public class LoginPage extends PageObject {

    public void doLogin(){
       // $("//*[@id=\"reg_email\"]").sendKeys("syedchay@gmail.com");
        $("//*[@id=\"username\"]").sendKeys("syedchay@gmail.com");
       // $("#reg_password").sendKeys("12345678");
        $("#password").sendKeys("syedchay123");
      // $("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]").click();
        $("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]").click();
    }

    public String verifyHome(){
       return $("//a[text()='Dashboard']").getText();
    }


}
