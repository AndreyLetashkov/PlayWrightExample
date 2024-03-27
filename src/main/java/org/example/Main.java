package org.example;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Main {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/index.php");

        Locator myAccount = page.locator("//a[contains(.,'My account')][@role='button']");
        myAccount.hover();
		page.click("//a[contains(.,'Login')]");
        assertThat(page).hasTitle("Account Login");
        page.getByPlaceholder("E-Mail Address").type("letashkaf123@gmail.com");
        page.getByPlaceholder("Password").type("Qazwsx12");
        page.click("//input[@value='Login']");
        assertThat(page).hasTitle("My Account");
        page.close();
        browser.close();
        playwright.close();
        System.out.println();
        System.out.println(2);
    }
}