package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.Radnja;
import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;
	
	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Continental");
		radnja.dodajGumu(ag);
		
		assertEquals(ag,radnja.pronadjiGumu(ag.getMarkaModel()).get(0));
		
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,()->radnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma ag1=new AutoGuma("Continental",22,285,45);
		AutoGuma ag2=new AutoGuma("Continental",22,285,45);
		radnja.dodajGumu(ag1);
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,()->radnja.dodajGumu(ag2));
		assertEquals(e.getMessage(),"Guma vec postoji");
	}
	
	@Test
	void testPronadjiGumuRazliciteDim() {
		AutoGuma ag1 = new AutoGuma("Continental",20,200,50);
		radnja.dodajGumu(ag1);
		AutoGuma ag2 = new AutoGuma("Continental",21,199,49);
		radnja.dodajGumu(ag2);
		AutoGuma ag3 = new AutoGuma("Aurora",19,220,60);
		radnja.dodajGumu(ag3);
		
		
		List<AutoGuma> gume = radnja.pronadjiGumu("Continental");
		assertEquals(2,gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag2));
	}
	
	@Test
	void testPronadjiGumuIsteDim() {
		AutoGuma ag1 = new AutoGuma("Continental",22,285,45);
		radnja.dodajGumu(ag1);
		AutoGuma ag2 = new AutoGuma("Cont",22,285,45);
		radnja.dodajGumu(ag2);
		
		
		List<AutoGuma> gume = radnja.pronadjiGumu("Continental");
		assertEquals(1,gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(!gume.contains(ag2));
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertEquals(radnja.pronadjiGumu(null),null);
	}
	
	@Test
	void testPronadjiGumuNePostoji() {
		AutoGuma ag1 = new AutoGuma("Continental",22,285,45);
		radnja.dodajGumu(ag1);
		AutoGuma ag2 = new AutoGuma("Michel",20,188,51);
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> gume = radnja.pronadjiGumu("C");
		assertEquals(0,gume.size());
		assertTrue(!gume.contains(ag1));
		assertTrue(!gume.contains(ag2));
	}

	@Test
	void testVratiSveGume() {
		AutoGuma ag1 = new AutoGuma("Continental",22,285,45);
		radnja.dodajGumu(ag1);
		AutoGuma ag2 = new AutoGuma("Michel",20,188,51);
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> gume = radnja.vratiSveGume();
		assertEquals(2,gume.size());
	}
	
	@Test
	void testVratiSveGumeNull() {
		assertEquals(null, radnja.vratiSveGume());
	}
}
