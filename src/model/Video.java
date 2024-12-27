package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Video {
    private String titulo;
    private String descricao;
    private int duracao; // em minutos
    private String categoria;
    private Date dataPublicacao;


    public Video(String titulo, String descricao, int duracao, String categoria, Date dataPublicacao) throws illegalArgumentException {

        if (titulo == null || titulo.isEmpty()) throw new illegalArgumentException("Título não pode ser vazio.");
        if (descricao == null || descricao.isEmpty()) throw new illegalArgumentException("Descrição não pode ser vazio.");
        if (duracao <= 0) throw new illegalArgumentException("Duração deve ser um número positivo.");
        if (categoria == null || categoria.isEmpty()) throw new illegalArgumentException("Categoria não pode ser vazia.");
        if (dataPublicacao == null) throw new illegalArgumentException("Data de publicação inválida.");

        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.categoria = categoria;
        this.dataPublicacao = dataPublicacao;
    }

    public static Video fromString(String line) {
        return null;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Título: %s | Descricao %s | Duracao %s min | Categoria $s | Data: %s", titulo, descricao, duracao, categoria, sdf.format(dataPublicacao));
    }

}