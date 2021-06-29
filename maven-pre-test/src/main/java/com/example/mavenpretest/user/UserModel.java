package com.example.mavenpretest.user;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserModel {
    @NonNull
    private int id;
    private String name;
}
