package aula06.exercicio15;

public class Exe15 {
    public static void main(String[] args) {
        mostrarRecursosPerfil(NivelAcesso.ADMIN);
        mostrarRecursosPerfil(NivelAcesso.USUARIO);
        mostrarRecursosPerfil(NivelAcesso.MODERADOR);
    }
    public static void mostrarRecursosPerfil(NivelAcesso tipo) {
        switch (tipo) {
            case ADMIN:
                System.out.println("\nO seu nível de acesso é de Administrador.\nVocê pode visualizar conteúdos ocultos para os usuários e edita-los.");
                break;
            case USUARIO:
                System.out.println("\nO seu nível de acesso é de Usuário.\nVocê pode visualizar conteúdos destinados aos usuários convencionais.");
                break;
            default:
                System.out.println("\nO seu nível de acesso é de Moderador.\nVocê pode visualizar conteúdos ocultos para os usuários, mas não pode edita-los.");
                break;
        }
    }
}
