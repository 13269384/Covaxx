package ASS.covaxx.repo;

import ASS.covaxx.model.Covaxx;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class CovaxxRepo {

    private HashMap<String, Covaxx> covaxxMap = new HashMap<>() ;

    public void save(Covaxx covaxx) {
        this.covaxxMap.put(covaxx.practiceId, covaxx);
    }

    public Covaxx getById(String practiceId) {
        return this.covaxxMap.get(practiceId);

    }

    public Collection<Covaxx> getAll() {
        return this.covaxxMap.values();

    }
    

}
