/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.code;

import abrechnung.BahnhofItem;
import abrechnung.MyList;
import abrechnung.Zug;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MasnikJ
 */
public class KontrollTableModel extends AbstractTableModel{

    public MyList<Zug> list;
    
    
    public KontrollTableModel(MyList<Zug> list){
        this.list = list;
        }
        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 8;
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
            case 2: return list.get(rowIndex).spedition;
            case 3: return list.get(rowIndex).datum;   
            case 4: return list.get(rowIndex).wustKts;
            case 5: return list.get(rowIndex).zugabpreis;
            case 6: return list.get(rowIndex).lotspreis;
            case 7: return list.get(rowIndex).rangierarbeitpreis;   
            case 8: return list.get(rowIndex).rhWust;
                             
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
            case 2: return "Wochentag";
            case 3: return "Ankunftszeit";
            case 4: return "Umlauf Wüst/KTS";   
            case 5: return "Zugabfertigung";
            case 6: return "Lotse";
            case 7: return "Rangier";
            case 8: return "Umlauf RH/Wüst";
            default: return "";   
        }
    }
   
//   // Auswahlfeld der 5 Spalte
//   public Class getColumnClass(int c) {
//       if(c == 5){
//           return BahnhofItem.class;
//       }
//        return String.class;
//      }
//
//      // Einlesen der neuen Spalteninhalte
//       public void setValueAt(Object value, int r, int c) {
//        if(value==null){
//            return;
//        }
//        if(c==5){
//            list.get(r).spedition = ((BahnhofItem) value).toString();
//        }else{
//            list.get(r).bemerkung = (String) value;
//        }
//      }
} 
