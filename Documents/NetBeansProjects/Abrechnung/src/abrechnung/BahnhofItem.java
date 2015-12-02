/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrechnung;


public class BahnhofItem {
    public String value;
    
    public BahnhofItem(String value){
        this.value=value;
    }
    
    @Override
    public String toString(){
        return value;
    }
    
    public boolean equals(Object object){
        if(object instanceof BahnhofItem){
            return ((BahnhofItem)object).value.equals(this.value); 
            }
        return false;
    }
}
