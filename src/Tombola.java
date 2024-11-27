import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tombola {
    private ArrayList<Integer> numeroTombola;
    private List<Integer> historialTombola;
    private int bola;

    public Tombola(){
        historialTombola = new ArrayList<>();
        numeroTombola = new ArrayList<>();
        for(int i=0; i<75; i++){
            numeroTombola.add(i+1);
        }
    }

    public int getNumeroTobola(){
        Random rd = new Random();
        if(numeroTombola.size() > 1) {
            bola = numeroTombola.get(rd.nextInt(numeroTombola.size()));
            numeroTombola.remove((Integer) bola);
            historialTombola.add(bola);
        } else{
            System.out.println("Ya no hay boals");
        }

        return bola;
    }
}
