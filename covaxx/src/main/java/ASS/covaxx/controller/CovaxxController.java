package ASS.covaxx.controller;

import ASS.covaxx.model.Covaxx;
import ASS.covaxx.repo.CovaxxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class CovaxxController {

    @Autowired
    private CovaxxRepo CovaxxRepo;

    @GetMapping("/practices")
    public @ResponseBody Collection<Covaxx> getAll(){

        return this.CovaxxRepo.getAll();
    }

    @GetMapping("/practices/{practiceId}")
   public @ResponseBody Covaxx getOne(
           @PathVariable String practiceId) {
        return this.CovaxxRepo.getById(practiceId);

   }

   @PostMapping("/practices")
   public @ResponseBody Covaxx createNew(@RequestBody Covaxx covaxx) {
        this.CovaxxRepo.save(covaxx);

        return covaxx;
   }

   @PatchMapping("/practices/{practiceId}")
   public @ResponseBody Covaxx updateExisting(@PathVariable String practiceId, @RequestBody Covaxx changes) {

        Covaxx existingCovaxx = this.CovaxxRepo.getById(practiceId);


        if (changes.practiceName != null)
            existingCovaxx.practiceName = changes.practiceName;

        this.CovaxxRepo.save(existingCovaxx);

        return existingCovaxx;


   }

}
