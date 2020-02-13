package com.helioluna.socapi.domain;

import com.helioluna.socapi.util.interfaces.Save;
import com.helioluna.socapi.util.interfaces.UpdateRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Produto obrigatório", groups = {Save.class, UpdateRole.class})
    @JoinColumn(nullable = false)
    private Produto produto;

    @NotNull(message = "Quantidade obrigatória", groups = {Save.class, UpdateRole.class})
    @Column
    private Integer quantidade;

    @NotNull(message = "Preço unitário obrigatório", groups = {Save.class, UpdateRole.class})
    @Column(nullable = false)
    private Double precoUnitario;

}
