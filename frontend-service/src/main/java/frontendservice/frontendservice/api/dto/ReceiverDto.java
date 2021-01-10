package com.app.frontendservice.api.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReceiverDto {

    @Email
    @NotEmpty
    private String mailAddress;

}
