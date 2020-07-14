
package cursosonline.dao;
import java.util.List;
import cursosonline.entidades.Curso;
/**
 *
 * @author Nicol
 */
public interface CursoDAO {
    void ingresar (Curso curso);
    void actualizar (Curso curso);
    void eliminar (int id);
    List<Curso> getCursos();
}
