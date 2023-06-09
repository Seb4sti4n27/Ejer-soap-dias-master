package pe.edu.idat.dsw1soapJ19;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Dia;
//import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DiasRepository {

	private static final Map<String, Dia> dias = new HashMap<>();

	@PostConstruct
	public void initData() {
		Dia lunes = new Dia();
		lunes.setName("lunes");
		lunes.setTraduccion("Monday");
		dias.put(lunes.getName(), lunes);

		Dia martes = new Dia();
		martes.setName("martes");
		martes.setTraduccion("tuesday");
		dias.put(martes.getName(), martes);

		Dia sabado = new Dia();
		sabado.setName("sabado");
		sabado.setTraduccion("saturday");
		dias.put(sabado.getName(), sabado);

		Dia domingo = new Dia();
		domingo.setName("domingo");
		domingo.setTraduccion("sunday");
		dias.put(domingo.getName(), domingo);

	}

	public Dia findDia(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return dias.get(name);
	}

}
