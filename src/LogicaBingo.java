import javax.swing.*;
import java.awt.*;

public class LogicaBingo extends Patrones{
    public LogicaBingo(){
        super();
    }

    public boolean compararBolaTablero(JLabel hola, int bola){
        if(hola.getText().equals(String.valueOf(bola)) ){
            return true;
        }

        return false;
    }

    public boolean verificarVictoria(){
        int unos = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++) {
                if(VentanaPatron.patronVictoria[i][j] == 1){
                    unos++;
                }
            }
        }

        if(unos == 0){
            return true;
        }

        return false;
    }
}
