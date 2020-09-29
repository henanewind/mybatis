package com.wind.project.card.domain;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
public class DebitCard extends BankCard {
    /**
     * 存款金额
     */
    private String deposit;

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public DebitCard() {
    }
}
