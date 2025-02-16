class ArvoreDiretorios: Arborizavel<String> {
    var raiz: NoMultiplo? = null;

    override fun criar(dado: String, diretorio: String): Boolean {
        if (raiz == null) {
            raiz = NoMultiplo("C:");
        }

        val diretorioNo = buscaNo(raiz, diretorio);

        if (diretorioNo != null) {
            for (i in 0 until diretorioNo.arrayPointers.size) {
                if (diretorioNo.arrayPointers[i] == null) {
                    diretorioNo.arrayPointers[i] = NoMultiplo(dado);
                    diretorioNo.arrayPointers[i]!!.genitor = diretorioNo
                    return true;
                }
            }
        }

        return false;
    }

    override fun criar(dado: String) {
        if (raiz == null) {
            raiz = NoMultiplo("C:");
        }
        criar(dado, "C:")
    }

    override fun detalhes(diretorio: String) {
        var diretorioNo = buscaNo(raiz, diretorio);

        if (diretorioNo != null) {
            println("Pastas/arquivos dentro de ${diretorioNo.dado} -> ")
            for (i in 0 until diretorioNo.arrayPointers.size) {
                if (diretorioNo.arrayPointers[i] != null) {
                    println("   " + diretorioNo.arrayPointers[i]!!.dado);
                }
            }
        }
    }


    private fun imprimirDetalhes(no: NoMultiplo, nivel: Int) {
        var temFilho = false

        for (i in 0 until no.arrayPointers.size) {
            if (no.arrayPointers[i] != null) {
                temFilho = true
                break
            }
        }

        if (!temFilho) return

        val indentacao = "  ".repeat(nivel)
        println("$indentacao Pastas/arquivos dentro de ${no.dado} ->")

        for (i in 0 until no.arrayPointers.size) {
            if (no.arrayPointers[i] != null) {
                println("$indentacao   ${no.arrayPointers[i]!!.dado}")
                imprimirDetalhes(no.arrayPointers[i]!!, nivel + 1) // Chamada recursiva
            }
        }
    }

    override fun detalhesArvore() {
        if (raiz == null) {
            println("Arvore vazia.")
            return
        }
        imprimirDetalhes(raiz!!, 0)
    }

    private fun buscaNo(no: NoMultiplo?, diretorio: String): NoMultiplo? {
        if (no == null) return null;
        if (no.dado == diretorio) return no;

        for (i in 0 until no.arrayPointers.size) {
            val filho = no.arrayPointers[i];
            val encontrado = buscaNo(filho, diretorio);
            if (encontrado != null) return encontrado;
        }
        return null;
    }

    override fun caminhoCompleto(diretorio: String) {
        val diretorioNo = buscaNo(raiz, diretorio)

        if (diretorioNo != null) {
            println("Caminho completo: " + construirCaminho(diretorioNo))
        }
    }

    private fun construirCaminho(no: NoMultiplo?): String {
        if (no == null) return ""
        if (no.genitor == null) return no.dado

        return construirCaminho(no.genitor) + "/" + no.dado
    }

    override fun removerDiretorio(diretorio: String) {
        var diretorioNo = buscaNo(raiz, diretorio);
        var pai = diretorioNo?.genitor;

        if (diretorioNo == raiz) {
            raiz = null;
            println("Toda a arvore foi apagada!")
            return
        } else {
            for (i in 0 until pai?.arrayPointers!!.size) {
                if (diretorioNo == pai.arrayPointers[i]) {
                    pai.arrayPointers[i] = null;
                    println("Diretorio: " + diretorioNo + " removido com sucesso!");
                    return
                }
            }
        }

        println("Diretorio: " + diretorioNo + " não encontrado");

    }
}
