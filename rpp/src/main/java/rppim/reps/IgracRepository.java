package rppim.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rppim.jpa.Igrac;
import rppim.jpa.Tim;

public interface IgracRepository extends JpaRepository<Igrac, Integer>{

	Collection<Igrac> findByBrojRegContainingIgnoreCase(String brojReg);
	Collection<Igrac> findByTim (Tim t);		//vraca sve igrace za odredjeni Tim
	
		// metodu sa @Query nije bilo moguce implementirati zato sto u bazi u tabeli igrac nema nikakva "kolona" u koju bi mogli da se dodaju novi "brojevi"
		//bilo bi moguce da je brojReg bio unosen u bazu po redu od 1 pa nadalje, ali su brojReg bili random brojevi.
	
	/*
	 * Svaka stavka porudžbine unutar jedne porudžbine ima svoj redni broj. Potrebno je da se stavke
	 * porudžbine numerišu od 1, pa nadalje. Da bi se to postiglo deklarisana je metoda nextRBR kojoj
	 * se prosleđuje ID poružbine, a čijim pozivom će biti izvršen SQL upit naveden u okviru anotacije
	 * @Query
	 * Objašnjenje:
	 * - vrednost ?1 i uzrazu predstavlja vrednost koja će biti prosleđena na osnovu vrednosti
	 * porudžbinaId iz deklaracije metode
	 * - coleasce(val1, val2, ...) - vraća prvu not null vrednost iz prosleđenog izraza
	 * - max(redni_broj)+1 - vraća nejveću vrednost za redni_broj, uvećanu za jedan
	 * - coalesce(max(redni_broj)+1, 1) - ukoliko ne postoji ni jedna stavka porudžbine za određenu
	 * porudžbinu, vrednost max(redni_broj)+1 će biti null, što znači da izraz ima vrednost
	 * coalesce(null, 1) i kao rezultat izvršavanja biće prosleđena vrednost 1 što je i potrebno za
	 * prvu stavku porudžbine unutar nove porudžbine
	 */
}
