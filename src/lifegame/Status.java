
package lifegame;


public enum Status {//Класс для ввода правил игры
 NONE,//Пустая клетка, всё пошагово: 1
 BORN,//Родилась 2
 LIVE,//Жива 1
 DIED;//Умирает2
 public Status step1 (int around){
     switch(this)
     {
         case NONE : return (around ==3) ? BORN : NONE;
         case LIVE : return (around <= 1 || around >=4) ? DIED : LIVE;
         default : return this;
     }
    
 }
 public Status step2(){ 
   switch(this)
           {
       case BORN : return LIVE;
       case DIED : return NONE;
       default : return this;
   }  
 }
 public boolean isCell(){//метод для проверки жива клетка или нет
     return this == LIVE || this == DIED;
 }
}