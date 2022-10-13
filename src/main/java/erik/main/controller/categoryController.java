package erik.main.controller;

import erik.main.entity.category;
import erik.main.service.categoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 600)
@RestController
@RequestMapping("api/Category")
public class categoryController {
    @Autowired
    categoryService catServ;

    @GetMapping("/all")
    public List<category> getAll(){
        return catServ.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public category save(@RequestBody category c){
          return  catServ.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public category update(@RequestBody category c){
        return  catServ.Update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        catServ.delete(id);
    }

}
