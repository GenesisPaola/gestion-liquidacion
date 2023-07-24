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
    public Usuario buscarUsuarioPorId(int id_usuario) {
        return objUsuarioRepo.findById(id_usuario).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioActulizar, int id_usuario) {
        Usuario usuario = objUsuarioRepo.findById(id_usuario).orElseThrow(()-> new NoSuchElementException("Usuario no encontrado"));
        usuario.setClave(usuarioActulizar.getClave());
        usuario.setNombre(usuarioActulizar.getNombre());
        usuario.setApellido1(usuarioActulizar.getApellido1());
        usuario.setApellido2(usuarioActulizar.getApellido2());
        usuario.setPerfil(usuarioActulizar.getPerfil());
        usuario.setEmail(usuarioActulizar.getEmail());
        usuario.setTelefono(usuarioActulizar.getTelefono());
        return objUsuarioRepo.save(usuario);
    }
    @Override
    public void eliminarUsuario2(int id_usuario) {
        objUsuarioRepo.deleteById(id_usuario);
    }

}
