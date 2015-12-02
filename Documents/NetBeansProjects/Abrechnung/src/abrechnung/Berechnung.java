/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrechnung;

import java.util.ArrayList;


public class Berechnung {
      
    public ArrayList<Zug> eingangListe = new ArrayList<Zug>();
    public ArrayList<Zug> ausgangListe = new ArrayList<Zug>();
    
    
    public void sortieren (MyList <Zug> mylz) {
        
        for (int i = 1; i < mylz.list.size(); i++) {
           
       Zug z = mylz.list.get(i);
       
        if ("e".equals(z.typ)){             
            eingangListe.add(z);         
       }        
        else{
            ausgangListe.add(z);
        }
       }
    }
    
    public static void berechnenEingang(MyList<Zug> zuege, MyList<Spedition> sped){
        for(Zug z: zuege.list){
            if(z.typ.equals("e")){
                Berechnung.berechnenEingang(z, sped);
            }
        }
    }
    
    public static void berechnenAusgang(MyList<Zug> zuege, MyList<Spedition> sped){
        for(Zug z: zuege.list){
            if(z.typ.equals("a")){
                Berechnung.berechnenAusgang(z, sped);
            }
        }
    }
    
    public static void berechnenAusgang (Zug z, MyList<Spedition> speditionsliste){
         if ("a".equals(z.typ)){
                
            if ("Zug loeschen".equals(z.spedition)){
                return;
            }
//////////////////////////////////////////////////////////////////////////             
            if(!speditionsliste.map.containsKey(z.spedition)){
              return;}
            
            Spedition d = speditionsliste.get(z.spedition);
            
            if(!d.aAbrechnen){
                return;
            }
            
          z.infrapreis = d.infrastruktur;
          z.bremspreis=d.bremspruefanlage;
          z.rhWupreise = d.umlauf1;  
          z.gespreis = z.bremspreis + z.infrapreis + z.lotspreis + z.rangierarbeitpreis + z.rhWupreise + z.weiterpreis + z.zugabpreis;
          d.gesamtpreis = d.gesamtpreis + z.gespreis;
    }}
    
      /*####################################################
        #                                                    #
        #               Eingangszüge berechen                #
        #                                                    #
        ######################################################*/
    public static void berechnenEingang (Zug z, MyList<Spedition> speditionsliste){
        
         if ("e".equals(z.typ)){
                
            if ("Zug loeschen".equals(z.spedition)){
                return;
            }
//////////////////////////////////////////////////////////////////////////             
            if(!speditionsliste.map.containsKey(z.spedition)){
              return;}
            
            Spedition d = speditionsliste.get(z.spedition);
            
            if(!d.eAbrechnen){
                return;
            }
            
            z.infrapreis = d.infrastruktur;

            switch (z.rhWust) {

                case 0:
                    z.rhWupreise = d.wustKts;
                    break;
                case 1:
                    z.rhWupreise = d.umlauf1;
                    break;
                case 2:
                    z.rhWupreise = d.umlauf2;
                    break;
            }

            if (z.weiterleitung== true) {
                z.weiterpreis = d.weiterleitung;
            } else {
                z.weiterpreis = 0.00;
            }
                      
            if (z.zugabfertigung== true) {
                z.zugabpreis = d.zugabfertigung;
            } else {
                z.zugabpreis = 0.00;
            }
            
            if (z.lotse == true) {
                z.lotspreis = d.lotse;
            } else {
                z.lotspreis = 0.00;
            }
            
            if (z.zugabfertigung == true) {
                z.rangierarbeitpreis = d.rangierarbeit;
            } else {
                z.rangierarbeitpreis = 0.00;
            }
            
            z.wustKts= z.wagenanz*d.wustKts;
            
            // Gesamtpreis Zug
            z.gespreis = z.infrapreis + z.lotspreis + z.rangierarbeitpreis + z.rhWupreise + z.weiterpreis + z.zugabpreis+z.wustKts;
            d.gesamtpreis = d.gesamtpreis + z.gespreis;
            
            
        }
         }
    
    
     
}    

