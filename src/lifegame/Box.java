
package lifegame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;



public class Box  extends JPanel{
    
    Cell cell;//создаём ячейку
    
  
    public Box (int x, int y){//координаты знака мест а не пикселей и передали сюда ячейку
    super();//перед тем как указывать элементы нашего класса надо вызвать родительский конструктор
    cell= new Cell();//создание новой ячейки
    setBounds(x*Config.SIZE, y*Config.SIZE, Config.SIZE, Config.SIZE);//размеры
    setBackground(Config.getColor(Status.NONE));//установка цвета заднего фона
    addMouseListener(new MouseAdapter() {
        
                @Override
                public void mousePressed(MouseEvent e){
                cell.turn();    
                }
        
}) ;
        
    
    }

    public void initCells(int x, int y) 
    {
        
    }
    public void setColor ()
    {
        setBackground(Config.getColor(cell.status));
    }
    void step1(){
        cell.step1();
        setColor();
        
    }
     void step2(){
        cell.step2();
        setColor();
    }
}
