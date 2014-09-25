/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author aaronmonick
 */
public class DrawingBoard extends JPanel implements ActionListener {
    
    myMenu menu;
    JButton eraserButton;
    boolean eraser;
    //Shapes shape;
    //Colors color;
    //BrushSize size;
    int index;
    
    
   
    public DrawingBoard(){
        super();
        menu = new myMenu();
        add(menu);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
