package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.dto.ResumenSocioDTO;
import ar.utn.aceleradora.gestion.socios.modelos.Socio;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/socio")
@RestController
public class SocioController {

      @Autowired
      private SocioService socioService;

      public SocioController(SocioService socioService) {
        this.socioService = socioService;
      }

      @GetMapping("/busquedaPaginada")
      public ResponseEntity<Page<ResumenSocioDTO>> obtenerResumenSocios(
          @RequestParam(defaultValue = "0") int pagina,
          @RequestParam(defaultValue = "10") int tamanio) {

        List<ResumenSocioDTO> resumen = socioService.obtenerResumenSocios();
        Page<ResumenSocioDTO> pages = new PageImpl<>(resumen, PageRequest.of(pagina, tamanio), resumen.size());

        return ResponseEntity.ok(pages);
      }

      @GetMapping("/{id}")
      public ResponseEntity<Socio> obtenerProducto(@PathVariable Integer id) {
        Optional<Socio> socioOptional = socioService.obtenerSocio(id);

        return socioOptional
            .map(socio -> new ResponseEntity<>(socio, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
      }


}
