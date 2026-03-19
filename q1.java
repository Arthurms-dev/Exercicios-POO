import java.util.ArrayList;
import java.util.List;

class Filme {
    private String titulo;
    private String genero;
    private int anoLancamento;

    Filme(String titulo, String genero, int anoLancamento){
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    Filme(String titulo, String genero){
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String toString () {
        return "Filme: " + titulo + " Genero:" + genero + " Ano de lançamento: " + anoLancamento;
    }
}

class Locadora {
    private String nome;
    private List<Filme> filmes;

    Locadora(String nome) {
        this.nome = nome;
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme (Filme filme) {
        if (filme != null) {
            this.filmes.add(filme);
        }
    }

    public void listarFilmes () {
        System.out.println("Listagem de filmes da locadora: " + this.nome + " -----");

        for (Filme f : filmes) {
            System.out.println(f.toString());
        }
    }
}

class LocadoraEstoque {
    public static void main(String[] args) {
        Locadora minhaLocadora = new Locadora("Aluga cinema");

        Filme f1 = new Filme("Jurrassic World", " Ação e fantasia", 2018);
        System.out.println();
        Filme f2 = new Filme("Guadiões da galáxia", " Fantasia", 2015);
        System.out.println();
        Filme f3 = new Filme("Gênio indomável", " Drama");

        minhaLocadora.adicionarFilme(f1);
        minhaLocadora.adicionarFilme(f2);
        minhaLocadora.adicionarFilme(f3);

        minhaLocadora.listarFilmes();
    }
}