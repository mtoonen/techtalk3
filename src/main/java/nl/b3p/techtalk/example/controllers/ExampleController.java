package nl.b3p.techtalk.example.controllers;

import nl.b3p.techtalk.example.repositories.ExampleRepo;
import nl.b3p.techtalk.example.resources.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("examples")
@RestController
public class ExampleController {

    @Autowired
    private ExampleRepo repo;

    @GetMapping("all")
    public List<Example> view(){
        return repo.findAll();
    }

    @GetMapping("{id}")
    public Example find(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public void save(@RequestBody Example ex){
        repo.save(ex);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }

}
