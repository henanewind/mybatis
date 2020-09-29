package com.wind.project.card.mapper;

import com.wind.project.card.domain.BankCard;

import java.util.List;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
public interface BankCardMapper {
    public List<BankCard> findBankCardsByUserId(Long userId);
}
