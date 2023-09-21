package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.SocioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import static ar.utn.aceleradora.gestion.socios.modelos.TipoSocio.SOCIO_EMPRESA;

@Repository
public interface SocioEmpresaRepository extends JpaRepository<SocioEmpresa, Integer> {


}


