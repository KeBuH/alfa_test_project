package ru.tretyakov.data.service.api;

import org.springframework.boot.ApplicationRunner;
import ru.tretyakov.data.models.Box;

import java.util.Optional;

/**
 * @author A.Tretyakov.
 * @since 05.10.19
 */
public interface StartupService extends ApplicationRunner {

    Optional<Box> getBoxes(String path);

}
