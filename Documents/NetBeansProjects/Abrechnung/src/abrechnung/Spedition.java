/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrechnung;



import java.text.DateFormat;
import java.text.*;
/**
 *
 * @author MasnikJ
 * Daten für die Preise der Leistungen zu den Speditionen 
 * die Speditionsdaten für die Rechnung
 */  
public class Spedition {
    
    
   
    // Preise
    public double infrastruktur;
    public double bremspruefanlage;
    public double wustKts;
    public double umlauf1; 	
    public double umlauf2;
    public double weiterleitung;
    public double zugabfertigung;
    public double lotse; 
    public double rangierarbeit;
      // Daten
    public String spedition;
    public String firmenname;
    public String kundennr;
    public String adresse1;
    public String adresse2;
    public String adresse3;
    public String adresse4;
    public String bestellnr;
    public String materialnr;
    public String kostenstelle;
    public String ustKennzeichen;
    public String zuUST;
    public String zahlung;
    public String hinweis; 
    public double gesamtpreis = 0;
    public String abmonat; // abfrage auf der Startseite
    public boolean eAbrechnen= true;
    public boolean aAbrechnen=true;
    public double eGesamtpreis=0;
    public double aGesamtpreis=0;
    public double infrapreis=50;
    
    
   @Override
    public String toString(){  
        
        // Gesamtpreis im Serienbrief - Format überprüfen
         return kundennr + "\t" + firmenname + "\t" + adresse1 + "\t" + adresse2 + "\t" +adresse3 + "\t" + adresse4 + "\t" + bestellnr + "\t" + materialnr + "\t" +kostenstelle + "\t" + ((double)Math.round((eGesamtpreis+aGesamtpreis)*100)/100) + "\t" + ustKennzeichen + "\t" + zuUST + "\t" + abmonat + "\t" + zahlung + "\t" + hinweis + "!";
    }
}