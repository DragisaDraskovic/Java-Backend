package rppim.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the igrac database table.
 * 
 */
@Entity			//ova klasa mora imati variable instanci ID
@NamedQuery(name="Igrac.findAll", query="SELECT i FROM Igrac i")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Igrac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id			//predstavlja varijablu instance koja mapira primarni kljuc u bazi podataka
	@SequenceGenerator(name="IGRAC_ID_GENERATOR", sequenceName="IGRAC_SEQ", allocationSize=1) //govori kako se kreira taj id, kako se kreira generator sequence
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IGRAC_ID_GENERATOR") //automacki se vredenosti generisu, neophodan parametar je generator sequenca
	private Integer id;

	@Column(name="broj_reg")
	private String brojReg;

	//@Temporal(TemporalType.DATE)
	@Column(name="datum_rodjenja")
	private Date datumRodjenja;

	private String ime;

	private String prezime;
	/* anotacija ManyToOne znaci da se moze mapirati od vise ka jednoj
	 * JoinColumn navodi preko koje se kolone spaja, u ovom slucaju preko kolone nacionalnost, a u primeru preko kolone artikl
	 * 
	 */
	//bi-directional many-to-one association to Nacionalnost
	@ManyToOne
	@JoinColumn(name="nacionalnost")
	private Nacionalnost nacionalnost;

	//bi-directional many-to-one association to Tim
	@ManyToOne
	@JoinColumn(name="tim")
	private Tim tim;

	public Igrac() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrojReg() {
		return this.brojReg;
	}

	public void setBrojReg(String brojReg) {
		this.brojReg = brojReg;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Nacionalnost getNacionalnost() {
		return this.nacionalnost;
	}

	public void setNacionalnost(Nacionalnost nacionalnost) {
		this.nacionalnost = nacionalnost;
	}

	public Tim getTim() {
		return this.tim;
	}

	public void setTim(Tim tim) {
		this.tim = tim;
	}

}