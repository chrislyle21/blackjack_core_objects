/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author chris
 */
class Dealer
{

    private List<Deck> decks;
    private Action dealerAction;
    private DealerHand dealerHand;

    Dealer()
    {
        this.dealerHand = new DealerHand();
        this.decks = new ArrayList<>();
    }

    private List<Deck> getDecks()
    {
        for (int n = 0; n < 6; n++)
        {
            this.decks.add(n, new Deck());
        }
        return this.decks;
    }

    Action getDealerAction()
    {
        return this.dealerAction;
    }

    void setAction(Action anAction)
    {
        this.dealerAction = anAction;
    }

    DealerHand getDealerHand()
    {
        return this.dealerHand;
    }

    private List<Card> combineDecks()
    {
        List<Card> listArr = new ArrayList<>();

        for (Deck eachDeck : this.getDecks())
        {
            for (int n = 0; n < eachDeck.getDeck().length; n++)
            {
                listArr.add(eachDeck.getCard(n));
            }

        }

        return listArr;
    }

    List<Card> shuffleDecks()
    {
        List<Card> shuffledList = this.combineDecks();
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

    void addToPlayerHand(Hand aHand, Card aCard)
    {
        aHand.addToHand(aCard);
    }

    @Override
    public String toString()
    {
        return "Number of decks: " + this.getDecks().size()
                + "\nDealer action = " + this.getDealerAction();
    }
}
