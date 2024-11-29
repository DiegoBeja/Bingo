import java.util.List;

public class Patrones{
    static final int[][] patron1 = {
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}
    };

    static final int[][] patron2 = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0}
    };

    static final int[][] patron3 = {
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
    };

    static final int[][] patron4 = {
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0}
    };

    static final int[][] patron5 = {
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1}
    };

    static final int[][] patron6 = {
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1}
    };

    static final int[][] patron7 = {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron8 = {
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron9 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron10 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron11 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1}
    };

    static final int[][] patron12 = {
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0}
    };

    static final int[][] patron13 = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron14 = {
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron15 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0}
    };
    static final int[][] patron16 = {
            {0, 1, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron17 = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron18 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 1, 1, 0, 0}
    };

    static final int[][] patron19 = {
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };
    static final int[][] patron20 = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron21 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0}
    };

    static final int[][] patron22 = {
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };
    static final int[][] patron23 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0}
    };
    static final int[][] patron24 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
    };

    static final int[][] patron25 = {
            {1, 1, 1, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };
    static final int[][] patron26 = {
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron27 = {
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron28 = {
            {0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron29 = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron30 = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    static final int[][] patron31 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0}
    };
    static final int[][] patron32 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };
    static final int[][] patron33 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0}
    };
    static final int[][] patron34 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 0, 0}
    };
    static final int[][] patron35 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0}
    };
    static final int[][] patron36 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1}
    };

    static final int[][] patron37 = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0}
    };

    static final int[][] patron38 = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

    public static final List<int[][]> PATRONES =List.of(
            patron1, patron2, patron3, patron4, patron5, patron6, patron7, patron8, patron9, patron10, patron11, patron12, patron13, patron14, patron15, patron16, patron17, patron18, patron19, patron20, patron21, patron22, patron23, patron24, patron25, patron26, patron27, patron28, patron29, patron30, patron31, patron32, patron33, patron34, patron35, patron36, patron37, patron38
    );

    public static int[][] getPatron(int index) {
        if (index >= 0 && index < PATRONES.size()) {
            return PATRONES.get(index);
        } else {
            throw new IllegalArgumentException("Índice de patrón no válido: " + index);
        }
    }

    public static int getCantidadPatrones() {
        return PATRONES.size();
    }

    public void imprimirPatron(){
        for(int k = 0; k < VentanaPatron.patronVictoria.length; k++){
            for(int m = 0; m < VentanaPatron.patronVictoria[k].length; m++) {
                System.out.print(VentanaPatron.patronVictoria[k][m] + " ");
            }
            System.out.println();
        }
    }

}