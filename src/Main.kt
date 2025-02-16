fun main() {
    var arvore = ArvoreDiretorios();

    arvore.criar("Documents")
    arvore.criar("Photos")
    arvore.criar("Downloads")
    arvore.criar("Musics")
    arvore.criar("Videos")

    arvore.detalhes("C:")

    arvore.caminhoCompleto("Photos");
}