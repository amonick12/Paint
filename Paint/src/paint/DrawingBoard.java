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
    int index = 0;
    MyPoint[] points = new MyPoint[10000];
   
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
        //get point that was dragged
        Point pt = e.getPoint();
        Color finalColor = Color.WHITE;
        //check for eraser and set the color
        if (menu.eraser == true) {
            finalColor = Color.WHITE;
        } else {
            finalColor = menu.color;
        }
        
        //create the intial point
        MyPoint point = new MyPoint(pt.x, pt.y, finalColor, menu.size , menu.shape);
        points[index] = point;
        index++;
        
        //draw the shape from properties and coordinated
        drawShape(pt.x, pt.y, finalColor, menu.shape, menu.size);
        
    }
    
    private void drawShape(int x, int y, Color color, String shape, int size) {
        //draw shape around new point
        Graphics gr = getGraphics();
        gr.setColor(color);
        switch (shape) {
            case "line":
                gr.fillRect(x, y, size, size);
                break;
            case "square":
                gr.fillRect(x, y, size*10, size*10);
                break;
            case "circle":
                gr.drawOval(x, y, size*10, size*10);
                break;
            case "triangle":
                int[] xPoints = new int[3];
                int[] yPoints = new int[3];
                if (size == 5) {
                    xPoints[0] = x;
                    xPoints[1] = x+3;
                    xPoints[2] = x-3;
                    yPoints[0] = y;
                    xPoints[1] = y+5;
                    yPoints[2] = y-5;
                    gr.drawPolygon(xPoints, yPoints, 3);
                } else if (size == 15){
                    xPoints[0] = x;
                    xPoints[1] = x+8;
                    xPoints[2] = x-8;
                    yPoints[0] = y;
                    xPoints[1] = y+15;
                    yPoints[2] = y-15;
                    gr.drawPolygon(xPoints, yPoints, 3);
                }
                else if(size == 30){
                    xPoints[0] = x;
                    xPoints[1] = x+16;
                    xPoints[2] = x-16;
                    yPoints[0] = y;
                    xPoints[1] = y+30;
                    yPoints[2] = y-30; 
                    gr.drawPolygon(xPoints, yPoints, 3);
                }  break;
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    @Override
    public void paintComponent(Graphics g) {
     super.paintComponent(g);
        for (int k=0; k < index; k++) {
            drawShape(points[k].x, points[k].y, points[k].color, points[k].shape, points[k].size);
        }
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == menu.clearButton){
            for (int k=0; k<index; k++) {
                drawShape(points[k].x, points[k].y, Color.WHITE, "square", 30);
            }
        }
        
    }


}
