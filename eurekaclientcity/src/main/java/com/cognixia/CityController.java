package com.cognixia;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CityController {
	
	@Autowired
	CityUtil cs;
	
	@GetMapping("/{country}")
	public String getCities(@PathVariable String country) {
		List<String> list = new Vector<>();
		String l = new String("<table border=1>");
		Map<String, List<String>> cities = cs.getList();
		if(cities.get(country)!=null) {
			list = cities.get(country);
			for(String city: list) l += "<tr><td>"+city+"</td></tr>";
			l+=new String("</table>");
		}
		else {
			l = "Your country is not recognized :'( <br> Please enter the name "
					+ "of the country you're interested in in the url";
		}
		return l;
	}
}
