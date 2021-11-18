package rppim.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the nacionalnost database table.
 * 
 */
@Entity
@NamedQuery(name="Nacionalnost.findAll", query="SELECT n FROM Nacionalnost n")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nacionalnost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NACIONALNOST_ID_GENERATOR", sequenceName="NACIONALNOST_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NACIONALNOST_ID_GENERATOR")
	private Integer id;

	private String naziv;

	private String skracenica;
	
	/*
	 * Ukoliko pogledate semu koju smo koristili za kreiranje baze podataka mozete videti da je artikal strani kljuc u relaciji stavkaporudzbina i 
	 * da se jedan artikal moze naci u vise stavki porudzbine, a da jedna stavka porudzbine moze imati samo jedan artikal. Iako se u tabeli artikal
	 * ne nalaze kolona Stavka_Porudzbina, ona se u ovoj klasi pojavljuje zato sto se po automatizmu prilokom kreiranja JPA klasa kreira tzv. bidirekciona
	 * asocijacija izmedju Artikla i StavkePorudzbine sto je naglaseno komentarom na engleskom jeziku nekoliko linija nize.
	 * Bidirekciona asocijacija oznacava da je moguce "navigirati" sa obe strane , odnosno da je "preko" klase Artikl  moguce doci do svih stavki porudzbine u
	 * kojima se odredjeni artikl nalazi i obrnuto, da je preko klase  StavkaPorudzbina moguce doci do svih artikala koji se nalaze u stavki porudzbina.
	 * Ukoliko nije potrebno bidirekciona navigacija asocijacije , moguce je realizovati tzv. unidirekcionu asocijaciju.
	 * PROTUMACITI ZA SVOJ PRIMER!!! I ovo je promenjljivo i za klasu Liga!!!
	 * ANOTACIJA OneToMany znaci da se moze mapirati od jedan ka vise
	 */

	/*
	 * JsonIgnore je FasterXML/Jackson anotacija koja oznacava da odredjenu vraijablu instance treba ignorisati. Ova anotacija nije kreirana prilokom automatskog
	 * generisanja JPA klase vec nakradno dodata. Bez ove anotacija stvorila bi se beskonacna petlja prilikom pokusaja prikaza podataka iz baze podataka. Ukoliko
	 * bi npr. zatrazili da se prikazu svi artikli, kada bi ucitali prvi, jedna od vrednosti bile bi stavke porudzbina gde se taj artikal moze pronaci, pa
	 * bi se  prikazali podaci vezani za konkretne stavke poruzbine. U svakoj stavci porucbine postoji "drugi kraj" bidirekcionih mapiranja, koji pokazuje na 
	 * Artikl, pa bi se vratili u Artikl klasu, iz nje ponovo u stavku porudzbine i tako beskonacno.
	 * Kako izgleda pomenuti problem moze se testirati ukoliko se zakomentarise ova anotacija i pokusa prikaz podataka o jednom ili svih artikala
	 */
	//bi-directional many-to-one association to Igrac
	@OneToMany(mappedBy="nacionalnost")
	@JsonIgnore
	private List<Igrac> igracs;

	public Nacionalnost() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkracenica() {
		return this.skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}

	public List<Igrac> getIgracs() {
		return this.igracs;
	}

	public void setIgracs(List<Igrac> igracs) {
		this.igracs = igracs;
	}

	public Igrac addIgrac(Igrac igrac) {
		getIgracs().add(igrac);
		igrac.setNacionalnost(this);

		return igrac;
	}

	public Igrac removeIgrac(Igrac igrac) {
		getIgracs().remove(igrac);
		igrac.setNacionalnost(null);

		return igrac;
	}

}