package com.blockchain.armagyeddon.domain.dto;

import com.blockchain.armagyeddon.domain.entity.UserInfo;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class UserInfoDto {
    private String email;
    private String password;
    private String name;
    private String public_key;

    @Builder
    public UserInfo toEntity() {
        UserInfo userInfo = UserInfo.builder()
                .email(email)
                .password(password)
                .name(name)
                .public_key(public_key)
                .build();

        return userInfo;
    }

}
