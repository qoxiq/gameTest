
package lifegame;

import java.awt.Color;


public class Config {
    public static int SIZE = 15;//размер одной ячейки в пиксилях
    public static int WIDTH = 50;//ширина поля не в пиксилях
    public static int HEIGH = 50;//высота поля
    public static int SLEEPMS = 500;//Таймер
    
    
    public static Color getColor (Status status){
        switch(status){
            default :
            case NONE: return Color.BLACK;
                   
            case BORN: return Color.GRAY;
                  
            case LIVE: return Color.WHITE;
                   
            case DIED: return Color.BLUE;
                  
            
        }
    }


}
