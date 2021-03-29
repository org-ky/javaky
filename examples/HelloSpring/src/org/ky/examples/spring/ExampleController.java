package org.ky.examples.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * L'annotazione "@Controller" indica che la seguente classe serve il ruolo di un controllore.
 */
@Controller
public class ExampleController {
	
	/*
	 * Il seguente metodo verrà invocato tramite l'URL: "http://localhost:8080/HelloSpring/example/hello"
	 * 
	 * HelloSpring     -> nome applicazione deployata
	 * example         -> url pattern a cui risponde la servlet di Spring(web.xml)
	 * hello           -> il metodo seguente
	 * @RequestMapping -> questa annotazione viene utilizzata per mappare la URL("/hello") o un intero ramo o un particolare metodo di 
	 *                    gestione e produrre(produces) in uscita una risposta(Object) in formato JSON
	 * @ResponseBody   -> questa annotazione indica che il valore di ritorno(Object) restituito dal metodo dovrebbe essere associato al body 
	                      della risposta 
	 */
	@ResponseBody
	@RequestMapping(value = "/hello", produces={"application/json"})
	public Object hello(){
		
		String result = "Ciao, io sono il controller!";
		System.out.println(result);
		
		Response res = new Response();
		res.setCodError(0);
		res.setDescError("no error");
		res.setPayload(result);
		return res;
	}

}
