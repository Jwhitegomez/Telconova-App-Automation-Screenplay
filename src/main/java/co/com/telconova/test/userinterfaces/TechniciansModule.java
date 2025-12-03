package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class TechniciansModule extends PageObject {
    public static final Target TECHNICIANS_LIST =
            Target.the("Work order")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[5]/div/div[2]/div"));
}

