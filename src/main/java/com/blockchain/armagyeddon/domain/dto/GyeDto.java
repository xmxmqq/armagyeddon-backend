package com.blockchain.armagyeddon.domain.dto;


import com.blockchain.armagyeddon.domain.entity.Gye;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GyeDto {
    private Long id;
    private String type;
    private String name;
    private int targetMoney;
    private int period;
    private int totalMember;
    private String state;

    public Gye toEntity() {
        Gye gye = Gye.builder()
                .id(id)
                .type(type)
                .name(name)
                .targetMoney(targetMoney)
                .period(period)
                .totalMember(totalMember)
                .state(state)
                .build();
        return gye;
    }


}
