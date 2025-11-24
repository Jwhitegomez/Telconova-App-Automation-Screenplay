package co.com.buggy.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {

    public static final Target USERNAME =
            Target.the("Username field")
                    .located(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/div/input[1]"));

    public static final Target PASSWORD =
            Target.the("Password field")
                    .located(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/div/input[2]"));

    public static final Target LOGIN_BUTTON =
            Target.the("Login button")
                    .located(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/button"));

    public static final Target REGISTER_BUTTON =
            Target.the("Register button")
                    .located(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));

    public static final Target LOGIN_FAILURE_MESSAGE =
            Target.the("Login failure message")
                    .located(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/div/span"));

    public static final Target LOGOUT =
            Target.the("Logout button")
                    .located(By.xpath("/html/body/my-app/header/nav/div/my-login/div/ul/li[3]/a"));

    public static final Target MODELS_LIST =
            Target.the("Car's model list")
                    .located(By.xpath("/html/body/my-app/div/main/my-home/div/div[3]/div/a"));
}
