package com.wind.project.card.domain;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
public class CreditCard extends BankCard {
    /**
     * 消费额度
     */
    private String creditLine;

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    public CreditCard() {
    }
}
