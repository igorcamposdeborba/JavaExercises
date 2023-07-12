import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import entities.Associate;
import entities.Department;

public class PrincipalOrientadoObjetos {
	public static void main (String [] args) {
		
		// Variáveis
		List<Associate> associateList = new ArrayList<>();
				
		Department technology = new Department("Tecnologia");
		Department rh = new Department("RH");
		Department marketing = new Department("Marketing");
						
		associateList.add(new Associate("Igor", "Borba", technology));
		associateList.add(new Associate("Bruno", "Silva", rh));
		associateList.add(new Associate("Felipe", "Silva", technology));
		associateList.add(new Associate("Andressa", "Flores", rh));
				
		// Ordenar ArrayList para mostrar as áreas agrupadas
		// Único local com programação funcional para ordenar ArrayList porque é dinâmico
		associateList.sort(Comparator.comparing( (Associate associate) -> associate.getDepartment().getName() )); 
		
		System.out.println("Imprimir departamento e colaboradores");
		for (int i=0 ; i<associateList.size(); i++) {
			Department actualDepartment = associateList.get(i).getDepartment();
			int index = i;
			if (++index < associateList.size() && actualDepartment.equals(associateList.get(index++).getDepartment())) {
				System.out.println(associateList.get(i).getDepartment());
			}
			
			System.out.println(associateList.get(i).toString());

		}
	}
}
