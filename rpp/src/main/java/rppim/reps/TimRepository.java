package rppim.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rppim.jpa.Igrac;
import rppim.jpa.Tim;

public interface TimRepository extends JpaRepository<Tim, Integer> {

	
	Collection<Tim> findByNazivContainingIgnoreCase(String naziv);
}
