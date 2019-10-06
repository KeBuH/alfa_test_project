package ru.tretyakov.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tretyakov.data.repository.api.ElementRepository;
import ru.tretyakov.data.service.api.XmlParseService;

import java.util.stream.Stream;


/**
 * @author A.Tretyakov.
 * @since 05.10.19
 */
@Component
public class StartupServiceImpl implements ApplicationRunner {

    private final ElementRepository repository;
    private final XmlParseService xmlParseService;

    @Autowired
    public StartupServiceImpl(ElementRepository repository,
                              XmlParseService xmlParseService) {
        this.repository = repository;
        this.xmlParseService = xmlParseService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
            Stream.of(args.getSourceArgs()).forEach(s ->
                    xmlParseService.parse(s).ifPresent(repository::save));
    }
}
