package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {

    public static final Target USERNAME =
            Target.the("Username field")
                    .located(By.id("username"));

    public static final Target PASSWORD =
            Target.the("Password field")
                    .located(By.id("password"));

    public static final Target LOGIN_BUTTON =
            Target.the("Login button")
                    .located(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/form/button"));

    public static final Target LOGIN_FAILURE_MESSAGE =
            Target.the("Login failure message")
                    .located(By.xpath("//*[@id=\"root\"]/div[1]/ol/li/div/div[1]"));

    public static final Target LOGOUT =
            Target.the("Logout button")
                    .located(By.xpath("//*[@id=\"root\"]/div[2]/header/div/nav/button[2]"));

    public static final Target ALERT_MESSAGE =
            Target.the("login alert message")
                    .locatedBy("/html/body/div/div[2]/div/div[1]/div[2]/div[1]/div");

}
