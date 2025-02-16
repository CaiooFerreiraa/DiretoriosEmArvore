interface Arborizavel<T> {
    fun criar(dado: T, diretorio: T): Boolean
    fun criar(dado: T)
    fun detalhesArvore()
    fun caminhoCompleto(diretorio: T)
    fun removerDiretorio(diretorio: T)
    fun detalhes(diretorio: T)
}