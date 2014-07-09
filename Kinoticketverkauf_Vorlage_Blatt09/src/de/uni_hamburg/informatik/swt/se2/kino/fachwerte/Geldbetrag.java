package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public final class Geldbetrag
{
	private final int _betragInCent;

	/**
	 * Wählt einen Geldbetrag aus.
	 * 
	 * @param eurocent
	 *            Der Betrag in ganzen Euro-Cent
	 * 
	 */
	private Geldbetrag(int eurocent)
	{
		//assert eurocent >= 0 : "Vorbedingung verletzt: eurocent >= 0";
		_betragInCent = eurocent;
	}

	// TODO Konstruktor für String fertig

	/**
	 * Konvertiert einen Integer in einen Geldbetrag
	 * 
	 * @param betrag
	 *            Integer
	 * @return den Kovertierten Geldbetrag
	 */
	public static Geldbetrag get(int betrag)
	{
		return new Geldbetrag(betrag);
	}

	/**
	 * Konvertiert einen String in einen Geldbetrag
	 * 
	 * @param s
	 *            der String
	 * @return der Konvertierte Geldbetrag
	 */
	public static Geldbetrag get(String s)
	{
		/*String[] stringArray = s.split(",");

		assert stringArray.length <= 2 : "Vorbedingung verletzt: stringArray.length <= 2";*/
		
		return new Geldbetrag((int) Math.round(Double.parseDouble(s.replace(",", ".")) * 100));
		/*int i = 0;
		try
		{
			i = Integer.parseInt(stringArray[0]) * 100;
			if (stringArray.length == 2)
			{
				i += Integer.parseInt(stringArray[1]);
			}
		}
		catch (Exception e)
		{
 
		}
		return new Geldbetrag(i);*/
	}

	/**
	 * Gibt den Centbetrag zurück.
	 */
	public int getBetragInCent()
	{
		return _betragInCent;
	}

	/**
	 * Liefert einen formatierten String des Geldbetrags in der Form "10,23"
	 * zurück.
	 * 
	 * @return eine String-Repräsentation.
	 */
	public String getFormatiertenString()
	{
		if (_betragInCent < 0 && _betragInCent > -100)
		{
			return "-" + _betragInCent / 100 + "," + getFormatiertenCentAnteil();
		} else
		{
			return _betragInCent / 100 + "," + getFormatiertenCentAnteil();
		}
	}

	/**
	 * Liefert einen zweistelligen Centbetrag zurück.
	 * 
	 * @return eine String-Repräsentation des Cent-Anteils.
	 */
	private String getFormatiertenCentAnteil()
	{
		String result = Math.abs(_betragInCent % 100) + "";
		if (Math.abs(_betragInCent % 100) < 10)
		{
			result = "0" + result;
		}
		return result;
	}

	@Override
	public int hashCode()
	{
		return _betragInCent;
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean result = false;
		if (obj instanceof Geldbetrag)
		{
			Geldbetrag other = (Geldbetrag) obj;
			result = (_betragInCent == other._betragInCent);
		}
		return result;
	}

	/**
	 * Gibt diesen Geldbetrag in der Form "10,21" zurück.
	 */
	@Override
	public String toString()
	{
		return getFormatiertenString();
	}

	/**
	 * Addiert zwei Geldbeträge
	 * 
	 * @param g1
	 *            der erste Summand
	 * @param g2
	 *            der zweite Summand
	 * @return der addierte Geldbetrag
	 */
	public static Geldbetrag addiere(Geldbetrag g1, Geldbetrag g2)
	{
		return new Geldbetrag(g1.getBetragInCent() + g2.getBetragInCent());
	}

	/**
	 * Subtrahiert 2 Geldbeträge
	 * 
	 * @param g1
	 *            der Geldbetrag, von dem g2 abgezogen wird
	 * @param g2
	 *            der Geldbetrag, der von g1 abgezogen wird
	 * @return der subtrahierte Geldbetrag
	 */
	public static Geldbetrag subtrahiere(Geldbetrag g1, Geldbetrag g2)
	{
		return new Geldbetrag(g1.getBetragInCent() - g2.getBetragInCent());
	}

	/**
	 * Multipliziert einen Geldbetrag mit einer Zahl
	 * 
	 * @param g1
	 *            der Geldbetrag
	 * @param i
	 *            die Zahl
	 * @return der multiplizierte Geldbetrag
	 */
	public static Geldbetrag multipliziere(Geldbetrag g1, int i)
	{
		return new Geldbetrag(g1.getBetragInCent() * i);
	}
}
