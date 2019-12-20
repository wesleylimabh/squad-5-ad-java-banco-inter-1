package com.aceleradev.squad5.centralerros.entity;

import com.aceleradev.squad5.centralerros.dto.UsuarioDto;
import com.aceleradev.squad5.centralerros.utils.CriptografiaUtil;
import lombok.*;

import javax.persistence.*;
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

    private String nome;

    @Column(name = "email", nullable = false, unique = true)
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
                .id(this.id)
                .nome(this.nome)
                .email(this.email)
<<<<<<< HEAD
//                .senha(CriptografiaUtil.criptografa(this.senha))
//                .token(this.token)
=======
                .token(this.token)
>>>>>>> c4c7f4347d8dab2e17633f19ef67bcff5d978b8a
                .build();
    }

}
