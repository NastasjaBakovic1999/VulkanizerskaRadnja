package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji definise neku radnju
 * 
 * @author Nastasja Bakovic
 *
 */
public interface Radnja {
	/**
	 * Metoda koja vrsi dodavanje nove gume u radnju
	 * @param a - Auto guma koja se dodaje u radnju.
	 * @throws java.lang.NullPointerException - ukoliko je uneta guma null
	 * @throws java.lang.RuntimeException - ukoliko uneta guma vec postoji u radnji
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Metoda koja vraca listu auto guma za prosledjeni model marke gume
	 * 
	 * @param markaModel - model marke auto gume
	 * @return 
	 * <ul>
	 * <li>null ukoliko je uneti model marke null</li>
	 * <li>lista koja sadrzi sve gume za uneti model marke</li>
	 * </ul>
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Metoda koja vraca listu svih auto guma koje se nalaze u radnji
	 * 
	 * @return lista koja sadrzi sve gume koje se nalaze u radnji
	 */
	List<AutoGuma> vratiSveGume();
	
}