/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.code;

import abrechnung.MyList;
import abrechnung.Spedition;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MasnikJ
 */
public class LeistungTableModelE extends AbstractTableModel{

    public MyList<Spedition> list;
    boolean e;
    
    public LeistungTableModelE(MyList<Spedition> list){
        this.list = list;
        this.e = e;
    }
        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }
    
//    @Override // Spalten die der User bearbeiten darf
//     public boolean isCellEditable(int r, int c) {
//        return (c == 1);
//      }

    @Override // Spalteninhalt
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        String Sachkonto = "4.796.700";
        
        switch (columnIndex) {                
            case 0: return Sachkonto;
            case 1: return list.get(rowIndex).spedition;  
            case 2: return list.get(rowIndex).eGesamtpreis;
            case 3: return list.get(rowIndex).infrapreis;  
            case 4: return list.get(rowIndex).eGesamtpreis+list.get(rowIndex).infrapreis;    
                            
            default: return "";
        }                
    }    
       
    @Override // Spaltenüberschriften
   public String getColumnName(int column)
    {
        switch (column) {        
            // Spaltennamen
            case 0: return "Sachkonto";
            case 1: return "Spedition";     
            case 2: return "DM570004(Belastung)";   
            case 3: return "DM632415(Gutschrift)";
            case 4: return "DM658900(Gutschrift)";
            default: return "";   
        }
    }
   
//   // Auswahlfeld der 5 Spalte
//   public Class getColumnClass(int c) {
//       if(c == 1){
//           return Boolean.class;
//       }
//        return String.class;
//      }
//
//       //Einlesen der neuen Spalteninhalte
//       public void setValueAt(Object value, int r, int c) {
//        if(c==1){
//            if(e){
//            list.get(r).eAbrechnen = (boolean)value;
//            }else{
//            list.get(r).aAbrechnen = (boolean)value;    
//            }
//        }
//        }
}
