/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.code;

import abrechnung.Zug;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MasnikJ
 */
public class ZugTableModelA extends AbstractTableModel{

    public ArrayList<Zug> list;
    
    
    public ZugTableModelA(ArrayList<Zug> list){
        this.list = list;
        }
        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }
    
    @Override // Spalten die der User bearbeiten darf
     public boolean isCellEditable(int r, int c) {
        return (c == 3)||(c == 5);
      }

    @Override // Spalteninhalt
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {                
            case 0: return rowIndex+1;
            case 1: return list.get(rowIndex).zugNr;
     //       case 2: return list.get(rowIndex).wochentag;
            case 2: return list.get(rowIndex).datum;
     //       case 3: return list.get(rowIndex).bahnhof; ich glaube der kann weg
            case 4: return list.get(rowIndex).spedition;
            case 5: return list.get(rowIndex).rhWust;
            case 6: return list.get(rowIndex).bremspreis;
                         
            default: return "";
        }                
    }    
       
    @Override // Spaltenüberschriften
   public String getColumnName(int column)
    {
        switch (column) {        
            // Spaltennamen
            case 0: return "Nr.";
            case 1: return "ZugNr";
         //   case 2: return "Wochentag";
            case 2: return "Abfahrtszeit";
            case 3: return "Spedition";   
            case 4: return "Umlaus RH-Wüst";
            case 5: return "Bremspreis";
            default: return "";   
        }
    }
   
   // Auswahlfeld der 5 Spalte
   public Class getColumnClass(int c) {
       if(c == 5){
           return BahnhofItem.class;
       }
        return String.class;
      }

      // Einlesen der neuen Spalteninhalte
       public void setValueAt(Object value, int r, int c) {
        if(c==5){
            list.get(r).spedition = ((BahnhofItem) value).toString();
        }else{
            list.get(r).bemerkung = (String) value;
        }
      }
}

 
}
