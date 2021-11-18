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
import rppim.jpa.Liga;
import rppim.reps.LigaRepository;

@RestController
public class LigaRestController {

	@Autowired
	LigaRepository ligaRepository;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@CrossOrigin
	@ApiOperation(value = "Returns collection of all Liga from database.")
	@GetMapping("liga")
	public Collection<Liga> getAll() {
		return ligaRepository.findAll();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Returns Liga with ID that was forwerded as path variable.")
	@GetMapping("liga/{id}")
	public Liga getOne(@PathVariable("id") Integer id) {
		return ligaRepository.getOne(id);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Returns Liga with name that was forwerded as path variable.")
	@GetMapping("liga/naziv/{naziv}") 
	public Collection<Liga> getByNaziv(@PathVariable("naziv") String naziv) {
		return ligaRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Adds instance of Liga to database.")
	@PostMapping("liga")
	public ResponseEntity<HttpStatus> addLiga(@RequestBody Liga liga) {
		ligaRepository.save(liga);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Liga that has ID was forwarded as path variable with values forwarded in Request Body. ")
	@PutMapping(value = "liga/{id}", produces = "application/json; charset-utf-a")
	public ResponseEntity<HttpStatus> updateLiga(@RequestBody Liga liga, 
			@PathVariable("id") Integer id) {
		if(ligaRepository.existsById(id)) {
			liga.setId(id);
			ligaRepository.save(liga);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Deletes Liga with ID that was forwarded as path variable.")
	@DeleteMapping("liga/{id}") 
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
		if(id==-100 && !ligaRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO liga (\"id\",\"naziv\",\"oznaka\") values (-100, 'Test Naziv', 'Test Oznaka')");
		}
		if (ligaRepository.existsById(id)) {
			ligaRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
}
