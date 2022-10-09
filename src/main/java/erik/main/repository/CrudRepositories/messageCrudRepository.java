package erik.main.repository.CrudRepositories;

import erik.main.entity.message;
import org.springframework.data.repository.CrudRepository;

public interface messageCrudRepository extends CrudRepository<message,Integer> {
}
