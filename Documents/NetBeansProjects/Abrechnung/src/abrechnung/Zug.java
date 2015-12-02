
package abrechnung;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class Zug {

    static Integer getIndex(String Spedition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String zugNr;
    public String datum;
    public String typ;
    public String bemerkung;
    public String wagen;			
    public String bahnhof;	
    public int wagenanz;
    public int rhWust;  
    public boolean weiterleitung; 
    public boolean zugabfertigung;
    public boolean lotse; 
    public boolean rangier; 
    public boolean fehler;
    public String spedition ="";
    public boolean abrechnen;
    public double infrapreis;
    public double bremspreis;
    public double rhWupreise;
    public double wustKts;
    public double weiterpreis;
    public double zugabpreis;
    public double lotspreis; 
    public double rangierarbeitpreis;
    public double gespreis;
    public String abmonat;
    
    
    /**
     * Ermitteln der Wagenanzahl aus bb/l
     */            
    public void wagensumme() {
        int ziffer1;
        String ziffera;
        int ziffer2;
        String zifferb;
        int pos = wagen.lastIndexOf("/");
        if (pos ==1){  
            ziffera = wagen.substring(0,1).trim();
        }
        else{
            ziffera = wagen.substring(0, pos - 1).trim();
        }       
        zifferb = wagen.substring(pos + 1).trim();

        ziffer1 = stringToint(ziffera);
        ziffer2 = stringToint(zifferb);
        wagenanz = ziffer1 + ziffer2;
    }
   /** 
   * konvert string to int
   * @param str 
   * @return int
   */
    public static int stringToint(String str){
       return Integer.parseInt(str);
       }

    public void splitBemerkung(){
        
        // bediengungen testen
        fehler=testen(bemerkung);
        
                 
        if (fehler == true) {
        String ba; // Bemerkungsfeld spliten der Reihenfolg A-E
        String bb;
        String bc;
        String bd;
        String be;
           
       // Position der Zahlen sind bekannt (a/b/c/d/e)
        ba= bemerkung.substring(0,1);
        bb= bemerkung.substring(2,3);
        bc= bemerkung.substring(4,5);
        bd= bemerkung.substring(6,7);
        be= bemerkung.substring(8,9);
        
        //if (ba ==1) 
        rhWust = stringToint(ba);
        weiterleitung = "1".equals(bb);
        zugabfertigung = "1".equals(bc);
        lotse = "1".equals(bd);
        rangier = "1".equals(be);
            }        
        }
    
    public boolean testen (String value){
        // x/x/x/x/x
        Pattern p = Pattern.compile("[0-2]\\/[0-1]\\/[0-1]\\/[0-1]\\/[0-1].*");
        Matcher m = p.matcher(value);
        
        
        if ("".equals(spedition)){
            return false;
        }
            return m.matches();
         }
         
    @Override
    public boolean equals(Object object){
        Zug z = (Zug)object;
        return datum.equals(z.datum)&&zugNr.equals(z.zugNr);
    }
    
     @Override
    public String toString(){  
        
        // Gesamtpreis im Serienbrief - Format überprüfen
         return  spedition + "\t" + zugNr + "\t" + infrapreis + "\t" + rhWupreise + "\t" + wustKts + "\t" + bremspreis + "\t" + lotspreis + "\t" + datum + "\t" + rangierarbeitpreis + "\t" + zugabpreis + "\t" + weiterpreis + "\t" + gespreis + "!";
    }
   }

