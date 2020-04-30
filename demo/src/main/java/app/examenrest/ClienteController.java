package app.examenrest;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	private static ArrayList<ClienteModel> listaClientes = new ArrayList<ClienteModel>();
	private static int maxId = 1;
	@PostMapping("/NutriNET/Cliente")
	public ResponseEntity<?> crear(@RequestBody ClienteModel cliente) {

		System.out.println(cliente.getNombre());
		System.out.println(cliente.getApellidos());
		System.out.println(cliente.getNombre_usuario());
		System.out.println(cliente.getCorreo_electronico());
		System.out.println(cliente.getContrasena());
		if (existeCorreo(cliente.getCorreo_electronico())) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El correo ya existe");
		}
		if (existeUsuario(cliente.getNombre_usuario())) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El usuario ya existe");
		}
		cliente.setCliente_id(maxId++);
		listaClientes.add(cliente);
		if (buscarClientePorId(cliente.getCliente_id()) == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error al insertar el cliente");
		} else {
			return ResponseEntity.ok(cliente);
		}

	}

	@GetMapping("/NutriNET/Cliente/{cliente_id}")
	public ResponseEntity<?> read(@PathVariable("cliente_id") int cliente_id) {
		Integer idInt = cliente_id;
		ClienteModel clienteEncontrado = this.buscarClientePorId(idInt);

		if (clienteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente No encontrado");
		} else {
			return ResponseEntity.ok(clienteEncontrado);
		}
	}

	@GetMapping("/NutriNET/Cliente")
	public ResponseEntity<?> readAll() {
		if (listaClientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, No hay clientes");
		} else {
			return ResponseEntity.ok(listaClientes);
		}

	}

	@PutMapping("NutriNET/Cliente/{cliente_id}")
	public ResponseEntity<?> updateUserPesoEstatura(@PathVariable("cliente_id") int cliente_id,
			@RequestBody ClienteModel cliente) {
		System.out.println("el geb?: "+cliente.getGeb());
		for (ClienteModel clienteModel : listaClientes) {
			if (clienteModel.getCliente_id().equals(cliente_id)) {
				clienteModel.setEdad(cliente.getEdad());
				clienteModel.setEstatura(cliente.getEstatura());
				clienteModel.setPeso(cliente.getPeso());
				clienteModel.setGeb(cliente.getGeb());
				return ResponseEntity.ok(clienteModel);
			}

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente No encontrado");
	}
	/*
	 {
			"nombre": "Juan",
			"apellidos": "Perez Hernandez",
			"nombre_usuario": "Ju",
			"correo_electronico": "jperez@hotmail.com",
			"contrasena": "juanitoperez"
			}
			{
	"nombre": "Jose",
	"apellidos": "Flores Garcia",
	"nombre_usuario": "house",
	"correo_electronico": "jflores@hotmail.com",
	"contrasena": "123456"
}

	 */
	private ClienteModel buscarClientePorId(Integer id) {
		for (ClienteModel clienteModel : listaClientes) {
			if (clienteModel.getCliente_id().equals(id)) {
				return clienteModel;
			}
		}
		return null;
	}

	private Boolean existeCorreo(String correo) {
		for (ClienteModel clienteModel : listaClientes) {
			if (clienteModel.getCorreo_electronico().equals(correo)) {
				return true;
			}
		}
		return false;
	}

	private Boolean existeUsuario(String usuario) {
		for (ClienteModel clienteModel : listaClientes) {
			if (clienteModel.getNombre_usuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

}
