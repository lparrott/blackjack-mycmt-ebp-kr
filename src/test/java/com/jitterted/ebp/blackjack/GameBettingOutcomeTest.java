package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingOutcomeTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Game game = createGameWithPlayerBalanceOf(20);
    game.player.bets(10);

    game.playerWins();

    assertThat(game.player.getBalance())
        .isEqualTo(30);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Game game = createGameWithPlayerBalanceOf(80);
    game.player.bets(70);

    game.playerTies();

    assertThat(game.player.getBalance())
        .isEqualTo(80);
  }

  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Game game = createGameWithPlayerBalanceOf(35);

    game.player.bets(30);
    game.playerLoses();

    assertThat(game.player.getBalance())
        .isEqualTo(5);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Game game = createGameWithPlayerBalanceOf(40);

    game.player.bets(15);

    assertThat(game.player.getBalance())
        .isEqualTo(25);
  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Game game = createGameWithPlayerBalanceOf(18);

    assertThat(game.player.getBalance())
        .isEqualTo(18);
  }

  @Test
  public void playerWith35Bets30WhenLosesBets20TotalBetIs50() throws Exception {
    Game game = createGameWithPlayerBalanceOf(35);

    game.player.bets(30);
    game.playerLoses();

    assertThat(game.player.getBalance())
            .isEqualTo(5);

    game.player.bets(20);

    assertThat(game.player.totalAmountBet())
            .isEqualTo(30 + 20);
  }


  private Game createGameWithPlayerBalanceOf(int amount) {
    Game game = new Game();
    game.player.deposits(amount);
    return game;
  }
}