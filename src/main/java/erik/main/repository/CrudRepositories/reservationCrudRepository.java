package erik.main.repository.CrudRepositories;

import erik.main.entity.reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface reservationCrudRepository extends CrudRepository<reservation,Integer> {
    public List<reservation> findAllByStatus(String status);
    public List <reservation> findAllByDate(Date f1, Date f2);

    @Query("select c.client, count (c.client) from  reservation  as c group by  c.client order by  count (c.client) desc ")
    public  List<Object[]> countOfTotalClientByReservation();

}
