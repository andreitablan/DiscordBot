package dataBase;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract class AbstractRepository<T extends AbstractEntity, K extends Serializable> {
    protected EntityManager manager;
    private Class<T> type;

    public AbstractRepository() {
        Manager managerInstance = Manager.getInstance();
        manager = managerInstance.getManager();
    }

    /**
     * Queries the database in order to find an answer to a given question.
     *
     * @param question The question sent by the user.
     * @return The answer for the question.
     */
    public String findByQuestion(K question) {
        String answer = manager.createQuery("select a from AnswersEntity a where a.question='" + question + "'", AnswersEntity.class).getResultList().get(0).getAnswer();
        return answer;
    }

}
