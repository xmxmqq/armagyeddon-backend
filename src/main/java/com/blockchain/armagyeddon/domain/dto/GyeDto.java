package com.blockchain.armagyeddon.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GyeDto {

    private String type;

    private String title;

    private int targetMoney;

    private int period;

    private int totalMember;

    private String state;

    private String master;

}
