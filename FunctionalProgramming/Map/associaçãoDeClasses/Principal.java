

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Associate;
import entities.Department;

public class Principal {
	public static void main (String [] args) {
		
		// Variáveis
		List<Associate> associateList = new ArrayList<>();
		List<Department> departmentList = new ArrayList<>();
		
		Department technology = new Department("Tecnologia");
		Department rh = new Department("RH");
		Department marketing = new Department("Marketing");
				
		associateList.add(new Associate("Igor", "Borba", technology));
		associateList.add(new Associate("Bruno", "Silva", rh));
		associateList.add(new Associate("Felipe", "Silva", technology));
		associateList.add(new Associate("Andressa", "Flores", rh));
		
		departmentList.add(technology);
		departmentList.add(rh);
		departmentList.add(marketing);
		
		
		// LÓGICA: Functional Interfaces para guardar lógica numa variável
		Function<Associate, String> findDepartment = (Associate associate) -> associate.getDepartment().getName();
		
		
		
		// STREAM para aplicar lógica
		// Listar departamentos -> listar associados em cada departamento
		Map<String, List<Associate>> groupByDepartment = associateList.stream()
																			   .collect(Collectors.groupingBy(findDepartment));

			// Log para ver o que está populado em groupByDepartment
		    /*System.out.println(groupByDepartment.entrySet());
			for (Department department : departmentList) {
				System.out.println(department);
				System.out.println(groupByDepartment.get(department.getName()));
			}*/
			
		groupByDepartment.forEach((String department, List<Associate> associates) -> { 
			System.out.println(department);
			associates.forEach( associate -> System.out.print(associate + "\n"));
		});
		
		
	}
}
