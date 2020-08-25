package com.blockchain.armagyeddon.domain.entity;


import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Gye {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20, nullable = false)
    private String type;

    @Column(length = 30, unique = true, nullable = false)
    private String title;

    @Column(length = 30, nullable = false)
    private int targetMoney;

    @Column(length = 20, nullable = false)
    private int period;

    @Column(length = 20, nullable = false)
    private int totalMember;

    @Column(length = 20, nullable = false)
    private String state;

    @Column(length = 20, nullable = false)
    private String master;

    @OneToMany(mappedBy = "gye") // mappedBy(참조당하는 쪽) = gye
    private List<GyeUser> gyeUsers = new ArrayList<>();
}