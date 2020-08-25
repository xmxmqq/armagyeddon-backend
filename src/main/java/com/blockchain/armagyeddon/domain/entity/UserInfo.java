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
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;


    private String public_key;

    @OneToMany(mappedBy = "userinfo") // mappedBy(참조당하는 쪽) = userInfo
    private List<GyeUser> gyeUsers = new ArrayList<>();


}