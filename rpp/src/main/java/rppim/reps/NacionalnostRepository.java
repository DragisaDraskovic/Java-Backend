package rppim.reps;

import java.util.Collection;	
import org.springframework.data.jpa.repository.JpaRepository;

import rppim.jpa.Igrac;
import rppim.jpa.Nacionalnost;

	/*
	 * Kao i kada zelimo da neku postojecu klasu prosirimo nekim novim metodama i u ovom slucaju zelimo da metode koje su deklarisane unutar interfejsa 
	 * JpaRepository prosirimo nekim novim. Neke od metoda koje su deklarisane u u JpaRepository su : List<T> findAll() i getOne(ID id);
	 */

	/*
	 *  JPA omogucava manuelno kreiranje upita, kao sto je npr. kreiran upit sa anotacijom @NameQuery u klasi Nacionalost, ali i kreiran upit na osnovu naziva
	 *  metoda. Postoji odredjen broj rezervisanih reci koje mozete koristiti u nazivima metoda, a koje ce omoguciti da se iz samog naziva automatski generise
	 *  upit. Neke od rezervisanih reci su npr. StartWith, EndWith, NotContaining, Containing, Contains, And, After, Like, OrderBy itd... U konkretnom slucaju
	 *  upotrebom rezervisanih reci definisana je metoda koja ce pronalaziti sve artikle koje u nazivu sadrze prosledjen String ignorisuci da li je napisan
	 *  malim ili velikim slovom
	 */

public interface NacionalnostRepository extends JpaRepository<Nacionalnost, Integer> { //prosirujemo JpaRepository zato sto vec sadrzi nama potrebne metode

	Collection<Nacionalnost> findByNazivContainingIgnoreCase(String naziv);

	

	

}
