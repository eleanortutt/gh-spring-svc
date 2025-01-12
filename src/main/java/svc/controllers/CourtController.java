package svc.controllers;

import javax.inject.Inject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import svc.dto.CourtsDTO;
import svc.logging.LogSystem;
import svc.managers.*;
import svc.models.*;


@RestController
@EnableAutoConfiguration
@RequestMapping("inveo-api/courts")
public class CourtController
{	
	@Inject
	CourtManager _courtManager;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	CourtsDTO GetCourts()
	{
		return new CourtsDTO(_courtManager.GetAllCourts());
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	Court GetCourt(@PathVariable("id") Integer id)
	{
		if (id == null)
		{
			LogSystem.LogEvent("Null id passed to controller");
		}
		
		return _courtManager.GetCourtById(id);
	}
}
