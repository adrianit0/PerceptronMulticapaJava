package redNeuronal;

/**
 *
 * Es cada una de las capas de la red neuronal
 * 
 * Cada perceptrón está compuesto por 3 tipos de capas:
 *  - Inputs:       Es siempre la primera capa, y su valor es dado por el usuario
 *  - Outputs:      Es siempre la última capa, y su valor es el resultante de los inputs y las funciones realizadas dentro de la caja negra
 *  - Caja negra:   Una cantidad ilimitada de capas que está entre las de entradas y salidas.
 * 
 * @author Adrián
 */
public class Capa {

    private int capaID;
    private Neurona[] neuronas;
    
    /***
     * Crea una nueva capa limpia, es decir, sin ninguna conexión.
     * 
     * No se recomienda usarse si no sabe unir los enlaces correctamente.
     */
    public Capa (int id, int l) {
        neuronas = new Neurona[l];
        capaID = id;

        for (int j = 0; j < l; j++) {
            neuronas[j] = new Neurona(capaID, j);
        }
    }

    /**
     * Capa de la neurona
     * 
     * @param tam numero de neuronas que tendrá esta neurona
     * @param capaAnterior capa anterior a este
     *
     */
    public Capa(int id, int tam, Capa capaAnterior) {
        neuronas = new Neurona[tam];
        capaID = id;

        for (int j = 0; j < tam; j++) {
            neuronas[j] = new Neurona(capaID, j, capaAnterior.neuronas);
        }
    }

    public int getLength() {
        return neuronas.length;
    }

    public Neurona getNeurona(int index) {
        return neuronas[index];
    }
     
    protected Neurona[] getNeuronas() {
        return neuronas;
    }
    
    
    @Override
    public String toString() {
        return "[C"+capaID+"]";
    }
}
