package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.dto.ResumenSocioDTO;
import ar.utn.aceleradora.gestion.socios.modelos.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.SocioPlenario;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioEmpresaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioPlenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SocioService {
  @Autowired
  private final SocioEmpresaRepository socioEmpresaRepository;

  @Autowired
  private final SocioPlenarioRepository socioPlenarioRepository;

  public SocioService(SocioEmpresaRepository socioEmpresaRepository, SocioPlenarioRepository socioPlenarioRepository) {
    this.socioEmpresaRepository = socioEmpresaRepository;
    this.socioPlenarioRepository = socioPlenarioRepository;
  }
  public SocioEmpresa guardarSocioEmpresa(SocioEmpresa socio) {
    return socioEmpresaRepository.save(socio);
  }
  public SocioPlenario guardarSocioPlenario(SocioPlenario socio) {
    return socioPlenarioRepository.save(socio);
  }
  public Optional<Socio> obtenerSocio(Integer id){
    Optional<SocioEmpresa> socioEmpresa = socioEmpresaRepository.findById(id);
    Optional<SocioPlenario> socioPlenario = socioPlenarioRepository.findById(id);
    if( socioEmpresa.isPresent() ){
      return Optional.of(socioEmpresa.get());
    }else if( socioPlenario.isPresent() ){
      return Optional.of(socioPlenario.get());
    }else{
      return Optional.empty();
    }
  }

  public List<ResumenSocioDTO> obtenerResumenSocios() {
    List<ResumenSocioDTO> resumen = new ArrayList<>();

    List<SocioEmpresa> empresas = socioEmpresaRepository.findAll();
    for (SocioEmpresa se : empresas) {
      resumen.add(new ResumenSocioDTO(se.getNombreEmpresa(), se.getCategoria()));
    }

    List<SocioPlenario> plenarios = socioPlenarioRepository.findAll();
    for (SocioPlenario sp : plenarios) {
      resumen.add(new ResumenSocioDTO(sp.getNombreEmpresa(), sp.getCategoria()));
    }

    return resumen;
  }

}
