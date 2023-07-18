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
    public Usuario actualizarUsuario(Usuario usuarioActulizar, int idUsuario) {
        Usuario usuario = objUsuarioRepo.findById(idUsuario).orElseThrow(()-> new NoSuchElementException("Usuario no encontrado"));
        usuario.setRun(usuarioActulizar.getRun());
        usuario.setClave(usuarioActulizar.getClave());
        usuario.setNombre(usuarioActulizar.getNombre());
        usuario.setApellido_1(usuarioActulizar.getApellido_1());
        usuario.setApellido_2(usuarioActulizar.getApellido_2());
        usuario.setPerfil(usuarioActulizar.getPerfil());
        usuario.setEmail(usuarioActulizar.getEmail());
        usuario.setFecha_creacion(usuarioActulizar.getFecha_creacion());
        usuario.setTelefono(usuarioActulizar.getTelefono());
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario2(Usuario usuarioActualizar) {
        Usuario usuario = objUsuarioRepo.findById(usuarioActualizar.getId_usuario()).orElseThrow(()-> new NoSuchElementException("Usuario no encontrado"));
        usuario.setRun(usuarioActualizar.getRun());
        usuario.setClave(usuarioActualizar.getClave());
        usuario.setNombre(usuarioActualizar.getNombre());
        usuario.setApellido_1(usuarioActualizar.getApellido_1());
        usuario.setApellido_2(usuarioActualizar.getApellido_2());
        usuario.setPerfil(usuarioActualizar.getPerfil());
        usuario.setEmail(usuarioActualizar.getEmail());
        usuario.setFecha_creacion(usuarioActualizar.getFecha_creacion());
        usuario.setTelefono(usuarioActualizar.getTelefono());
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        objUsuarioRepo.delete(usuario);
    }

    @Override
    public void eliminarUsuario2(int idUsuario) {
        objUsuarioRepo.deleteById(idUsuario);
    }

}
