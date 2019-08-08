package com.codeingrams.client;
import java.awt.*;
import java.awt.event.*;

public class UI  extends Frame implements KeyListener{

	   private TextArea tfInput;  // Single-line TextField 
	   private TextArea taDisplay; // Multi-line TextArea
	 
	   // Constructor to setup the GUI components and event handlers
	   public UI() {
	      setLayout(new FlowLayout()); 
	 
	      add(new Label("Copy Paste the code: "));
	      tfInput = new TextArea(5, 40);
	      add(tfInput);
	      taDisplay = new TextArea(5, 40); 
	      add(taDisplay);
	      
	      CheckboxGroup cbg = new CheckboxGroup();  
	      Checkbox checkBox1 = new Checkbox("C++", cbg, false);    
	      checkBox1.setBounds(100,100, 50,50);    
	      Checkbox checkBox2 = new Checkbox("Java", cbg, true);    
	      checkBox2.setBounds(100,150, 50,50); 
	      add(checkBox1);    
	      add(checkBox2);  
	      Button b=new Button("Click Here");  
	      b.setBounds(50,100,80,30); 
	      add(b);
	      
	      tfInput.addKeyListener(this);

	      setTitle("Complexity in Grams : Code-In-Grams");
	      setSize(400, 800);         
	      setVisible(true);          
	   }
	 
	   // The entry main() method
	   public void loadUI() {
	      new UI(); 
	   }
	 
	   /** KeyEvent handlers */
	   @Override
	   public void keyTyped(KeyEvent evt) {
	      taDisplay.append("You have typed " + evt.getKeyChar() + "\n");
	   }
	 
	   @Override public void keyPressed(KeyEvent evt) { }
	   @Override public void keyReleased(KeyEvent evt) { }
}
