fun main() {
    var arvore = ArvoreDiretorios();

    arvore.criar("Documents")
    arvore.criar("Photos")
    arvore.criar("Downloads")
    arvore.criar("Musics")
    arvore.criar("Videos")

    arvore.detalhes("C:")
    arvore.criar("foto.png", "Photos")

    arvore.caminhoCompleto("foto.png");
}