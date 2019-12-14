package com.aceleradev.squad5.centralerros.entity;

import com.aceleradev.squad5.centralerros.dto.UsuarioDto;
import com.aceleradev.squad5.centralerros.utils.CriptografiaUtil;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = Usuario.TABLE_NAME)
public class Usuario {

    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String senha;

    @NotBlank
    @NotNull
    private String token;

    public Usuario(Usuario user) {
        this.setEmail(user.getEmail());
        this.setSenha(user.getSenha());
    }

    public UsuarioDto toDto(){
        return UsuarioDto.builder()
                .nome(this.nome)
                .email(this.email)
                .senha(CriptografiaUtil.criptografa(this.senha))
                .build();
    }

}
