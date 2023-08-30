enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val id: Int, var usuario: String, val email: String)

data class ConteudoEducacional(val id: Int, var nome: String, var nivel: Nivel, val duracao: Int = 60)

data class Formacao(val id: Int, val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (usuario.usuario.length > 3 && usuario.email.length >= 7){
            inscritos.add(usuario)
        }
    }
}

fun detalheFormacao(f: Formacao){
    //Armazena os conteudos e inscritos
    val conteudos = f.conteudos
    val inscritos = f.inscritos
    //Exibe os detalhes
    println("=============FORMAÇÃO=============")
    println("${f.nome}")
    println("==============AULAS===============")
    for (conteudo in conteudos){
        println("Aula: ${conteudo.nome}")
        println("Nivel: ${conteudo.nivel}")
        println("Duração: ${conteudo.duracao}")
    }
    println("==============ALUNOS==============")
    for (inscrito in inscritos){
        println("Nome: ${inscrito.usuario}")
        println("Email: ${inscrito.email}")
        println("==================================")
    }
    println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
}

fun main() {
    //Cria niveis
    val basico = Nivel.BASICO
    val intermediario = Nivel.INTERMEDIARIO
    val dificil = Nivel.DIFICIL
    
    //Cria usuários
    val usuario1 = Usuario(1, "matheus", "matheus@email.com")
    val usuario2 = Usuario(2, "joão", "joao@email.com")
    val usuario3 = Usuario(3, "fulano", "fulano@email.com")
    val usuario4 = Usuario(4, "ciclano", "ciclano@email.com")
    
    //Cria conteúdos educacionais
    val conteudo1 = ConteudoEducacional(1, "Lógica de programação", basico, 120)
    val conteudo2 = ConteudoEducacional(2, "Operadores", intermediario, 60)
    val conteudo3 = ConteudoEducacional(3, "Funções", intermediario, 120)
    val conteudo4 = ConteudoEducacional(4, "Programação Orientada a Objetos", dificil,  240)
    val conteudoJava = ConteudoEducacional(5, "Instalando a JVM", basico, 60)
    val conteudoKotlin = ConteudoEducacional(6, "Instalando o Android studio", basico, 60)
    
    //Cria listas de conteudos educacionais
    val conteudosJava = mutableListOf<ConteudoEducacional>()
    conteudosJava.add(conteudo1)
    conteudosJava.add(conteudo2)
    conteudosJava.add(conteudo3)
    conteudosJava.add(conteudo4)
    conteudosJava.add(conteudoJava)
    
    val conteudosKotlin = mutableListOf<ConteudoEducacional>()
    conteudosKotlin.add(conteudo1)
    conteudosKotlin.add(conteudo2)
    conteudosKotlin.add(conteudo3)
    conteudosKotlin.add(conteudo4)
    conteudosKotlin.add(conteudoKotlin)
    
    //Cria formações
    val formacaoJava = Formacao(1, "Java", conteudosJava)
    val formacaoKotlin = Formacao(2, "Kotlin", conteudosKotlin)
    
    //Matricula os usuarios
    formacaoJava.matricular(usuario1)
    formacaoJava.matricular(usuario2)
   	
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)
    formacaoKotlin.matricular(usuario4)
    
    //Print das formacoes
    detalheFormacao(formacaoJava)
    detalheFormacao(formacaoKotlin)
}