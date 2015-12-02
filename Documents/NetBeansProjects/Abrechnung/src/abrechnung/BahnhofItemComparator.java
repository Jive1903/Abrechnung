/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrechnung;

import java.util.Comparator;

/**
 *
 * @author MasnikJ
 */
public class BahnhofItemComparator implements Comparator<BahnhofItem>{

    @Override
    public int compare(BahnhofItem o1, BahnhofItem o2) {
        return o1.value.compareTo(o2.value);
    }
    
}
