package com.daian.pagamento.entities;

import com.daian.pagamento.entities.vo.VendaVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "venda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venda implements Serializable {

    private static final long serialVersionUID = 7941763390118968225L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name = "data", nullable = false)
    private Date data;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.REFRESH)
    private List<ProdutoVenda> produtos;

    @Column(name = "valorTotal", nullable = false, length = 10)
    private Double valorTotal;

    public static Venda create(VendaVO vendaVO) {
        return new ModelMapper().map(vendaVO, Venda.class);
    }

}