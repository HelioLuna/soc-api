package com.helioluna.socapi.domain;

import com.helioluna.socapi.util.interfaces.Save;
import com.helioluna.socapi.util.interfaces.Update;
import com.helioluna.socapi.util.interfaces.UpdateRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome obrigatório.", groups = {Save.class, Update.class})
    @Column(length = 75, nullable = false)
    private String name;

    @NotNull(message = "Preço unitário obrigatório", groups = {Save.class, UpdateRole.class})
    @Column(nullable = false)
    private Double precoUnitario;

    @Column
    private Integer multiplo;

}
