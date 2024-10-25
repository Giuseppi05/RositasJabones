package Interfaces;

import java.util.ArrayList;

public interface CRUDInterface <T> {
    public boolean insertar(T c);
    public boolean actualizar(T c);
    public boolean eliminar(Integer codigo);
    public T listarUno(Integer codigo);
    public T listarUnoNom(String nom);
    public ArrayList<T> listarTodo();
}