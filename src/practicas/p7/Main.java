package practicas.p7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    private static String texto = "No era el hombre mas honesto ni el mas piadoso, pero era un hombre valiente.\nSe llamaba Diego Alatriste y Tenorio, y habia luchado como soldado de los tercios viejos en las guerras de Flandes.";
    private static String [] palabras = {"no","java","PIADOSO","el"};
    
    public static void main(String args[]){     
        
        cleanText(texto);
        String [] textArray = texto.split(" ");
        orderWords(palabras);
                
        System.out.println(counterOfWords(textArray, palabras).toString());
    }
    
    public static HashMap<String,Integer> counterOfWords(String [] textArray, String [] palabras){
        HashMap<String,Integer> hmap = new HashMap<String,Integer>();

        for(int i=0; i<textArray.length; i++){
            int index = findWord(textArray[i], palabras);
            if(index >= 0){
                Integer value = (Integer)hmap.get(textArray[i]);
                if(value == null){
                    value = 1;
                }else{
                    value ++;
                }
                hmap.put(palabras[index], value);
            }
        }
        
        for(int i=0; i<palabras.length; i++){
            if(hmap.get(palabras[i]) == null){
                hmap.put(palabras[i], 0);
            }
        }
        
        return hmap;
    }        
    
    private static int findWord(String word, String [] words){
        int index = -1;
        
        int start=0,end=words.length-1;
        while(start<=end && index == -1){
            int middle=(start+end)/2;
            int compare = word.compareToIgnoreCase(words[middle]);
            if(compare == 0){ 
                index = middle;
            }else if(compare <0){
                end=middle-1;
            }else {
                start=middle+1;
            }
        }
        return index;
    }
    
    private static void orderWords(String [] words){
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String o1, String o2) {              
                return o1.compareToIgnoreCase(o2);
            }
        });
    }
       
    private static void cleanText(String text){
        texto = text.replaceAll("\\n", " ").replaceAll("\\,|\\.|\\;","");   
    }
}
