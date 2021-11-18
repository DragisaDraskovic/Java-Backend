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

import io.swagger.annotations.ApiOperation;
import rppim.jpa.Igrac;
import rppim.jpa.Tim;
import rppim.reps.IgracRepository;
import rppim.reps.TimRepository;

@RestController
public class IgracRestController {

	@Autowired
	IgracRepository igracRepository;		//povezuje sa Repository-em
	
	@Autowired
	TimRepository timRepository;			//povezuje me sa timRepository
	
	@Autowired
	private JdbcTemplate jdbcTemplate;			//da bi primenili -100 za brisanje/delete
	
	@CrossOrigin
	@ApiOperation(value = "Returns a collection with all Igrac from database.")
	@GetMapping("igrac")
	public Collection<Igrac> getAll()	{
		return igracRepository.findAll();	
	}
	
	@CrossOrigin
	@ApiOperation(value = "Returns Igrac with a forwarded ID.")
	@GetMapping("igrac/{id}")
	public Igrac getOne(@PathVariable("id")Integer id) {
		return igracRepository.getOne(id);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Returns a collection Igrac from Tim for which the ID forwarded.")
	@GetMapping("igracTima/{id}")
	public Collection<Igrac> getAllForTim(@PathVariable("id")Integer id)	{
		Tim t = timRepository.getOne(id);
		return igracRepository.findByTim(t);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Returns Igrac for whom the brojReg wa forwarded.")
	@GetMapping("igracBrojReg/{brojReg}")
	public Collection<Igrac> getByBrojReg(@PathVariable("brojReg") String brojReg) {
		return igracRepository.findByBrojRegContainingIgnoreCase(brojReg);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Add instance of Igrac to database.")
	@PostMapping("igrac")
	public ResponseEntity<HttpStatus> addIgrac(@RequestBody Igrac igrac) {
		igracRepository.save(igrac);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Updates Igrac thahas ID that was forwarded as path variable with values forwarded in Request Body.")
	@PutMapping(value = "igrac/{id}")
	public ResponseEntity<HttpStatus> updateIgrac(@RequestBody Igrac igrac, @PathVariable("id") Integer id) {
		if(!igracRepository.existsById(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		igrac.setId(id);
		igracRepository.save(igrac);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Delete Igrac with ID that was forwarded as path variable.")
	@DeleteMapping("igrac/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
		if(id == -100 && !igracRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO igrac (\"id\", \"ime\", \"prezime\", \"broj_reg\", \"datum_rodjenja\", \"nacionalnost\", \"tim\") "
					+ "VALUES ('-100', 'Test ime', 'Test prezime', 'Test registracija', to_date('01.07.1997.', 'dd.mm.yyyy.'), '1', '1')");
		}
		if (igracRepository.existsById(id)) {
			igracRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
}
	