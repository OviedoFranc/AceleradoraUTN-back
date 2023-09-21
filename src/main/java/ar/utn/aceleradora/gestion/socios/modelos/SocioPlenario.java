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

import static ar.utn.aceleradora.gestion.socios.modelos.TipoSocio.SOCIO_PLENARIO;
@Entity
@Getter
@Setter
public class SocioPlenario implements Socio{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Enumerated(EnumType.ORDINAL)
  private TipoSocio categoria = SOCIO_PLENARIO;
  @Column
  private String nombreEmpresa;
  @Column
  private String nombrePresidente;
  @Column
  private Boolean activo;

  @Column
  private Integer telefono;

  @Column
  private String mail;

  public SocioPlenario() {
  }

  public void votar(){
    //TODO
  }

  public SocioPlenario(String nombreEmpresa, String nombrePresidente, String categoria, Integer telefono, String mail) {
    this.nombreEmpresa = nombreEmpresa;
    this.nombrePresidente = nombrePresidente;
    this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
    this.telefono = telefono;
    this.mail = mail;
  }

}


