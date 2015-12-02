/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrechnung;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jxl.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DatenReader {

    private String xlsDatei;
    public String Spedition;

    public ArrayList<Zug> fehlerListe = new ArrayList<Zug>();

    public MyList readerSpedtion(String xlsDatei) throws IOException {
        this.xlsDatei = xlsDatei;

        MyList<Spedition> liste = new MyList();
        
        File inputWorkbook = new File(xlsDatei);
        Workbook w;

        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);

            // read data
            for (int i = 1; i < sheet.getRows(); i++) {

                Cell speditionCell = sheet.getCell(0, i);
                Spedition = speditionCell.getContents();

                Spedition spedition = new Spedition();
       
                Cell infrastrukturCell = sheet.getCell(1, i);
                spedition.infrastruktur = Double.parseDouble(infrastrukturCell.getContents().replace(",", "."));

                Cell bremspruefanlageCell = sheet.getCell(2, i);
                spedition.bremspruefanlage = Double.parseDouble(bremspruefanlageCell.getContents().replace(",", "."));

                Cell wustktsCell = sheet.getCell(3, i);
                spedition.wustKts = Double.parseDouble(wustktsCell.getContents().replace(",", "."));

                Cell umlauf2Cell = sheet.getCell(4, i);
                spedition.umlauf1 = Double.parseDouble(umlauf2Cell.getContents().replace(",", "."));

                Cell umlauf3Cell = sheet.getCell(5, i);
                spedition.umlauf2 = Double.parseDouble(umlauf3Cell.getContents().replace(",", "."));

                Cell weiterleitungCell = sheet.getCell(6, i);
                spedition.weiterleitung = Double.parseDouble(weiterleitungCell.getContents().replace(",", "."));

                Cell zugabfertigungCell = sheet.getCell(7, i);
                spedition.zugabfertigung = Double.parseDouble(zugabfertigungCell.getContents().replace(",", "."));

                Cell lotseCell = sheet.getCell(8, i);
                spedition.lotse = Double.parseDouble(lotseCell.getContents().replace(",", "."));

                Cell rangierarbeitCell = sheet.getCell(9, i);
                spedition.rangierarbeit = Double.parseDouble(rangierarbeitCell.getContents().replace(",", "."));

                Cell firmennameCell = sheet.getCell(10, i);
                spedition.firmenname = firmennameCell.getContents();

                Cell kundennrCell = sheet.getCell(11, i);
                spedition.kundennr = kundennrCell.getContents();

                Cell adresse1Cell = sheet.getCell(12, i);
                spedition.adresse1 = adresse1Cell.getContents();

                Cell adresse2Cell = sheet.getCell(13, i);
                spedition.adresse2 = adresse2Cell.getContents();

                Cell adresse3Cell = sheet.getCell(14, i);
                spedition.adresse3 = adresse3Cell.getContents();

                Cell adresse4Cell = sheet.getCell(15, i);
                spedition.adresse4 = adresse4Cell.getContents();

                Cell bestellnrCell = sheet.getCell(16, i);
                spedition.bestellnr = bestellnrCell.getContents();

                Cell materialnrCell = sheet.getCell(17, i);
                spedition.materialnr = materialnrCell.getContents();

                Cell kostenstelleCell = sheet.getCell(18, i);
                spedition.kostenstelle = kostenstelleCell.getContents();

                Cell ustkennzeichenCell = sheet.getCell(19, i);
                spedition.ustKennzeichen = ustkennzeichenCell.getContents();

                Cell ustCell = sheet.getCell(20, i);
                spedition.zuUST = ustCell.getContents();

                Cell zahlungCell = sheet.getCell(21, i);
                spedition.zahlung = zahlungCell.getContents();

                Cell hinweisCell = sheet.getCell(22, i);
                spedition.hinweis = hinweisCell.getContents();
                
                spedition.spedition=Spedition;
                
                liste.add(Spedition, spedition); // (key/value)  
            }

        } catch (BiffException e) {
            e.printStackTrace(); // Fehlermeldung der Schleife
        }
        return liste;
    }

    public MyList readerZug(String xlsDatei) throws IOException, BiffException {

        MyList<Zug> liste = new MyList();

        int zugNrSpalte = 0;
        int typSpalte = 0;
        int abfahrtSpalte = 0;
        int ankunftSpalte = 0;
        int bemerkungSpalte = 0;
        int wagenanzSpalte = 0;
        int abhfSpalte = 0;
        int bestSpalte = 0;
        this.xlsDatei = xlsDatei;

        File inputWorkbook = new File(xlsDatei);
        Workbook w;

        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);

            // Look for importaint Columns
