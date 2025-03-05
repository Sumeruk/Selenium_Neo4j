package org.example.WebAnalitycs.Service;

import org.example.WebAnalitycs.Entities.Nodes.Page;
import org.example.WebAnalitycs.Repository.LinkRepository;
import org.example.WebAnalitycs.Repository.PageRepository;
import org.example.WebAnalitycs.Repository.PersonRepository;
import org.example.WebAnalitycs.Repository.RelRepository;
import org.example.WebAnalitycs.selenium.sAPI.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebCrowlerService {

    private PageHandler handler;
    private PageRepository pageRepository;
    private LinkRepository linkRepository;
    @Autowired
    public void setDriver(PageHandler handler) {
        this.handler = handler;
    }

    @Autowired
    public WebCrowlerService(PageRepository pageRepository, LinkRepository linkRepository) {
        this.pageRepository = pageRepository;
        this.linkRepository = linkRepository;
    }

    private void createNodePage(Page page){
        pageRepository.save(page);
    }

    public List<Page> getAllByUrl(String url){
        createNodePage(handler.getAllPagesByURL(url));

        return pageRepository.findAll();
    }
}
