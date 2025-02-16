fun main() {
    var arvore = ArvoreDiretorios();

    arvore.criar("Documents")
    arvore.criar("Photos")
    arvore.criar("Downloads")
    arvore.criar("Musics")
    arvore.criar("Videos")

    arvore.criar("caio.jpg", "Photos")
    arvore.criar("so.pdf", "Documents")

    //arvore.detalhes("C:")
    arvore.detalhesArvore()
}