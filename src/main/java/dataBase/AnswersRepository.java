package dataBase;

import java.util.List;

public class AnswersRepository extends AbstractRepository<AnswersEntity, String> {

    /**
     * Finds the answer with the specified id.
     *
     * @param id The given id.
     * @return The answer.
     */
    public String findById(int id) {
        return Manager.getInstance().getManager().find(AnswersEntity.class, id).getAnswer();
    }

    /**
     * Finds all entities in the database.
     *
     * @return A list of entities.
     */
    public List<AnswersEntity> findAll() {
        return Manager.getInstance().getManager().createNamedQuery("AnswersEntity.findAll", AnswersEntity.class)
                .getResultList();
    }
}

