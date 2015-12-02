/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.code;

import abrechnung.BahnhofItem;
import abrechnung.MyList;
import abrechnung.Spedition;
import abrechnung.Zug;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MasnikJ
 */
public class SpeditionTableModel extends AbstractTableModel{

    public MyList<Spedition> list;
    boolean e;
    
    public SpeditionTableModel(MyList<Spedition> list, boolean e){
        this.list = list;
        this.e = e;
        }
        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }
    
    @Override // Spalten die der User bearbeiten darf
     public boolean isCellEditable(int r, int c) {
        return (c == 1);
      }

    @Override // Spalteninhalt
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {                
            case 0: return rowIndex+1;
            case 1: return (e?list.get(rowIndex).eAbrechnen:list.get(rowIndex).aAbrechnen);
            case 2: return list.get(rowIndex).firmenname;
                            
            default: return "";
        }                
    }    
       
    @Override // Spaltenüberschriften
   public String getColumnName(int column)
    {
        switch (column) {        
            // Spaltennamen
            case 0: return "Nr.";
            case 1: return "Auswahl";     
            case 2: return "Spedition";            
            default: return "";   
        }
    }
   
   // Auswahlfeld der 5 Spalte
   public Class getColumnClass(int c) {
       if(c == 1){
           return Boolean.class;
       }
        return String.class;
      }

       //Einlesen der neuen Spalteninhalte
       public void setValueAt(Object value, int r, int c) {
        if(c==1){
            if(e){
            list.get(r).eAbrechnen = (boolean)value;
            }else{
            list.get(r).aAbrechnen = (boolean)value;    
            }
        }
        }
      
}
  

