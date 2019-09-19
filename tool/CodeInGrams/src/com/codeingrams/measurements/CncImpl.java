package com.codeingrams.measurements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//Complexity - Nesting of Code
public class CncImpl {

	// maximum depth nested parenthesis  
    public int maxDepth(String path) { 
    	FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	byte[] buffer = new byte[10];
    	StringBuilder sb = new StringBuilder();
    	try {
			while (fis.read(buffer) != -1) {
				sb.append(new String(buffer));
				buffer = new byte[10];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    	String S = sb.toString();
    	
        int current_max = 0; // current count  
        int max = 0; // overall maximum count  
        int n = S.length(); 
  
        // Traverse the input string  
        for (int i = 0; i < n; i++) { 
            if (S.charAt(i) == '(') { 
                current_max++; 
  
                // update max if required  
                if (current_max > max) { 
                    max = current_max; 
                } 
            } else if (S.charAt(i) == ')') { 
                if (current_max > 0) { 
                    current_max--; 
                } else { 
                    return -1; 
                } 
            } 
        } 
  
        // finally check for unbalanced string  
        if (current_max != 0) { 
            return -1; 
        } 
  
        return max; 
    } 
    
    //calculate total weight
    private double getTW(String path, double cnc , double ci) {
    	//returns total weight
		return getWeightDuetoControlStructure(path)+cnc+ci;
	}
    
    //calculate complexity of a program statement due to nesting level and the type of control structure
    public double getCPSduetoNestingLevelAndTypeOfControllStructure(String path , double cs, double ci) {
		return cs*getTW(path, maxDepth(path) , ci);
    }
    
    //get weights from tokens
    private double getWeightDuetoControlStructure(String path) {
    	CtcImpl ctcimp = new CtcImpl();
    	return ctcimp.checkCtcScore(path);
    }
    
    
}
