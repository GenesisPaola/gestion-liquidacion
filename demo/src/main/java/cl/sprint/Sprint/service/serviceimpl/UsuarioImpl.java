package cl.sprint.Sprint.service.serviceimpl;

import cl.sprint.Sprint.entity.Usuario;
import cl.sprint.Sprint.repository.IUsuarioRepo;
import cl.sprint.Sprint.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("usuarioImpl")
public class UsuarioImpl implements IUsuarioService {
    @Autowired //inyeccion de repositorio
    IUsuarioRepo objUsuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuario){
        return objUsuarioRepo.save(usuario);
    }

    //Registrar usuario
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios(){
        return objUsuarioRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario, int idUsuario) {
        return null;
    }

    @Override
    public Usuario actualizarUsuario2(Usuario usuario) {
        return null;
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {

    }

    @Override
    public void eliminarUsuario2(int idUsuario) {

    }

}
