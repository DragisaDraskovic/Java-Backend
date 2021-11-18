package rppim.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rppim.jpa.Igrac;
import rppim.jpa.Tim;

public interface IgracRepository extends JpaRepository<Igrac, Integer>{

	Collection<Igrac> findByBrojRegContainingIgnoreCase(String brojReg);
	Collection<Igrac> findByTim (Tim t);		
	
}
