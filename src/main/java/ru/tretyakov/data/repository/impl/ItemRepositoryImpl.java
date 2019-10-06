package ru.tretyakov.data.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tretyakov.data.repository.api.ItemRepository;

import java.util.List;


/**
 * @author A.Tretyakov.
 * @since 04.10.19
 */
@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final JdbcTemplate template;
    private static final String COLUMN = "id";
    private static final String QUERY =
            "WITH RECURSIVE pc (id) AS (SELECT id FROM BOX WHERE id = ? " +
                    "UNION ALL" +
            " SELECT child.id FROM BOX AS child JOIN pc ON pc.id = child.CONTAINED_IN) " +
            "SELECT pr.ID FROM ITEM pr JOIN pc on pr.CONTAINED_IN = pc.id WHERE pr.COLOR=?;";


    public ItemRepositoryImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Integer> getItemsIdsByColor(int id, String color) {
        List<Integer> result = null;
        try {
            result = template.query(QUERY, new Object[] {id, color},
                    (r, i) ->
                    r.getInt(COLUMN));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
