package entities;

import enums.SexoPet;
import enums.TipoPet;

public class Pet {
    private String nome;
    private TipoPet tipoPet;
    private SexoPet sexoPet;
    private String endereco;
    private Double idade;
    private Double peso;
    private String raca;

    public Pet(){
    }

    public Pet(String nome, TipoPet tipoPet, SexoPet sexoPet, String endereco, Double idade, Double peso, String raca) {
        this.nome = nome;
        this.tipoPet = tipoPet;
        this.sexoPet = sexoPet;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPet getPetType() {
        return tipoPet;
    }

    public void setPetType(TipoPet tipoPet) {
        this.tipoPet = tipoPet;
    }

    public SexoPet getPetSex() {
        return sexoPet;
    }

    public void setPetSex(SexoPet sexoPet) {
        this.sexoPet = sexoPet;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getIdade() {
        return idade;
    }

    public void setIdade(Double idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
