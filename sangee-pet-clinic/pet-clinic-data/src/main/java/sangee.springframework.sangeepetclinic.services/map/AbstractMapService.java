package sangee.springframework.sangeepetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import sangee.springframework.sangeepetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

	protected Map<Long,T> map= new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T findById(ID id){
		return map.get(id);
	}
	
	T save(T o){
		if(o !=null){
			if(o.getId() == null){
				o.setId(getNextId());
			}
			map.put(o.getId(),o);
		}
		else{
			throw new RuntimeException("Object must not be null");
		}
		return o;
	}
	
	void deleteById(ID id){
		map.remove(id);
	}
	
	void delete(T o){
		map.entrySet().removeIf(entry -> entry.getValue().equals(o));
	}
	
	private Long getNextId(){
		Long nextId =null;
		try{
			nextId = Collections.max(map.keySet()) + 1;
		}
		catch(NoSuchElementException e){
			nextId = 1L;
		}
		return nextId;
	}
}
