
package lifegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Window implements Runnable {//у Runnable есть метод run который запускается при начале работы
    JFrame frame;// поле на котором мы будем рисовать 
    Box[][] boxes;
    
    @Override
    public void run(){
        initFrame();
        initBoxes();
        initTimer();
        
    }
    void initFrame(){
        frame = new JFrame();//создаём окошко
        frame.getContentPane().setLayout(null);// теперь окошко занимает всё место находится по середине
        frame.setSize(Config.SIZE*Config.WIDTH+25, Config.SIZE*Config.HEIGH+45);//константы для размера окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//сделано для того чтобы при нажатие на крестик закрывался не только интерфейс но и вся программа
        frame.setLocationRelativeTo(null);//размещает окно по цунтру
        frame.setVisible(true);
        frame.setTitle("Life Game");//название игры
    }
    void initBoxes(){
        boxes = new Box [Config.WIDTH] [Config.HEIGH];//создание массива боксов 
    
        for (int x = 0; x < Config.WIDTH; x++) //создаём боксы
            for (int y = 0; y < Config.HEIGH; y++) 
            {   
                boxes[x][y]= new Box(x,y);
                frame.add(boxes[x][y]);
                
            }
             for (int x = 0; x < Config.WIDTH; x++)//проверка соседей
            for (int y = 0; y < Config.HEIGH; y++) 
                for (int sx = -1; sx <= +1; sx++)
                    for (int sy = -1; sy <= +1; sy++)
                        if (!(sx == 0&& sy==0))
                            boxes[x][y].cell.addNear(boxes
                                    [(x+sx+Config.WIDTH)% Config.WIDTH]
                                      [(y+sy+Config.HEIGH)% Config.HEIGH].cell);
                   for (int x = 10; x < 15; x++) {
                       boxes[x][10].cell.status=Status.LIVE;
                       boxes[x][10].setColor();
            
        }
                   
    }
                   private void initTimer(){
                       TimerListener t1 = new TimerListener();
                       Timer timer = new Timer(Config.SLEEPMS, t1);
                       timer.start();
                       
                   }

    private class TimerListener implements ActionListener        
    {

       boolean flop=false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop =! flop;
          for (int x = 0; x < Config.WIDTH; x++)
              for (int y = 0; y < Config.HEIGH; y++){
                  if(flop)
                  boxes[x][y].step1();
                  else
                  boxes[x][y].step2();
                  
              }
                  
        }
        }
    }
            
                
    
    

