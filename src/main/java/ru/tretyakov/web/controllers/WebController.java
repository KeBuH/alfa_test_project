package ru.tretyakov.web.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tretyakov.data.repository.api.ItemRepository;
import ru.tretyakov.web.dto.Lookup;

import java.util.List;

/**
 * @author A.Tretyakov.
 * @since 05.10.19
 */
@RestController
public class WebController {

    private final ItemRepository repository;

    public WebController(ItemRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/items/lookup")
    public List<Integer> lookup(@RequestBody Lookup dto) {
        return repository.getItemsIdsByColor(dto.getBox(), dto.getColor());
    }

}
