package ru.tretyakov.data.repository.api;

import java.util.List;

/**
 * @author A.Tretyakov.
 * @since 04.10.19
 */
public interface ItemRepository {

    List<Integer> getItemsIdsByColor(int id, String color);

}
