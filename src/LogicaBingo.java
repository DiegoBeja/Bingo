import javax.swing.*;
import java.awt.*;

public class LogicaBingo {
    boolean win;

    public LogicaBingo(){

    }

    public boolean compararBolaTablero(JLabel hola, int bola){
        if(hola.getText().equals(String.valueOf(bola)) ){
            return true;
        }

        return false;
    }

//    public boolean verificarVictoria(int index){
//        int[][] patronGanador = Patrones.getPatron(index);
//        for(int i=0; i<5; i++){
//            for(int j=0; j<5; j++) {
//                if(patronGanador[i][j] )
//            }
//        }
//
//        return false;
//    }
}
