package model;

import java.text.ParseException;
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
        if (descricao == null || descricao.isEmpty())
            throw new illegalArgumentException("Descrição não pode ser vazia.");
        if (duracao <= 0) throw new illegalArgumentException("Duração deve ser um número positivo.");
        if (categoria == null || categoria.isEmpty())
            throw new illegalArgumentException("Categoria não pode ser vazia.");
        if (dataPublicacao == null) throw new illegalArgumentException("Data de publicação inválida.");

        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.categoria = categoria;
        this.dataPublicacao = dataPublicacao;
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
        return titulo + ";" + descricao + ";" + duracao + ";" + categoria + ";" + sdf.format(dataPublicacao);
    }

    public static Video fromString(String linha) {
        try {
            String[] partes = linha.split(";");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return new Video(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3], sdf.parse(partes[4]));
        } catch (illegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            return null; // Ignora erros de parsing
        }

    }

    public Video atualizarVideo(String novoTitulo, String novaDescricao, int novaDuracao, String novaCategoria, String novaDataStr) throws illegalArgumentException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date novaData = novaDataStr.isEmpty() ? this.dataPublicacao : sdf.parse(novaDataStr);
        return new Video(
                novoTitulo.isEmpty() ? this.titulo : novoTitulo,
                novaDescricao.isEmpty() ? this.descricao : novaDescricao,
                novaDuracao == 0 ? this.duracao : novaDuracao,
                novaCategoria.isEmpty() ? this.categoria : novaCategoria,
                novaData
        );
    }
    public String toCSV() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%s;%s;%d;%s;%s", titulo, descricao ,duracao ,categoria, sdf.format(dataPublicacao));
    }

    public Object getId() {
        return null;
    }
}

