import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Associate;

public class PrincipalMockJSON {
	public static void main (String [] args) {

		try {
			// MAPEAR JSON com Jackson
			String jsonString1 = "{ \"id\": \"123e4567-e89b-42d3-a456-556642440000\", \"firstName\": \"Igor\", \"lastName\": \"Borba\", \"department\": { \"name\": \"TI\" } }";
			String jsonString2 = "{ \"id\": \"893e4567-e89b-42d3-a456-556642440045\", \"firstName\": \"Daniela\", \"lastName\": \"Silva\", \"department\": { \"name\": \"RH\" } }";
			String jsonString3 = "{ \"id\": \"453e4567-e89b-42d3-a456-556642440013\", \"firstName\": \"Ana\", \"lastName\": \"Fontoura\", \"department\": { \"name\": \"TI\" } }";
			
            ObjectMapper objectMapper = new ObjectMapper();
            Associate associate1 = objectMapper.readValue(jsonString1, Associate.class);
            Associate associate2 = objectMapper.readValue(jsonString2, Associate.class);        
            Associate associate3 = objectMapper.readValue(jsonString3, Associate.class);        
            
            
            // PROGRAMAÇÃO FUNCIONAL
            
    		// Variáveis
    		List<Associate> associateList = new ArrayList<>();

    		associateList.add(associate1);
    		associateList.add(associate2);
    		associateList.add(associate3);

    		// LÓGICA: Functional Interfaces para guardar lógica numa variável
    		Function<Associate, String> findDepartment = (Associate associate) -> associate.getDepartment().getName();

    		// STREAM para aplicar lógica
    		// Listar departamentos -> listar associados em cada departamento
    		Map<String, List<Associate>> groupByDepartment = associateList.stream()
    				.collect(Collectors.groupingBy(findDepartment));

    		// Log para ver o que está populado em groupByDepartment
    		/*
    		 * System.out.println(groupByDepartment.entrySet()); for (Department department
    		 * : departmentList) { System.out.println(department);
    		 * System.out.println(groupByDepartment.get(department.getName())); }
    		 */

    		groupByDepartment.forEach((String department, List<Associate> associates) -> {
    			System.out.println(department);
    			associates.forEach(associate -> System.out.print(associate + "\n"));
    		});
            

    		
		
		} catch (Exception e) {
            e.printStackTrace();
        }		
	}
}
