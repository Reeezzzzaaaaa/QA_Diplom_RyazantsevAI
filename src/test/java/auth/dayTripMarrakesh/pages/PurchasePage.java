package auth.dayTripMarrakesh.pages;

import auth.dayTripMarrakesh.dataHelper.DataHelper;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PurchasePage {

    private final SelenideElement inputNumberCard = $x("//*[@class='input__inner']//*[@maxlength='19']");
    private final SelenideElement inputMonthCard = $x("//*[@class='input-group__input-case']//*[@placeholder='08']");
    private final SelenideElement inputYearCard = $x("//*[@class='input-group__input-case']//*[@placeholder='22']");
    private final SelenideElement inputOwnerCard = $x("//*[@class='input-group__input-case']//*[contains(text(), 'CVC/CVV')]//ancestor::span//*[@class='input-group__input-case'][1]//*[@class='input__box']");
    private final SelenideElement inputCVCCard = $x("//*[@class='input-group__input-case']//*[contains(text(), 'CVC/CVV')]");
    private final SelenideElement nextMove = $x("//*[@method='post']//*[@type='button']");
    private final SelenideElement notification = $x("//*[@class='notification__icon']");

    //public PurchasePage dateCard(DataHelper.CardNumber card, DataHelper.EndOfActionCardMonth month, DataHelper.EndOfActionCardYear year, DataHelper.OwnerCard owner, DataHelper.CVCCodeCard cvc) {
    //    inputNumberCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
    //    inputNumberCard.setValue(String.valueOf(card));
    //    inputMonthCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
    //    inputMonthCard.setValue(month.getMonth());
    //    inputYearCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
    //    inputYearCard.setValue(year.getYear());
    //    inputOwnerCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
    //    inputOwnerCard.setValue(owner.getOwner());
    //    inputCVCCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
    //    inputCVCCard.setValue(cvc.getCvcCode());
    //    nextMove.click();
    //    return new PurchasePage();
    //}

    public PurchasePage numberCard(DataHelper.CardNumber card) {
        inputNumberCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputNumberCard.setValue(String.valueOf(card));
        return new PurchasePage();
    }

    public PurchasePage monthCard(DataHelper.EndOfActionCardMonth month) {
        inputMonthCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputMonthCard.setValue(String.valueOf(month.getMonth()));
        return new PurchasePage();
    }

    public PurchasePage yearCard(DataHelper.EndOfActionCardYear year) {
        inputYearCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputYearCard.setValue(String.valueOf(year));
        return new PurchasePage();
    }

    public PurchasePage dataCard(DataHelper.OwnerCard owner, DataHelper.CVCCodeCard cvc) {
        //inputOwnerCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        //inputOwnerCard.setValue(owner.getOwner());
        inputCVCCard.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        inputCVCCard.setValue(cvc.getCvcCode());
        return new PurchasePage();
    }

    public PurchasePage postData() {
        notification.shouldBe(visible);
        return new PurchasePage();
    }
}
