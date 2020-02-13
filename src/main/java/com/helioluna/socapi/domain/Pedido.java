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
@Entity(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Cliente obrigatório", groups = {Save.class, UpdateRole.class})
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @NotNull(message = "Item obrigatório", groups = {Save.class, UpdateRole.class})
    @JoinColumn(nullable = false)
    private Item item;
}
