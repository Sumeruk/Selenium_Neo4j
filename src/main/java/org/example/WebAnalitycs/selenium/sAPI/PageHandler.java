package org.example.WebAnalitycs.selenium.sAPI;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.example.WebAnalitycs.Entities.Nodes.Page;
import org.example.WebAnalitycs.Repository.PersonRepository;
import org.example.WebAnalitycs.Repository.RelRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PageHandler  {

    private WebDriver driver;

    public Page getAllPagesByURL(String url){
        driver = new ChromeDriver();
        driver.get(url);

        String currTitle = driver.getTitle();
        String currUrl = driver.getCurrentUrl();

        //todo список - соседние узлы, получаемый рекурсивно обходом всех ссылок на странице
        Page currPage = new Page(currTitle, currUrl, new ArrayList<>());

        driver.quit();
        return currPage;
    }


}
