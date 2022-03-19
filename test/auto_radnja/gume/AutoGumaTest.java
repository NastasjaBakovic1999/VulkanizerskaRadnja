package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	
	AutoGuma ag;
	
	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}


	@Test
	void testAutoGuma() {
		ag = new AutoGuma();
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Continental",16,285,45);
		assertNotNull(ag);
		assertEquals("Continental",ag.getMarkaModel());
		assertEquals(16,ag.getPrecnik());
		assertEquals(285,ag.getSirina());
		assertEquals(45,ag.getVisina());
	}
	
	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Continental");
		assertEquals("Continental",ag.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class,()-> ag.setMarkaModel(null));
	}
	
	@Test 
	void testSetMarkaModelKratakString() {
		assertThrows(java.lang.RuntimeException.class, ()-> ag.setMarkaModel("Co"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"16"
		})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		assertEquals(precnik,ag.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({
		"0,30"
		})
	void testSetPrecnikOpseg(int precnik1, int precnik2) {
		assertThrows(java.lang.RuntimeException.class,()-> ag.setPrecnik(precnik1));
		assertThrows(java.lang.RuntimeException.class,()-> ag.setPrecnik(precnik2));
	}
	
	@ParameterizedTest
	@CsvSource({
		"285"
		})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		assertEquals(sirina,ag.getSirina());
	}

	@ParameterizedTest
	@CsvSource({
		"100,400"
		})
	void testSetSirinaOpseg(int sirina1, int sirina2) {
		assertThrows(java.lang.RuntimeException.class,()-> ag.setSirina(sirina1));
		assertThrows(java.lang.RuntimeException.class,()-> ag.setSirina(sirina2));
	}
	
	@ParameterizedTest
	@CsvSource({
		"45"
		})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		assertEquals(visina,ag.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"20,100"
		})
	void testSetVisinaOpseg(int visina1, int visina2) {
		assertThrows(java.lang.RuntimeException.class,()-> ag.setVisina(visina1));
		assertThrows(java.lang.RuntimeException.class,()-> ag.setVisina(visina2));
	}
	
	@Test
	void testToString() {
		ag.setMarkaModel("Continental");
		ag.setPrecnik(20);
		ag.setSirina(285);
		ag.setVisina(45);
		String str = ag.toString();
		assertTrue(str.contains("Continental"));
		assertTrue(str.contains("20"));
		assertTrue(str.contains("285"));
		assertTrue(str.contains("45"));
	}

	@ParameterizedTest
	@CsvSource({
		"Continental,Camac,20,20,200,200,50,50,false",
		"Continental,Continental,20,22,200,200,50,50,false",
		"Continental,Continental,20,20,202,200,50,50,false",
		"Continental,Continental,20,20,200,200,51,50,false",
		"Continental,Continental,20,20,200,200,50,50,true"
		})
	void testEqualsObject(String marka1,String marka2,int p1,int p2,int s1,int s2,int v1,int v2,boolean equal) {
		ag.setMarkaModel(marka1);
		ag.setPrecnik(p1);
		ag.setSirina(s1);
		ag.setVisina(v1);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel(marka2);
		b.setPrecnik(p2);
		b.setSirina(s2);
		b.setVisina(v2);
		assertEquals(equal, ag.equals(b));
	}

}
