package com.helioluna.socapi.domain;

import com.helioluna.socapi.util.interfaces.Save;
import com.helioluna.socapi.util.interfaces.Update;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome obrigatório.", groups = {Save.class, Update.class})
    @Column(length = 75, nullable = false)
    private String nome;

}
