package ar.educacionit.com.repository;

import ar.educacionit.com.models.Auto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AutoRepository {

    //Map es la interfaz, HashMap es una clase en cambio.
    private Map<Long, Auto> base;

    public AutoRepository() {
        base = new HashMap();
    }

    public Long save(Auto a) {
        Long id = (new Random()).nextLong();
        a.setId(id);
        base.put(id, a);
        return id;
    }

    public void delete(Long id) {
        base.remove(id);
    }

    public List<Auto> get() {
        return new ArrayList(base.values());
    }

    public Auto get(Long id) {
        return base.get(id);
    }
    
    public void update(Auto a){
        base.put(a.getId(), a);
    } 

}
