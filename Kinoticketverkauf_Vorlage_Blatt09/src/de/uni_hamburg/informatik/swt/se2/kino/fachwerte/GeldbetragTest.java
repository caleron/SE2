package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class GeldbetragTest
{
	@Test
	public void testeKonstruktor()
	{
		Geldbetrag g = Geldbetrag.get(101);
        assertEquals(101, g.getBetragInCent());
	}
	
	@Test
    public final void testGeldbetrag()
    {
		// TODO teste negative Beträge
        Geldbetrag betrag = Geldbetrag.get(100);
        assertEquals("1,00", betrag.getFormatiertenString());

        betrag = Geldbetrag.get(0);
        assertEquals("0,00", betrag.getFormatiertenString());

        betrag = Geldbetrag.get(99);
        assertEquals("0,99", betrag.getFormatiertenString());

        betrag = Geldbetrag.get(101);
        assertEquals("1,01", betrag.getFormatiertenString());
    }
	
	//TODO test addiere, subtrahiere, multipliziere
	
	@Test
	public final void testAddiere()
	{
		Geldbetrag betrag = Geldbetrag.get(145);
		Geldbetrag betrag2 = Geldbetrag.get(-5);
		assertTrue(140 == Geldbetrag.addiere(betrag, betrag2).getBetragInCent());
		
		Geldbetrag betrag3 = Geldbetrag.get(145);
		Geldbetrag betrag4 = Geldbetrag.get(5);
		assertTrue(150 == Geldbetrag.addiere(betrag3, betrag4).getBetragInCent());
		
		Geldbetrag betrag5 = Geldbetrag.get(-145);
		Geldbetrag betrag6 = Geldbetrag.get(-5);
		assertTrue(-150 == Geldbetrag.addiere(betrag5, betrag6).getBetragInCent());
	}
	
	@Test
	public final void testSubtrahiere()
	{
		Geldbetrag betrag = Geldbetrag.get(145);
		Geldbetrag betrag2 = Geldbetrag.get(-5);
		assertTrue(150 == Geldbetrag.subtrahiere(betrag, betrag2).getBetragInCent());
		
		Geldbetrag betrag3 = Geldbetrag.get(145);
		Geldbetrag betrag4 = Geldbetrag.get(5);
		assertTrue(140 == Geldbetrag.subtrahiere(betrag3, betrag4).getBetragInCent());
		
		Geldbetrag betrag5 = Geldbetrag.get(-145);
		Geldbetrag betrag6 = Geldbetrag.get(-5);
		assertTrue(-140 == Geldbetrag.subtrahiere(betrag5, betrag6).getBetragInCent());
	}

    @Test
    public final void testEqualsHashcode()
    {
        Geldbetrag betrag1 = Geldbetrag.get(100);
        Geldbetrag betrag2 = Geldbetrag.get(100);
        assertTrue(betrag1.equals(betrag2));
        assertTrue(betrag1.hashCode() == betrag2.hashCode());

        Geldbetrag betrag3 = Geldbetrag.get(101);
        assertFalse(betrag1.equals(betrag3));
        assertFalse(betrag1.hashCode() == betrag3.hashCode());

        Geldbetrag betrag4 = Geldbetrag.get(1000);
        assertFalse(betrag1.equals(betrag4));
        assertFalse(betrag1.hashCode() == betrag4.hashCode());
    }
}
