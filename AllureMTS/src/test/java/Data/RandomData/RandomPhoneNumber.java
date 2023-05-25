package Data.RandomData;

public class RandomPhoneNumber {
    public static String tsifri() {
        int intPervoechislo=0;

        int intOstalnoechislo=0;

        int nine=9;

        int one=1;

        int devytDevytok = 999999999;

        int odinVosemNuly=100000000;

        String stringSumma="";

        intPervoechislo=(int)(Math.random()*nine+one);

        intOstalnoechislo=(int)(Math.random()*devytDevytok);

        if (intOstalnoechislo < odinVosemNuly) {
            intOstalnoechislo=odinVosemNuly;
        }

        stringSumma = stringSumma+Integer.toString(intPervoechislo)+Integer.toString(intOstalnoechislo);

        return stringSumma;
    }
}