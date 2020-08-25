package com.blockchain.armagyeddon.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGye { // 연관관계에서 주인

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // fk
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "gye_id") // fk
    private Gye gye;

    @Column(nullable = false)
    private String userState;

    @Column(length = 10, nullable = false)
    private String order;
}
