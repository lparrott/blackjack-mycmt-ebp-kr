package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    public void playerDeposits9() throws Exception {
        Player player = new Player();

        player.deposits(9);

        assertThat(player.getBalance())
                .isEqualTo(9);
    }

    @Test
    public void playerDeposits12Bets7() throws Exception {
        Player player = new Player();

        player.deposits(12);
        player.bets(7);

        assertThat(player.getBet())
                .isEqualTo(7);
        assertThat(player.getBalance())
                .isEqualTo(12 - 7);
    }

    @Test
    public void playerDeposits50Bets7Then16() throws Exception {
        Player player = new Player();

        player.deposits(50);
        player.bets(7);
        player.bets(16);

        assertThat(player.totalAmountBet())
                .isEqualTo(7 + 16);
    }


}
