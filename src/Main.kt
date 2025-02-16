import kotlin.reflect.typeOf

private var arvore = ArvoreDiretorios();

fun main() {

    var cond: Boolean = true;

    loop@ while (cond) {
        println("--------------------------------------------------------------x")
        println(
            "1. Criação de Diretório/Arquivo\n2. Visualização da Árvore destacando a relação entre os diretórios e seus arquivos/diretórios\n3. Busca de Diretórios/Arquivos;\n4. Detalhes do Diretório/Arquivos\n5. Remoção de Arquivo e Remoção de Diretório que gerará uma remoção de todos os arquivos/diretórios hierarquicamente abaixo dele;\n6. Impressão de Caminho Completo do Diretório/Arquivo;\n7. Encerrar programa;"
        )
        println("--------------------------------------------------------------x")

        println("Escolha um opção")
        val option = readln().toIntOrNull();

        if (option == null) {
            println("Digite uma opção válida")
            continue@loop
        }

        when (option) {
            1 -> criarArquivo();
            2 -> arvore.detalhesArvore()
            3 -> {
                println("Digite o nome do arquivo")
                val nome : String = readln();

                arvore.buscarArquivo(nome);
            }
            4 -> {
                println("Digite o nome do arquivo");
                val nome : String = readln();

                arvore.detalhes(nome);
            }
            5 -> {
                println("Digite o nome do arquivo");
                val nome : String = readln()

                arvore.removerDiretorio(nome);
            }
            6 -> {
                println("Digite o nome do arquivo");
                val nome : String = readln()

                arvore.caminhoCompleto(nome);
            }
            7 -> cond = false;
            else -> println("Digite um número válido")
        }
    }
}

fun criarArquivo() {
    println("1. Criar arquivo sem diretório (criará na raiz)\n2. Criar arquivo em um diretório específico");

    val option: Int = readln().toIntOrNull() ?: run {
        println("Digite um número válido")
        return
    };


    when (option) {
        1 -> {
            println("Digite o nome do arquivo")
            val nome : String = readln()
            arvore.criar(nome);
        }
        2 -> {
            println("Digite o nome do arquivo")
            val nome : String = readln()
            println("Digite o nome do Diretorio")
            val diretorio: String = readln()
            arvore.criar(nome, diretorio);
        }
        else -> println("Digite um número válido")
    }
}