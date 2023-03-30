/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_4;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author marce
 */
class CombSort{
    public static int getNextGap(int gap)
    {
        
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }
 
   
    public static <T extends Comparable> long sort (List<T> lista){
 
        long inicio = System.currentTimeMillis();
        
        int n = lista.size();
 
     
        int gap = n;
 
        boolean swapped = true;// troca
 
       
        while (gap != 1 || swapped == true)
        {
            
            gap = getNextGap(gap);
 
        
            swapped = false;

            for (int i=0; i<n-gap; i++){
                if(lista.get(i).compareTo(lista.get(i+gap))>0){
                    Collections.swap(lista, i, i+gap);
                    swapped = true;
                }
            }
        }
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }
}
 
