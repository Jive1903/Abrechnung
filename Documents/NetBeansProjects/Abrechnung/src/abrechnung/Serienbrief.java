/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrechnung;

   
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException;
import java.io.PrintWriter; 
import java.util.Iterator;

public class Serienbrief {

      public void writeGes(MyList<Spedition> speditionen) throws IOException { 
        PrintWriter pWriter = null; 
        
        try { 
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\MasnikJ\\Documents\\Abrechnung\\QuelleSerienbrief.txt"))); 
            
            pWriter.print("Kundennr\tFname\tAdresse1\tAdresse2\tAdresse3\tAdresse4\t "
                    + "BestellNr\tMaterialNr\tKostenstelle\tNettobetrag\tUstkennzeichen\tZuzsatz_UST\t "
                    + "Datum\tZahlungsbedingungen\tHinweis!");
            for(Spedition s: speditionen.list){
                   pWriter.print(s.toString()); 
            }
        } 
        catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        finally { 
            if (pWriter != null){ 
                pWriter.flush(); 
                pWriter.close(); 
            } 
        } 
    }

      public void writeEinzelE(MyList<Spedition> speditionen,MyList<Zug> zuege) throws IOException { 
        PrintWriter pWriter = null; 
        
        try { 
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\MasnikJ\\Documents\\Abrechnung\\QuelleEinzelnachweis.txt"))); 
            
            pWriter.print("Spedition\tZugNr\tInfra\tRhWust\tWustKts\tBrems\tLotse\t"
                    + "Ankunft\tRangieren\tZugab\tWeiterleitung\tGespreis!");
            for(Spedition s: speditionen.list){
                   pWriter.print(s.toString()); 
            }
        } 
        catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        finally { 
            if (pWriter != null){ 
                pWriter.flush(); 
                pWriter.close(); 
            } 
        } 
    } 
  }

