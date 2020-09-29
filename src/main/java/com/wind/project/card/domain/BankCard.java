package com.wind.project.card.domain;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
public class BankCard {
    private Long id;
    private Long userId;
    private String bankName;
    private int flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public BankCard() {
    }
}
