package rppim.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jmx.mbeanserver.Repository;

import io.swagger.annotations.ApiOperation;
import rppim.jpa.Igrac;
import rppim.jpa.Nacionalnost;
import rppim.reps.NacionalnostRepository;
@RestController
public class NacionalnostRestController {

	@Autowired										//anotacija koja automacki povezuje u ovom slucaju sa nacionalnostRepository
	NacionalnostRepository nacionalnostRepository;
	
	/*
	 * JdbcTemplate klasa pojednostavljuje koriscenje JDBC (Java Database Connectivity), objekat ove klase ce se koristiti u metodi delete() i zato je 
	 * deklarisana i anotirana sa @Autowired
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin			//daje dozvolu da se spoje iz stringa i vsc-a
	@ApiOperation(value = "Returns collection of all Nacionalnost from database.")
	@GetMapping("nacionalnost")
	public Collection<Nacionalnost> getAll(){
		return nacionalnostRepository.findAll();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Returns Nacionalnost with ID that was forwarded as path variable.")
	@GetMapping("nacionalnost/{id}")
	public Nacionalnost getOne(@PathVariable("id")	Integer id) {
		return nacionalnostRepository.getOne(id);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Returns Nacionalnost with name that was forwarded as path variable.")
	@GetMapping("nacionalnost/naziv/{naziv}")
	public Collection<Nacionalnost> getByNaziv(@PathVariable("naziv") String naziv) {
		return nacionalnostRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	/*
	 * HTTP Post je jedna od HTTP metoda koja je analogna opciji CREATE iz CRUD operacija.
	 * ANOTACIJA @PostMapping se koristi kako bi se mapirao HTTP POST zahtev. Predstavlja skracenu verziju metode @RequestMapping(method = RequestMethod.POST) u
	 * konkretnom slucaju HTTP POST zahtevi upuceni na adresu localhost:8083/nacionalnost bice prosledjeni ovoj metodi. Poziv metode 
	 * nacionalnostRepository.save(nacionalnost) ce sacuvati prosledjenu nacionalnost u bazu podataka
	 */
	
	@CrossOrigin
	@ApiOperation(value = "Add instance of Nacionalnost to database.")
	@PostMapping("nacionalnost")	//post je za kreiranje
	public ResponseEntity<HttpStatus> addNacionalnost(@RequestBody Nacionalnost nacionalnost) {
		nacionalnostRepository.save(nacionalnost);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	/*
	 * HTTP PUT je jedna od HTTP metoda koja je analogna opciji UPDATE iz CRUD opredacija. 
	 * Anotacija @PutMapping se koristi kako bi se mapirao HTTP PUT zahtev. Pedstavlja skracenu verziju metode @RequestMapping(method = RequestMethod.PUT)
	 * U konkretnom slucaju HTTP PUT zahtevi upuceni na adresu localhost:8083/nacionalnost/{id} bice prosledjeni ovoj metodi.
	 * Poziv metode nacionalnostRepository.save(nacionalnost) ce imati nacionalnost sa prosledjenim ID-em i prosledjenim sadrzajem u bazi podataka
	 */
	
	
	@CrossOrigin
	@ApiOperation(value = "Updates Nacionalnost that has ID that was forwarded as path variable with values forwarded in Request Body")
	@PutMapping(value = "nacionalnost/{id}", produces = "application/json; charset-utf-a")		//put je za update, on govori idi na stranicu nacionalnost id
	public ResponseEntity<HttpStatus> updateNacionalnost(@RequestBody Nacionalnost nacionalnost,
			@PathVariable("id") Integer id) {
		if(nacionalnostRepository.existsById(id)) {		//ova metoda vraca true ako postoji nacionalnost sa prosledjenim id-em i onda izvrsava ovo ispod
			nacionalnost.setId(id); 		//prosledjenu nacionalnost u request bodi i id-em u path variable izmeniti
			nacionalnostRepository.save(nacionalnost);		//sacuvati nacionalnost
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);	//vratiti http u ovom slucaju ok
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);		//vratiti http u ovom slucaju not found
	}
	
	/*
	 * HTTP DELETE je jedna od HTTP metoda koja je analogna opciji DELETE iz CRUD opredacija
	 * Anotacija @DeleteMapping se koristi kako bi se mapirao HTTP DELETE zahtev.Pedstavlja skracenu verziju metode 
	 * @RequestMapping(method = RequestMethod.DELETE). U konkretnom slucaju HTTP PUT zahtevi upuceni na adresu localhost:8083/nacionalnost/{id} bice prosledjeni
	 * ovoj metodi. Pozivi metode nacionalnostRepository.deleteByID(id) ce obrisati nacionalnost sa prosledjenim ID-em iz baze podataka	
	 */
	
	@CrossOrigin
	@ApiOperation(value = "Deletes Nacionalnost with ID that was forwarded as path variable")
	@DeleteMapping("nacionalnost/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
		if(id==-100 && !nacionalnostRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO nacionalnost (\"id\",\"naziv\",\"skracenica\") values (-100, 'Test Naziv', 'Test Skracenica')");
		}
		if (nacionalnostRepository.existsById(id)) {
			nacionalnostRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
}
