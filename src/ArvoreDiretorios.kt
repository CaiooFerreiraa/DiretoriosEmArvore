class ArvoreDiretorios: Arborizavel<String> {
    var raiz: NoTriplo? = null;

    override fun criar(dado: String, diretorio: String): Boolean {
        if (raiz == null) {
            raiz = NoTriplo("C:");
        }

        val diretorioNo = buscaNo(raiz, diretorio);

        if (diretorioNo != null) {
            for (i in 0 until diretorioNo.arrayPointers.size) {
                if (diretorioNo.arrayPointers[i] == null) {
                    diretorioNo.arrayPointers[i] = NoTriplo(dado);
                    diretorioNo.arrayPointers[i]!!.genitor = diretorioNo
                    return true;
                }
            }
        }

        return false;
    }


    fun criar(dado: String) {
        if (raiz == null) {
            raiz = NoTriplo("C:");
        }
        criar(dado, "C:")
    }

    fun detalhes(diretorio: String) {
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

    private fun buscaNo(no: NoTriplo?, diretorio: String): NoTriplo? {
        if (no == null) return null;
        if (no.dado == diretorio) return no;

        for (i in 0 until no.arrayPointers.size) {
            val filho = no.arrayPointers[i];
            val encontrado = buscaNo(filho, diretorio);
            if (encontrado != null) return encontrado;
        }
        return null;
    }

    fun caminhoCompleto(diretorio: String) {
        val diretorioNo = buscaNo(raiz, diretorio)

        if (diretorioNo != null) {
            println("Caminho completo: " + construirCaminho(diretorioNo))
        }
    }

    private fun construirCaminho(no: NoTriplo?): String {
        if (no == null) return ""
        if (no.genitor == null) return no.dado  // Se for a raiz, apenas retorna o nome

        return construirCaminho(no.genitor) + "/" + no.dado
    }

    fun removerDiretorio(diretorio: String) {
        var diretorioNo = buscaNo(raiz, diretorio);
        var pai = diretorioNo?.genitor;

        if (pai == null) {
            raiz = null;
        } else {
            for (i in 0 until pai.arrayPointers.size) {
                if (diretorioNo == pai.arrayPointers[i]) {
                    pai.arrayPointers[i] = null;
                }
            }
        }

    }
}
