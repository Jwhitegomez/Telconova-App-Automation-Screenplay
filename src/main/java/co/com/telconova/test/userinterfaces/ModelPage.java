package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ModelPage extends PageObject {
    public static final Target MODEL_TITLE = Target.the("Model title")
            .located(By.xpath("/html/body/my-app/div/main/my-model/div/div[2]/h3"));

    public static final Target COMMENT_BOX = Target.the("Comment text area")
            .located(By.id("comment"));

    public static final Target LOGIN_WARNING = Target.the("You need to be logged in to comment")
            .located(By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/p"));

    public static final Target COMMENT_BUTTON = Target.the("Send comment button")
            .located(By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/div/button"));

    public static final Target COMMENTS_CONTAINER = Target.the("Comments container")
            .located(By.xpath("/html/body/my-app/div/main/my-model/div/div[3]/table"));
}
