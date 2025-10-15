package com.maintech.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacoes")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String descricaoEquipamento;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEquipamento categoria;

    @Column(nullable = false, length = 1000)
    private String descricaoDefeito;

    private LocalDateTime dataHoraAbertura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSolicitacao estado;

    private BigDecimal valorOrcamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_orcamento_id")
    private Funcionario funcionarioOrcamento;

    public Solicitacao() {
        this.dataHoraAbertura = LocalDateTime.now();
        this.estado = EstadoSolicitacao.ABERTA;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricaoEquipamento() { return descricaoEquipamento; }
    public void setDescricaoEquipamento(String descricaoEquipamento) { this.descricaoEquipamento = descricaoEquipamento; }
    public CategoriaEquipamento getCategoria() { return categoria; }
    public void setCategoria(CategoriaEquipamento categoria) { this.categoria = categoria; }
    public String getDescricaoDefeito() { return descricaoDefeito; }
    public void setDescricaoDefeito(String descricaoDefeito) { this.descricaoDefeito = descricaoDefeito; }
    public LocalDateTime getDataHoraAbertura() { return dataHoraAbertura; }
    public void setDataHoraAbertura(LocalDateTime dataHoraAbertura) { this.dataHoraAbertura = dataHoraAbertura; }
    public EstadoSolicitacao getEstado() { return estado; }
    public void setEstado(EstadoSolicitacao estado) { this.estado = estado; }
    public BigDecimal getValorOrcamento() { return valorOrcamento; }
    public void setValorOrcamento(BigDecimal valorOrcamento) { this.valorOrcamento = valorOrcamento; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Funcionario getFuncionarioOrcamento() { return funcionarioOrcamento; }
    public void setFuncionarioOrcamento(Funcionario funcionarioOrcamento) { this.funcionarioOrcamento = funcionarioOrcamento; }
}