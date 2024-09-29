import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}
class Deck {
    private List<Card> cartas;

    public Deck() {
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colores = {"Negro", "Rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        cartas = new ArrayList<>();

        // Crear las 52 cartas del deck
        for (String palo : palos) {
            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? colores[1] : colores[0];
            for (String valor : valores) {
                cartas.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cartas.isEmpty()) {
            Card primeraCarta = cartas.remove(0);
            System.out.println(primeraCarta);
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void pick() {
        if (!cartas.isEmpty()) {
            Random rand = new Random();
            Card cartaAleatoria = cartas.remove(rand.nextInt(cartas.size()));
            System.out.println(cartaAleatoria);
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }
    public void hand() {
        if (cartas.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card carta = cartas.remove(0);
                System.out.println(carta);
            }
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas en el deck.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}
