package br.com.acervocesar.utils;

import br.com.acervocesar.entidade.usuario.Usuario;

import java.util.Comparator;

public class ComparadorUsuarioNivel implements Comparator<Usuario> {

    @Override
    public int compare(Usuario o1, Usuario o2) {
        double nivel1 = o1.getNivel();
        double nivel2 = o2.getNivel();

        if (nivel1 < nivel2) {
            return 1;
        } else if (nivel1 > nivel2) {
            return -1;
        }
        return 0;
    }
}
