package ar.utn.aceleradora.gestion.socios.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import static ar.utn.aceleradora.gestion.socios.modelos.TipoSocio.SOCIO_EMPRESA;

@Getter
@Setter
@Entity
public class SocioEmpresa implements Socio{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String nombreEmpresa;
  @Enumerated(EnumType.ORDINAL)
  private TipoSocio categoria = SOCIO_EMPRESA;
  @Column
  private Boolean activo;
  @Column
  private Integer telefono;
  @Column
  private String mail;

  public SocioEmpresa(String nombreEmpresa, TipoSocio categoria, Integer telefono, String mail) {
    this.nombreEmpresa = nombreEmpresa;
    this.categoria = categoria;
    this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
    this.telefono = telefono;
    this.mail = mail;
  }

  public SocioEmpresa() {

  }
}
