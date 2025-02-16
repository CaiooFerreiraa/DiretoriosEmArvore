interface Arborizavel<T> {
    fun criar(dado: T, diretorio: String = "C:"): Boolean
    fun detalhesArvore()
    fun caminhoCompleto(diretorio: T)
    fun removerDiretorio(diretorio: T)
    fun detalhes(diretorio: T)
}