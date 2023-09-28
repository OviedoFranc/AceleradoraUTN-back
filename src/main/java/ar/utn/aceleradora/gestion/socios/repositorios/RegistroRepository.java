package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.registros.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer>{
}
