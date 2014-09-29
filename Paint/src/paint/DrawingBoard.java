/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paint;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author aaronmonick
 */
public class DrawingBoard extends JPanel implements MouseMotionListener, ActionListener {
    myMenu menu;
    int x,y;
    int index = 0;
    MyPoint[] recordPoints = new MyPoint[10000000];
    Graphics gr;
    String shape;
    Color color;
   
   
    public DrawingBoard(){
        super();
        BorderLayout border = new BorderLayout();
        setLayout(border);
        menu = new myMenu();
        add(menu, "South");
        setBackground(Color.white);
        setVisible(true);
        addMouseMotionListener(this);
        menu = new myMenu();
        menu.clearButton.addActionListener(this);
    } 

    @Override
    public void mouseDragged(MouseEvent e) {
        MyPoint pt = new MyPoint(e.getPoint());
        int x = pt.x;
        int y = pt.y;
        pt = recordPoints[index];
        pt.col = menu.getColor();
        pt.size = menu.getShapeSize();
        gr = this.getGraphics();
        gr.setColor(pt.col);
        gr.fillRect(x, y, pt.size, pt.size);  
        index++;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    //@Override
    public void paintComponent(Graphics g) {
     super.paintComponent(g);
     if(menu.checkEraser() == false){
        for(int i=0; i<recordPoints.length; i++){
             if(menu.getShape().equals("line")){
                 g.setColor(menu.getColor());
                 g.fillRect(recordPoints[i].x, recordPoints[i].y, menu.getShapeSize(), menu.getShapeSize());
             }
             else if(menu.getShape().equals("square")){
                 g.setColor(menu.getColor());
                 g.drawRect(recordPoints[i].x, recordPoints[i].y, menu.getShapeSize(), menu.getShapeSize());
             }
             else if(menu.getShape().equals("circle")){
                 g.setColor(menu.getColor());
                 g.drawOval(recordPoints[i].x, recordPoints[i].y, menu.getShapeSize(), menu.getShapeSize());
             }
             else if(menu.getShape().equals("triangle")){
                 g.setColor(menu.getColor());
                 int[] xPoints = new int[3];
                 int[] yPoints = new int[3];
                 if(menu.getShapeSize() == 5){
                     xPoints[0] = recordPoints[i].x; xPoints[1] = recordPoints[i].x+3; xPoints[2] = recordPoints[i].x-3;
                     yPoints[0] = recordPoints[i].y; xPoints[1] = recordPoints[i].y-5; yPoints[2] = recordPoints[i].y-5;
                     g.drawPolygon(xPoints, yPoints, 3);
                 }
                 else if(menu.getShapeSize() == 15){
                     xPoints[0] = recordPoints[i].x; xPoints[1] = recordPoints[i].x+8; xPoints[2] = recordPoints[i].x-8;
                     yPoints[0] = recordPoints[i].y; xPoints[1] = recordPoints[i].y-15; yPoints[2] = recordPoints[i].y-15;
                     g.drawPolygon(xPoints, yPoints, 3);
                 }
                 else if(menu.getShapeSize() == 30){
                     xPoints[0] = recordPoints[i].x; xPoints[1] = recordPoints[i].x+16; xPoints[2] = recordPoints[i].x-16;
                     yPoints[0] = recordPoints[i].y; xPoints[1] = recordPoints[i].y-30; yPoints[2] = recordPoints[i].y-30;
                     g.drawPolygon(xPoints, yPoints, 3);
                 }
             }   
        }
     }
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == menu.clearButton){
            recordPoints = new MyPoint[10000000];
        }
        
    }
    
}
