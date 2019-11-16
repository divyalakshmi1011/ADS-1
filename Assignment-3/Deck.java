import java.util.Arrays;
/**
 * This class sorts the deck.
 * 
 * @author Divya
 */
public class Deck {
    /**
     * suits
     */
       private static int[] SUITS = {
            0, 1, 2, 3};
    /**
     * ranks
     */

        private static int[] RANKS = {
            1,2,3,4,5,6,7,8,9,10,11,12,13
        };
        /**
         * This method initialises the deck.
         * @return
         */
        public static Card[] method() {
            int n = SUITS.length * RANKS.length;
            Card[] deck = new Card[n];
            for (int i = 0; i < RANKS.length; i++) {
                for (int j = 0; j < SUITS.length; j++) {
                    deck[SUITS.length*i + j] = new Card(RANKS[i], SUITS[j]);
                }
            }
            return deck;
        }
        /**
         * shuffles.
         * @param deck
         * @return
         */

    public static Card[] shuffle(Card[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            Card temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        return deck;
    }
    /**
     * to string method.
     * @param cards
     * @return
     */
    public static String toString(Card[] cards) {
        String s = "";
        for(int i = 0; i < cards.length; i++) {
            s += cards[i] + " ";
        }
        return s;
        }
        /**
         * Sorting
         * @param cards
         * @return
         */
    
    public static Card[] sortDeck(Card[] cards) {
        for(int i = 0; i < cards.length-1; ++i ) {
            int minIndex = i;
            for(int j = i+1; j < cards.length;++j) {
               if(cards[j].compareTo(cards[minIndex]) < 0) {
                   minIndex = j;
               }
            }
            Card t = cards[i];
            cards[i] = cards[minIndex];
            cards[minIndex] = t;
        }
        return cards;
    }
    /**
     * main method.
     * @param args
     */
    public static void main(String[] args) {
         Card[] array = method();
         Card[] shuffled = shuffle(array);
         Card[] sorted = sortDeck(shuffled);
         System.out.println(toString(sorted));
    }
    }

