package ru.tretyakov.data.service.api;


import ru.tretyakov.data.models.Box;

import java.util.Optional;




/**
 * @author A.Tretyakov.
 * @since 05.10.19
 */
public interface XmlParseService {

    Optional<Box> parse(String path);
}
