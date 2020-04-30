package ExamenREST;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ClienteController {
		private static ArrayList<ClienteModel> listaClientes = new ArrayList<ClienteModel>();
		public static void main(String[] args) {
			SpringApplication.run(ClienteController.class, args);
		}
		
		@PostMapping("/crear")
		public ResponseEntity<ClienteModel> crear(@RequestBody ClienteModel cliente) {
			listaClientes.add(cliente);
			System.out.println(cliente.getNombre());
			System.out.println(cliente.getApellidos());
			System.out.println(cliente.getNombre_usuario());
			System.out.println(cliente.getCorreo_electronico());
			System.out.println(cliente.getContrasena());
			return ResponseEntity.ok(cliente);

		}
		
		@GetMapping("/leer/{cliente_id}")
		public ResponseEntity<?> read(@PathVariable("cliente_id") int cliente_id) {
			Integer idInt=cliente_id;
		    ClienteModel clienteEncontrado = this.buscarClientePorId(idInt);
		    if (clienteEncontrado == null) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente No encontrado");
		    } else {
		        return ResponseEntity.ok(clienteEncontrado);
		    }
		}
		private ClienteModel buscarClientePorId(Integer id) {
			for (ClienteModel clienteModel : listaClientes) {
				if(clienteModel.getCliente_id().equals(id)) {
					return clienteModel;
				}
			}
			return null;
		}
}
