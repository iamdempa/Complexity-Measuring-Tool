/*
 * Analyzer Implementation
 */
package com.codeingrams.analyzer;
import java.io.*;
import java.util.regex.*;

public class AnalyzerImpl implements IAnalyzer{

	    private int count(String line, Pattern pattern) {
	        int count = 0;
	        Matcher matcher = pattern.matcher(line);
	        while (matcher.find()) {
	            ++count;
	        }
	        return count;
	    }

	    public void run(String path) throws IOException {

	        Pattern vowels      = Pattern.compile("[aeiouAEIOU]");
	        Pattern consonants  = Pattern.compile("[bcdfghjklmnpqrstuvwxyzBCDFGHJKLMNOPQRSTUVWXYZ]");
	        Pattern punctuation = Pattern.compile("\\p{Punct}");
	        Pattern whitespace  = Pattern.compile("\\p{Space}");
	        Pattern digits      = Pattern.compile("\\p{Digit}");
	        Pattern uppercase   = Pattern.compile("\\p{Upper}");
	        Pattern lowercase   = Pattern.compile("\\p{Lower}");
	        Pattern words       = Pattern.compile("\\w+");
	        Pattern characters  = Pattern.compile(".");

	        int vowelCount       = 0;
	        int consonantCount   = 0;
	        int punctuationCount = 0;
	        int whitespaceCount  = 0;
	        int digitCount       = 0;
	        int uppercaseCount   = 0;
	        int lowercaseCount   = 0;
	        int wordCount        = 0;
	        int charCount        = 0;
	        int lineCount        = 0;

	        if (path==null) {
	            System.out.println("Error: No filename provided");
	            System.exit(-1);
	        }

	        try {
	            BufferedReader br = new BufferedReader(new FileReader(path));
	            for (String line; (line = br.readLine()) != null; ) {
	                ++lineCount;
	                vowelCount       += count(line, vowels);
	                consonantCount   += count(line, consonants);
	                punctuationCount += count(line, punctuation);
	                whitespaceCount  += count(line, whitespace);
	                digitCount       += count(line, digits);
	                uppercaseCount   += count(line, uppercase);
	                lowercaseCount   += count(line, lowercase);
	                wordCount        += count(line, words);
	                charCount        += count(line, characters);
	              
	            }
	        } catch (Exception e) {
	            System.out.println("Couldn't parse " + path + "\n" + e.getMessage());
	            System.exit(-1);
	        }
	        System.out.println("Text Analysis of file: " + path);
	        System.out.println(" #Lines:      "  + lineCount);
	        System.out.println(" characters:  "  + charCount);
	        System.out.println(" words:       "  + wordCount);
	        System.out.println(" uppercase:   "  + uppercaseCount);
	        System.out.println(" lowercase:   "  + lowercaseCount);
	        System.out.println(" consonants:  "  + consonantCount);
	        System.out.println(" vowels:      "  + vowelCount);
	        System.out.println(" digits:      "  + digitCount);
	        System.out.println(" punctuation: "  + punctuationCount);
	        System.out.println(" whitespace:  "  + whitespaceCount);
	    }
	
}
