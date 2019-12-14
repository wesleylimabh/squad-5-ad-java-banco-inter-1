package com.aceleradev.squad5.centralerros.dto;

import com.aceleradev.squad5.centralerros.entity.Usuario;
import com.aceleradev.squad5.centralerros.utils.CriptografiaUtil;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String token;

    public Usuario toEntity (){

        return Usuario.builder()
                .id(this.id)
                .nome(this.nome)
                .email(this.email)
                .senha(CriptografiaUtil.criptografa(this.senha))
                .token(this.token)
                .build();
    }

}