// die Spalteninhalte müssen noch in die .ini
            for (int j = 0; j < sheet.getColumns(); j++) {
                Cell cell = sheet.getCell(j, 0);

                if (cell.getContents().equals("ZugNr")) {
                    zugNrSpalte = j;
                }
                if (cell.getContents().equals("Typ")) {
                    typSpalte = j;
                }
                if (cell.getContents().equals("Ankunft")) {     // Eingangspezifisch
                    ankunftSpalte = j;
                }
                if (cell.getContents().equals("Abfahrt")) {     // Ausgangspezifisch
                    abfahrtSpalte = j;
                }
                if (cell.getContents().equals("Bemerkung")) {
                    bemerkungSpalte = j;
                }
                if (cell.getContents().equals("Wagen b/l")) {
                    wagenanzSpalte = j;
                }
                if (cell.getContents().equals("Abg.bf.")) {     // Eingangspezifisch
                    abhfSpalte = j;
                }
                if (cell.getContents().equals("Best.bf.")) {    // Ausgangspezifisch
                    bestSpalte = j;
                }
            }

            // read data
            for (int i = 1; i < sheet.getRows(); i++) {
                Zug zug = new Zug();

                Cell zugNrCell = sheet.getCell(zugNrSpalte, i);
                zug.zugNr = zugNrCell.getContents();

                if ("".equals(zug.zugNr)) {
                    break;
                }

                Cell typCell = sheet.getCell(typSpalte, i);
                zug.typ = typCell.getContents();

                if ("e".equals(zug.typ)) { // Eingangspezifisch

                    Cell ankunftCell = sheet.getCell(ankunftSpalte, i);
                    zug.datum = ankunftCell.getContents();

                    Cell abhfCell = sheet.getCell(abhfSpalte, i);
                    zug.bahnhof = abhfCell.getContents();

                } else { // Ausgangspezifisch
                    Cell abfahrtCell = sheet.getCell(abfahrtSpalte, i);
                    zug.datum = abfahrtCell.getContents();

                    Cell abhfCell = sheet.getCell(bestSpalte, i);
                    zug.bahnhof = abhfCell.getContents();
                }

                Cell bemerkungCell = sheet.getCell(bemerkungSpalte, i);
                zug.bemerkung = bemerkungCell.getContents();

                Cell wagenanzCell = sheet.getCell(wagenanzSpalte, i);
                zug.wagen = wagenanzCell.getContents();

                zug.wagensumme();
                zug.splitBemerkung();  // nur Eingangszüge

                if (!liste.contains(zug)) {
                    liste.add(zug);
                } else { // Prüfen
                    Zug zInListe = liste.get(liste.indexOf(zug));
                    zInListe.wagenanz = zInListe.wagenanz + zug.wagenanz;
                }

            }
        } catch (BiffException e) {
            e.printStackTrace(); // Fehlermeldung der Schleife
        }
        return liste;
    }

    public Map<String, String> readerBahnhof(String xlsDatei) throws IOException {
         
        Map<String, String> map = new HashMap<String, String>();

        File inputWorkbook = new File(xlsDatei);
        Workbook w;

        String spedition;
        String bahnhof;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(1);

            // read data
            for (int i = 1; i < sheet.getRows(); i++) {
                Cell speditionCell = sheet.getCell(0, i);
                spedition = speditionCell.getContents();

                Cell bahnhofCell = sheet.getCell(1, i);
                bahnhof = bahnhofCell.getContents();

                map.put(bahnhof, spedition); // (key/value)   
            }
        } catch (BiffException e) {
            e.printStackTrace(); // Fehlermeldung der Schleife
        }
        return map;
    }
}
