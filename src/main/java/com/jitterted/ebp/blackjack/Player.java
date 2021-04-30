package com.jitterted.ebp.blackjack;

public class Player {
    private Hand hand = new Hand();
    private int balance = 0;
    private int bet = 0;
    private int totalBets = 0;

    public void bets(int betAmount) {
        bet = betAmount;
        balance -= betAmount;
        totalBets += betAmount;
        if(bet >= 100){
            balance += 10;
        }
    }

    public void deposits(int amount) {
        balance += amount;
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public void handleBetOutcome(int modifier){
        balance += bet * modifier;
    }

    public Hand getHand() {
        return hand;
    }

    public int getBalance() {
        return balance;
    }

    public int totalAmountBet(){
        return totalBets;
    }

}
