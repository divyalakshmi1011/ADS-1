class Card implements Comparable<Card> {
    
    private int rank;
    private int suit;
     
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
     
    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }
 
    /**
     * @return the suit
     */
    public int getSuit() {
        return suit;
    }
 
    public String toString() {
        return rank + " of " + suit;
    }
    public int compareTo(Card that) {
        if(this.rank < that.rank) {
            return -1;
        } else if(this.rank > that.rank) {
            return 1;
        }
        return 0;
    }
}