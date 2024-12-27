package com.ib.elementfreq;
public class ElementFrequency3 {  
    public static void main(String[] args) {  

    	int [] array = new int [] {1, 1, 8, 5, 6, 8, 8, 5, 1, 6};  

        int [] freqarr = new int [array.length];  
        int visited = -1;

        for(int i = 0; i < array.length; i++){
            int count = 1;  
            for(int j = i+1; j < array.length; j++){
                if(array[i] == array[j]){  
                    count++;
                    freqarr[j] = visited;  
                }
            }
            if(freqarr[i] != visited)  
                freqarr[i] = count;  
        }
  
        System.out.println(" Element | Frequency");  

        for(int i = 0; i < freqarr.length; i++){  
            if(freqarr[i] != visited)  
                System.out.println("    " + array[i] + "    |    " + freqarr[i]);  
        }
    }}