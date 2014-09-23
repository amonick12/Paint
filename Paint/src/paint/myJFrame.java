/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paint;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author aaronmonick
 */
public class myJFrame extends JFrame {
    
    DrawingBoard drawingBoard;
    
    public myJFrame () {
        //name JFrame
        super ("Paint");
        //set up drawing board
        drawingBoard = new DrawingBoard();
   	
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(drawingBoard,"Center");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (640, 480);
        setVisible(true);
    }
}
