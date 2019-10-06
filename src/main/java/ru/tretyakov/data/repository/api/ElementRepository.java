package ru.tretyakov.data.repository.api;

import org.springframework.data.repository.CrudRepository;
import ru.tretyakov.data.models.Box;

/**
 * @author A.Tretyakov.
 * @since 05.10.19
 */
public interface ElementRepository extends CrudRepository<Box, Long> {
}
