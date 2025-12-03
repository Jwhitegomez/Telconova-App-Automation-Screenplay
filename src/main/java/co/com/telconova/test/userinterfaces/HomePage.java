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

    public static final Target REGISTER_BUTTON =
            Target.the("Register button")
                    .located(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));

    public static final Target LOGIN_FAILURE_MESSAGE =
            Target.the("Login failure message")
                    .located(By.xpath("//*[@id=\"root\"]/div[1]/ol/li/div/div[1]"));

    public static final Target LOGOUT =
            Target.the("Logout button")
                    .located(By.xpath("//*[@id=\"root\"]/div[2]/header/div/nav/button[2]"));

    public static final Target MODELS_LIST =
            Target.the("Car's model list")
                    .located(By.xpath("/html/body/my-app/div/main/my-home/div/div[3]/div/a"));
}
