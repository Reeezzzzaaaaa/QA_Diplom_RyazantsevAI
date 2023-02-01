package auth.dayTripMarrakesh.pages;

import auth.dayTripMarrakesh.dataHelper.DataHelper;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentGatePage {

    private final SelenideElement inputNumberCard = $x("//*[@class='input__inner']//*[@maxlength='19']");
    private final SelenideElement inputWrongNumberCard = $x("//*[@method='post']/fieldset/div[1]/span/span/span[3]");
    private final SelenideElement inputMonthCard = $x("//*[@class='input-group__input-case']//*[@placeholder='08']");
    private final SelenideElement inputWrongMonthCard = $("div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub");
    private final SelenideElement inputYearCard = $x("//*[@class='input-group__input-case']//*[@placeholder='22']");
    private final SelenideElement inputWrongYearCard = $("div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub");
    private final SelenideElement inputOwnerCard = $("div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    private final SelenideElement inputWrongOwnerCard = $x("//*[@method='post']/fieldset/div[3]/span/span/span/span/span[3]");
    private final SelenideElement inputCVCCard = $x("//*[@class='input-group__input-case']//*[@placeholder='999']");
    private final SelenideElement inputWrongCVCCard = $x("//*[@method='post']/fieldset/div[3]/span/span[2]/span/span/span[3]");
    private final SelenideElement nextMove = $x("//*[@method='post']//*[@type='button']");
    private final SelenideElement successNotification = $x("//*[@id='root']/div/div[2]");
    private final SelenideElement UnSuccessNotification = $x("//*[@id='root']/div/div[3]");

    public void numberCard(DataHelper.CardNumber card) {
        inputNumberCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputNumberCard.setValue(String.valueOf(card));
        new PaymentGatePage();
    }

    public void EndOfActionDateCard(DataHelper.EndOfActionCardMonth month, DataHelper.EndOfActionCardYear year) {
        inputMonthCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputMonthCard.setValue(String.valueOf(month.getMonth()));
        inputYearCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputYearCard.setValue(String.valueOf(year));
        new PaymentGatePage();
    }

    public void dataCard(DataHelper.OwnerCard owner, DataHelper.CVCCodeCard cvc) {
        inputOwnerCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputOwnerCard.setValue(owner.getOwner());
        inputCVCCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputCVCCard.setValue(cvc.getCvcCode());
        new PaymentGatePage();
    }

    public void postData() {
        nextMove.click();
        new PaymentGatePage();
    }

    public void successNotification() {
        successNotification.shouldBe(visible, Duration.ofSeconds(15));
        new PaymentGatePage();
    }

    public void unSuccessNotification() {
        UnSuccessNotification.shouldBe(visible, Duration.ofSeconds(15));
        new PaymentGatePage();
    }

    public void wrongFieldNumberCard() {
        inputWrongNumberCard.shouldBe(visible);
        new PaymentGatePage();
    }

    public void wrongFieldMonth() {
        inputWrongMonthCard.shouldBe(visible);
        new PaymentGatePage();
    }

    public void wrongFieldYear() {
        inputWrongYearCard.shouldBe(visible);
        new PaymentGatePage();
    }

    public void wrongFieldOwner() {
        inputWrongOwnerCard.shouldBe(visible);
        new PaymentGatePage();
    }

    public void wrongFieldOwnerNotBeVisible() {
        inputWrongOwnerCard.shouldNotBe(visible);
        new PaymentGatePage();
    }

    public void wrongFieldCVCCode() {
        inputWrongCVCCard.shouldBe(visible);
        new PaymentGatePage();
    }
}
