package com.si.Service;

import com.si.entity.ActualiteEntity;
import com.si.Repository.ActualiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class  ActualiteService {
    @Autowired
    private ActualiteRepository actualiteRepository;

    @RequestMapping(value="/actualite",method= RequestMethod.GET)
    private List<ActualiteEntity> getActualite(){
        return actualiteRepository.findAll();
    }

    @RequestMapping(value="/actualite/{id}",method=RequestMethod.GET)
    private Optional<ActualiteEntity> getcontact(@PathVariable Integer id){
        return actualiteRepository.findById(id);
    }

    @RequestMapping(value="/actualite",method=RequestMethod.POST)
    private String save(ActualiteEntity a){
        actualiteRepository.save(a);
        return "insertion actualite Sucessfully";
    }
    @RequestMapping(value="/actualite/{id}",method=RequestMethod.PUT)
    private ActualiteEntity save(@PathVariable Integer id, @RequestBody ActualiteEntity a){
        a.setId(id);
        return actualiteRepository.save(a);
    }

    @RequestMapping(value="/actualite/{id}",method=RequestMethod.DELETE)
    private boolean supprimer(@PathVariable Integer id){
        actualiteRepository.deleteById(id);
        return true;
    }




}
