package erik.main.repository.CrudRepositories;

import erik.main.entity.bike;
import org.springframework.data.repository.CrudRepository;

public interface bikesCrudRepository extends CrudRepository<bike,Integer> {
}
