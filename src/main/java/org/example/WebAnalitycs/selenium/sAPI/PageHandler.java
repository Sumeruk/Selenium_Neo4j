package org.example.WebAnalitycs.selenium.sAPI;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.example.WebAnalitycs.Entities.Nodes.Page;
import org.example.WebAnalitycs.Entities.Relations.Link;
import org.example.WebAnalitycs.Repository.PersonRepository;
import org.example.WebAnalitycs.Repository.RelRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PageHandler  {

    private WebDriver driver;

    public Page getAllPagesByURL(String url){
        driver = new ChromeDriver();
        driver.get(url);

        String currTitle = driver.getTitle();
        String currUrl = driver.getCurrentUrl();

        Page currPage = new Page(currUrl, currTitle, new ArrayList<>());

        List<WebElement> allLinksOnThePage = driver.findElements(By.tagName("a"));

        if (allLinksOnThePage.isEmpty()){
            driver.quit();
            return currPage;
        }

        // todo обработать ситуацию зацикливания
        for (WebElement el: allLinksOnThePage) {
            currPage.addOneLink(new Link(getAllPagesByURL(el.getAttribute("href"))));
        }

        driver.quit();
        return currPage;
    }


}
