package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CarsModelListPage extends PageObject {
    public static final Target LAMBORGHINI_VENENO =
            Target.the("Lamborghini Veneno page")
                    .located(By.xpath("/html/body/my-app/div/main/my-overall/div/div/table/tbody/tr[4]/td[1]/a"));
}
