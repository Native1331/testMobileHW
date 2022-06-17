package test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class SearchTitleOfQueen extends TestBase {
    @Test
    void searchTittleOfQueenTest() {
        back();
        step("Open search page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Queen");
        });
        step("Verify content found", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(Condition.text("Queen")));

    }

    @Test
     void searchTittleOfQA() {
        step("Open search page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("QA");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(5)));

    }
}




