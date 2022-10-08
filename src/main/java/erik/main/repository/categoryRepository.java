package erik.main.repository;

import erik.main.entity.category;
import erik.main.repository.CrudRepositories.categoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class categoryRepository {
    @Autowired
    categoryCrudRepository crudRp;

    public List<category> getAll(){ return(List<category>) crudRp.findAll();}
    public  Optional<category> find(int id){ return (Optional<category>)crudRp.findById(id);}
    public  category save(category c) { return (category) crudRp.save(c);}
    public  void delete(int id){ crudRp.deleteById(id);}

}
