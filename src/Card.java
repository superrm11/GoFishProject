import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * Card
 * 
 * A generic 'Card' class that allows creation and comparison of single cards.
 * 
 * Date: 10/21/2020
 * @author Ryan McGee
 */
public class Card {
    
    // Unmodifiable list of Suits
    // Use Card.SUITS.get(index) to get the String value of a Suit index
    // Use Card.SUITS.indexOf(String) to get the index of a Suit string
    public static final List<String> SUITS = Collections.unmodifiableList(Arrays.asList(
        "Hearts", "Diamonds", "Clubs", "Spades"
        ));

    // Unmodifiable list of Faces
    // Use Card.FACES.get(index) to get the String value of a Face index
    // Use Card.FACES.indexOf(String) to get the index of a Face string
    public static final List<String> FACES = Collections.unmodifiableList(Arrays.asList(
        "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"
        ));

    private final int suit;
    private final int face;

    /**
     * Create a Card object from integer indexes.
     * Allows creation of a deck with For loops.
     * 
     * @param suit The suit index: 0 -> 3
     * @param face The Face index: 0 -> 12
     */
    public Card(int face, int suit)
    {
        this.suit = suit;
        this.face = face;
    }

    /**
     * Create a Card object from Strings representing the card.
     * Only works with the strings defined in SUITS or FACES
     * 
     * @param face The face string from Card.FACES
     * @param suit The suit string from Card.SUITS
     */
    public Card(String face, String suit)
    {
        this.suit = SUITS.indexOf(suit);
        this.face = FACES.indexOf(face);

        // print an error if the suit/face given does not exist
        if(this.suit == -1)
            (new Exception("Suit " + suit + " not found in Card.SUITS")).printStackTrace();
        if(this.face == -1)
            (new Exception("Face " + face + " not found in Card.FACES")).printStackTrace();
    }


    /**
     * @return The string value of this card's face
     */
    public String getFace()
    {
        return FACES.get(this.face);
    }

    /**
     * @return The string value of this card's suit
     */
    public String getSuit()
    {
        return SUITS.get(this.suit);
    }

    /**
     * @return The name of this card, in the format 'FACE of SUIT'
     */
    public String getName()
    {
        return getFace() + " of " + getSuit();
    }

    /**
     * Compare against the face of this card, ignoring case
     * @param face The face to compare against
     * @return True if the faces are equal
     */
    public boolean isFace(String face)
    {  
        return face.toLowerCase().contains(FACES.get(this.face).toLowerCase());
    }

    /**
     * Compare against the suit of this card, ignoring case
     * @param suit The suit to compare against
     * @return True if the suits are equal
     */
    public boolean isSuit(String suit)
    {
        return suit.toLowerCase().contains(SUITS.get(this.suit).toLowerCase());
    }

    /**
     * @return Whether or not a card is equal to another
     */
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Card == false)
            return false;

        Card in = (Card) o;
        return in.isFace(this.getFace()) && in.isSuit(this.getSuit());
    }

    /**
     * Enables using this object as if it were a string.
     * e.g. System.out.println(card); to output "Face of Suit"
     */
    @Override
    public String toString()
    {
        return this.getName();
    }

}
