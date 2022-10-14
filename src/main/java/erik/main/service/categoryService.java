package erik.main.service;


import erik.main.entity.bike;
import erik.main.entity.category;
import erik.main.repository.categoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoryService {

    @Autowired
    categoryRepository categoryRp;

    public List<category> getAll(){
        return categoryRp.getAll();
    }

    public category save(category c){
        if(c.getId() == null){
            return categoryRp.save(c);
        }else{
            Optional<category> Co = categoryRp.find(c.getId());
            if (Co.isPresent()){
               return c;
            }else{
                return categoryRp.save(c);
            }
        }

    }

    public category Update(category c) {
        if (c.getId() != null) {
            Optional<category> Co = categoryRp.find(c.getId());
            if(Co.isPresent()){
                if(c.getName() != null){
                    Co.get().setName(c.getName());
                }
                if(c.getDescription() != null){
                    Co.get().setDescription(c.getDescription());
                }
                categoryRp.save(Co.get());
                return Co.get();
            }else{ return c; }
        }else{ return c; }
    }

    public  boolean delete(int id){
        boolean flag =false;
        Optional <category> c = categoryRp.find(id);

        if (c.isPresent()) {
           categoryRp.delete(id);
           flag =true;
        }

        return  flag;
    }
}
