/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author annie
 */
public class myMenu extends JPanel implements ActionListener {
    
    JButton eraserButton;
    public boolean eraser;
    JButton clearButton;
    //int index = 0;
    //combo boxes
    JComboBox shapes;
    JComboBox colors;
    JComboBox sizes;
    //properties
    public Color color;
    public int size;
    public String shape;
    //sizes
    int smallSize = 5;
    int mediumSize = 15;
    int largeSize = 30;
    //combobox arrays
    String[] sizeArray = {"small", "medium", "large"};
    String[] colorArray = {"black", "red", "blue", "green"};
    String[] shapeArray = {"line", "circle", "square", "triangle"};
    
    public myMenu() {
        eraser = false;
        setBackground(Color.PINK);
        setLayout(new FlowLayout());
        setSize (640, 200);

        //set inital properties
        color = Color.BLACK;
        size = smallSize;
        shape = "line";
        
        //add clear button
        clearButton = new JButton("Clear");
        add(clearButton);
        //action listener in drawingboard
        //clearButton.addActionListener(this);
        
        //add eraser button
        eraserButton = new JButton("Eraser");
        add(eraserButton);
        eraserButton.addActionListener(this);
        
        shapes = new JComboBox(shapeArray);
        shapes.setSelectedIndex(0);
        shapes.addActionListener(this);
        add(shapes);
        
        colors = new JComboBox(colorArray);
        colors.setSelectedIndex(0);
        colors.addActionListener(this);
        add(colors);
        
        sizes = new JComboBox(sizeArray);
        sizes.setSelectedIndex(0);
        sizes.addActionListener(this);
        add(sizes);


        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == eraserButton) {
            if (eraser == false) {
                eraser = true;
            } else {
                eraser = false;
            }
            
        } else if (obj == sizes) {
            JComboBox sizeBox = (JComboBox) e.getSource();
            String sizeName = (String) sizeBox.getSelectedItem();            
            if (sizeName == "small") { 
                size = smallSize;   
                System.out.println("Size: "+size);
            } else if (sizeName == "medium") {
                size = mediumSize;        
                System.out.println("Size: "+size);
            } else if (sizeName == "large") { 
                size = largeSize;         
                System.out.println("Size: "+size);
            }
            
        } else if (obj == shapes) {
            JComboBox shapesBox = (JComboBox) e.getSource();
            String shapeName = (String) shapesBox.getSelectedItem(); 
            System.out.println("Shape: "+shapeName);
            
        } else if (obj == colors) {
            JComboBox colorsBox = (JComboBox) e.getSource();
            String colorName = (String) colorsBox.getSelectedItem();
            if (colorName == "black") { 
                color = Color.BLACK; 
                System.out.println("Color: "+color);
            }
            if (colorName == "blue") { 
                color = Color.BLUE; 
                System.out.println("Color: "+color);
            }
            if (colorName == "red") { 
                color = Color.RED;                     
                System.out.println("Color: "+color);
            }
            if (colorName == "green") { 
                color = Color.GREEN;         
                System.out.println("Color: "+color);
            }
        } 
        
    }
    
}
