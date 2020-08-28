package com.blockchain.armagyeddon.domain.entity;


import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder @EqualsAndHashCode(of = "id")
public class Gye {

    @Id @GeneratedValue
    private Long id;

    private String type;

    private String name;
    
    private int targetMoney;

    private int period;
    
    private int totalMember;

    private String state;





}