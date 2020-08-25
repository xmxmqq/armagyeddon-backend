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
    private String title;
    private int targetMoney;
    private int period;
    private int totalMember;
    private String state;
    private String master;

    public Gye toEntity() {
        Gye gye = Gye.builder()
                .id(id)
                .type(type)
                .title(title)
                .targetMoney(targetMoney)
                .period(period)
                .totalMember(totalMember)
                .state(state)
                .master(master)
                .build();
        return gye;
    }


}
