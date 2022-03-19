package auto_radnja.gume;

/**
 * Klasa koja opisuje gumu za automobil
 * 
 * Guma za automobil se opisuje markom modela gume, precnikom, sirinom i visinom
 * 
 * @author Nastasja Bakovic
 * @version 1.0
 */
public class AutoGuma {
	/**
	 * Marka modela gume definise se preko String tipa podatka; 
	 */
	private String markaModel = null;
	/**
	 * Precnik gume definise se preko integer tipa podatka; Podatak se izrazava u cm
	 */
	private int precnik = -1;
	/**
	 * Sirina gume definise se preko integer tipa podatka; Podatak se izrazava u cm
	 */
	private int sirina = -1;
	/**
	 * Visina gume definise se preko integer tipa podatka; Podatak se izrazava u cm
	 */
	private int visina = -1;
	
	/**
	 * Bezparametarski konstruktor koji inicijalizuje novi objekat klase AutoGuma
	 */
	public AutoGuma() {}
	
	/**
	 * Parametarski konstruktor koji inicijalizuje novi objekat klase AutoGuma i dodeljuje vrednosti za marku modela, precnik, sirinu i visinu
	 * 
	 * @param markaModel - Marka modela gume definise se preko String tipa podatka
	 * @param precnik - Precnik gume definise se preko integer tipa podatka; Podatak se izrazava u cm
	 * @param sirina - Sirina gume definise se preko integer tipa podatka; Podatak se izrazava u cm
	 * @param visina - Visina gume definise se preko integer tipa podatka; Podatak se izrazava u cm
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	
	/**
	 * Vraca marku modela automobilske gume
	 * @return Marka modela kao String tip podatka
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Dodeljuje atributu marka modela novu vrednost. 
	 * 
	 * @param markaModel - Marka modela kao String tip podatka
	 * 
	 * @throws java.lang.NullPointerException ukolike je uneta marka modela null vrednost
	 * @throws java.lang.RuntimeException ukoliko uneta je uneta marka modela duzine manje od 3 znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel==null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length()<3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	
	/**
	 * Vraca precnik automobilske gume
	 * @return Precnik kao integer tip podatka
	 */
	public int getPrecnik() {
		return precnik;
	}
	
	/**
	 * Dodeljuje atributu precnik novu vrednost
	 * 
	 * @param precnik - Precnik kao integer tip podatka
	 *
	 * @throws java.lang.RuntimeException ukoliko je uneti precnik manji od 13 ili veci od 22 
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}
	
	/**
	 * Vraca sirinu automobilske gume
	 * @return Sirina kao integer tip podatka
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Dodeljuje atrubutu sirina novu vrednost
	 * 
	 * @param sirina - Sirina kao integer tip podatka
	 *
	 * @throws java.lang.RuntimeException ukoliko je uneta sirina manja od 135 ili veca od 355 
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}
	
	/**
	 * Vraca visinu automobilske gume
	 * @return Visina kao integer tip podatka
	 */
	public int getVisina() {
		return visina;
	}
	
	/**
	 * Dodeljuje atributu visina novu vrednost. 
	 * 
	 * @param visina - Visina kao integer tip podatka
	 *
	 * @throws java.lang.RuntimeException ukoliko je uneta visina manja od 25 ili veca od 95 
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}
	
	/**
	 * Metoda koja vraca string koji sadrzi vrednosti atrubuta automobilske gume
	 * 
	 * @return String sa podacima o automobilskoj gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina=" + visina + "]";
	}
	
	/**
	 *  Metoda koja vrsi poredjenje dve automobilske gume i vraca true ukoliko su iste, a false ukoliko nisu.
	 * 
	 *  Poredjenje se vrsi po marki modela, precniku, sirini i visini gume i svi atributi moraju da budu isti da bi gume bile iste, odnosno, da bi metoda vratila true.
	 *  
	 *  @return 
	 *  <ul>
	 *  	<li>true ukoliko su: oba objekta klase AutoGuma i ukoliko su im vrednoti za marku modela, precnik, visinu i sirinu jednake </li>
	 *  	<li>false u svim ostalim slucajevima</li>
	 *  </ul>
	 */	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
			if (markaModel == null) {
				if (other.markaModel != null)
				return false;
			} else if (!markaModel.equals(other.markaModel))
				return false;
			if (precnik != other.precnik)
				return false;
			if (sirina != other.sirina)
				return false;
			if (visina != other.visina)
				return false;
			return true;
	}
	
}
