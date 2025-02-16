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

    fun imprimir(diretorio: String) {
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

        for (i in 0 until  no.arrayPointers.size) {
            val filho = no.arrayPointers[i];
            val encontrado = buscaNo(filho, diretorio);
            if (encontrado != null) return encontrado;
        }
        return null;
    }
}