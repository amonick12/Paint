/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paint;

import java.awt.Color;

/**
 *
 * @author aaronmonick
 */
class MyPoint {
 
    public int x;
    public int y;
    public Color color;
    public int size;
    public String shape;
    
    public MyPoint(int x, int y, Color color, int size, String shape) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.shape = shape;
              
        
    }
}
