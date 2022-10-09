package erik.main.repository.CrudRepositories;

import erik.main.entity.reservation;
import org.springframework.data.repository.CrudRepository;

public interface reservationCrudRepository extends CrudRepository<reservation,Integer> {
}
