
package lifegame;

import java.util.ArrayList;


public class Cell {
    ArrayList<Cell> near;//список с 9 указателями на соседние элементы
    Status status;//что она из себя представляет 
    
    public Cell(){//конструктор принимать ничего не должен
       status = Status.NONE; 
       near = new ArrayList<>();//пустой список
    }//Далее создаём 2 шага подготовки
    void addNear(Cell cell){//метод addNear для проверки соседней клетки
        near.add(cell);
    }
    void step1(){
        int around = countNearCells();//метод для выяснения сколько ячеек вокруг
        status= status.step1(around);//передаём ему сколько вокруг живых существ
    
    }
    void step2(){
    status= status.step2();
}
int countNearCells(){//метод для определения кол-во живых существ
 int count=0;
 for (Cell cell : near)//перебор всех ячеек вокруг
     if(cell.status.isCell())
         count ++;
 return count;
}
 void turn(){
     int x=0;
    for (Cell cell : near) {
       
        cell.status=cell.status.isCell()? Status.NONE : Status.LIVE;
     
    }
}
}    

