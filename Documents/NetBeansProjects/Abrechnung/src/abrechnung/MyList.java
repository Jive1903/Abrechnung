/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrechnung;

import java.util.ArrayList;
import java.util.HashMap;

public class MyList <T>{
    
    public ArrayList <T> list = new ArrayList();
    public HashMap <String,T> map = new HashMap();
    
    public void add(String key, T value){
        list.add(value);
        map.put(key,value);
    }
    
    public T get(String key){
        return map.get(key);
    }
    
    public T get(int index){
        return list.get(index);
    }
    
    public void add(T value){
        list.add(value);
    } 

    public boolean contains(T value){
        return list.contains(value);
    }
    public int indexOf(T value){
        return list.indexOf(value);
    }
    public int size(){
        return list.size();
    }
}
