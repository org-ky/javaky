public class Enum {
    
    public static void main(String[] args) {
        System.out.println();

        Level enumValue = Level.LOW;
        System.out.println(enumValue);
        
        int enumValueInt = Level.LOW.ordinal();
        System.out.println(enumValueInt);

        String enumValueString = Level.HIGH.toString();
        System.out.println(enumValueString);

        Level enumInstance = Level.valueOf("HIGH");
        System.out.println(enumInstance);

        for (Level myVar : Level.values()) {
            System.out.println(myVar.ordinal());
            System.out.println(myVar.toString());
        }
        
        Semi2 s2 = Semi2.FIORI;
        System.out.println(s2.isRed());
        System.out.println(s2.getNumeroCarte());
      }
}

enum Level {
    LOW, MEDIUM, HIGH
}

enum Semi2 {
    CUORI(true,10), SPADE(false, 12), QUADRI(true, 23), FIORI(false,28);
    
    private boolean red;
    private int numeroCarte;
    
    private Semi2(boolean red, int numeroCarte) {
      this.red = red;
      this.numeroCarte = numeroCarte;
    }
    public boolean isRed() {
        return red;
      }
    public int getNumeroCarte()
    {
        return numeroCarte;
    }
    
}
